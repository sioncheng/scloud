package scloud.rxjava;

import rx.Completable;

public class CompletableHello {

    public void hello() {
        Completable completable = Completable.create(x -> x.onCompleted());
        completable.doOnCompleted(() -> System.out.println("do on completed"));
    }
}
