package scloud.rxjava;

import rx.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class RxMerge {

    public void merge() {

        Function<List<String>, Observable<String>> f = sl -> {
            return Observable.create(s -> {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String t = Thread.currentThread().getName();
                        for (String str :
                                sl) {
                            s.onNext(String.format("[%s] %s", t, str));
                        }
                        s.onCompleted();
                    }
                });
                t.start();
            });
        };


        Observable<String> a = f.apply(Arrays.asList("one", "two", "three"));
        Observable<String> b = f.apply(Arrays.asList("four", "five", "six"));
        Observable<String> c = Observable.merge(a, b);
        c.subscribe(System.out::println);
    }
}
