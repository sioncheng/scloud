package scloud.rxjava;

import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func0;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Slf4j
public class RxHello {

    public void createOb() {
        log.info("hello");

        Observable<String> p = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("one");
                subscriber.onNext("two");
                subscriber.onCompleted();
            }
        });

        p.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                log.info("completed");
            }

            @Override
            public void onError(Throwable e) {
                log.info("error");
            }

            @Override
            public void onNext(String s) {
                log.info("next {}", s);
            }
        });
    }


    public void deferOb() {
        List<String> messages = Arrays.asList("one", "two");

        Observable<String> p = Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                log.info("defer call");
                return Observable.from(messages);
            }
        });

        p.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                log.info("call {}", s);
            }
        });
    }

    public void window() throws Exception {
        final int max = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        Observable<String> eventStream = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                for (int c = 0; c < max; c++) {
                    String e = "event-" + c;
                    log.info("call {}", e);
                    try {
                        Thread.sleep(800);
                    } catch (Exception ex) {

                    }
                    subscriber.onNext(e);
                }
                subscriber.onCompleted();
            }
        });

        eventStream.window(1, TimeUnit.SECONDS)
                .subscribe(new Subscriber<Observable<String>>() {
                    int c = 0;
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Observable<String> os) {
                        log.info("on next {}", os);
                        os.subscribe(new Action1<String>() {
                            @Override
                            public void call(String ss) {
                                log.info("action action {}", ss);
                                c++;
                                if (c >= max) {
                                    countDownLatch.countDown();
                                }
                            }
                        });
                    }
                });




        countDownLatch.await();
    }
}
