package scloud.rxjava;

import rx.Observable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class RxIntervalHello {

    public void execute() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Observable.interval(500, TimeUnit.MILLISECONDS)
                .subscribe(l -> {
                   LogUtil.log(String.format("interval %d", l));
                   countDownLatch.countDown();
                });

        countDownLatch.await();
    }
}
