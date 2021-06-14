package scloud.rxjava;

import rx.Observable;

import java.time.LocalDateTime;

public class RxException {

    public void exception() {
        Observable<String> os = Observable.create(s -> {
            s.onNext("one");
            s.onNext("two");
            if (LocalDateTime.now().getSecond() % 2 == 0) {
                s.onError(new Exception("oops"));
            } else {
                s.onCompleted();
            }
        });

        os.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("that's all"));
    }
}
