package scloud.rxjava;

import rx.Observable;
import rx.functions.Func0;

public class RxDeferHello {

    public void execute() {
        Observable<String> observable = Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                LogUtil.log("call");
                return Observable.just("hello");
            }
        });

        LogUtil.log(" ======== ");

        observable.subscribe(LogUtil::log);
    }
}
