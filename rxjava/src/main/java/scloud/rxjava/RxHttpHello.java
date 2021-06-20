package scloud.rxjava;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import rx.Observable;
import rx.Subscriber;

public class RxHttpHello {

    public void execute() {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    subscriber.onNext(getBaiduPage());
                } catch (Throwable ex) {
                    subscriber.onError(ex);
                }
            }
        });

        observable.subscribe(LogUtil::log);
    }

    private String getBaiduPage() throws Exception {
        OkHttpClient okHttpClient = (new OkHttpClient.Builder()).build();
        Request request = new Request.Builder()
                .get()
                .url("http://www.baidu.com")
                .build();
        return okHttpClient.newCall(request).execute().body().string();
    }
}
