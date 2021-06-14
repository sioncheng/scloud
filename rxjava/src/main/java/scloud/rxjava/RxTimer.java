package scloud.rxjava;

import rx.Observable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class RxTimer {

    public void execute() throws Exception {
        CountDownLatch downLatch = new CountDownLatch(1);
        Observable.timer(1, TimeUnit.SECONDS)
                .subscribe(l -> {
                    LogUtil.log(String.format("onComplete %d", l));
                    downLatch.countDown();
                });
        downLatch.await();
        LogUtil.log("done");
    }
}
