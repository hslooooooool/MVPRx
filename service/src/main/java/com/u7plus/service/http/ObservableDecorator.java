package com.u7plus.service.http;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：观察者装饰器
 */
public class ObservableDecorator {

    public static <T> Observable<T> decorate(Observable<T> observable) {
        Observable<T> newObservable;
        if (ApiEngine.isUnitTest) {
            newObservable = observable.subscribeOn(Schedulers.immediate())
                    .observeOn(Schedulers.immediate());
        } else {
            newObservable = observable.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .delay(2, TimeUnit.SECONDS, AndroidSchedulers.mainThread());
        }
        return newObservable;
    }
}
