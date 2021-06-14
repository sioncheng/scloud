package scloud.rxjava;

import rx.Observable;
import rx.Observer;

import java.time.LocalDateTime;

public class ObserverHello {

    public void execute() {
        rx.Observer<String> observer = new rx.Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext " + s);
            }
        };


        Observable<String> observable = Observable.create(s -> {
            s.onNext("one");
            s.onNext("two");
            if (LocalDateTime.now().getNano() % 2 == 0) {
                s.onError(new Exception("oops"));
            } else {
                s.onCompleted();
            }
        });


        observable.subscribe(observer);
    }

}
