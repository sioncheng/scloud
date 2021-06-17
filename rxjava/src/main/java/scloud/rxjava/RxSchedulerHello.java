package scloud.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.internal.util.ActionSubscriber;
import rx.schedulers.Schedulers;

public class RxSchedulerHello {
    public void execute() {



        Observable<Integer> observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                LogUtil.log("call");
                subscriber.onNext(1);
                subscriber.onNext(2);
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).observeOn(Schedulers.computation());

        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                LogUtil.log(String.format("on next %d", integer));
            }
        };

        observable.subscribe(subscriber);
    }
}
