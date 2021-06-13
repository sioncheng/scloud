package scloud.rxjava;

import rx.Single;

public class SingleHello {

    public void hello() {
        Single<String> single = Single.create(s -> s.onSuccess("hello"));
        single.subscribe(System.out::println);
    }
}
