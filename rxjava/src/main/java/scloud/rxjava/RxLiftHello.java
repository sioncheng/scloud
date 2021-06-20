package scloud.rxjava;

import rx.Observable;
import rx.Subscriber;

public class RxLiftHello {

    public void execute() {
        Observable.just(1,2,3,4,5)
                .lift(new Observable.Operator<String, Integer>() {
                    @Override
                    public Subscriber<? super Integer> call(Subscriber<? super String> subscriber) {
                        return new Subscriber<Integer>() {
                            @Override
                            public void onCompleted() {
                                subscriber.onCompleted();
                            }

                            @Override
                            public void onError(Throwable e) {
                                subscriber.onError(e);
                            }

                            @Override
                            public void onNext(Integer integer) {
                                subscriber.onNext(String.format("lift-%d", integer));
                            }
                        };
                    }
                }).subscribe(LogUtil::log);
    }
}
