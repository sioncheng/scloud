package scloud.rxjava;

import rx.Observable;

import java.util.Arrays;

public class RxToSingleHello {

    public void execute() {
        Observable.from(Arrays.asList(1))
                .single()
                .subscribe(LogUtil::log);
    }
}
