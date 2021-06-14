package scloud.rxjava;

import rx.Observable;

public class RxCacheHello {

    public void execute() {
        Observable<String> oa = Observable.create(s -> {
            LogUtil.log("create");
            s.onNext("one");
            s.onCompleted();
        });

        Observable<String> oac = oa.cache();

        oa.subscribe(LogUtil::log);
        oa.subscribe(LogUtil::log);

        oac.subscribe(LogUtil::log);
        oac.subscribe(LogUtil::log);

    }
}
