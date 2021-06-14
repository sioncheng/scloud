package scloud.rxjava;

import rx.Observable;
import rx.Subscriber;

public class LimitedSubscriber {

    public void execute(final int n) {
        Observable<Integer> infinite = Observable.create(s -> {
            int i = 0;
            while (!s.isUnsubscribed()) {
                s.onNext(i++);
            }
        });

        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            int r = 0;
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
                if (++r >= n) {
                    unsubscribe();
                }
            }
        };

        infinite.subscribe(subscriber);
    }
}
