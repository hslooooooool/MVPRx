package com.u7plus.service.http;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：Rx订阅线程切换设置
 */
public class RxSchedulers {

    /**
     * 订阅线程切换设置
     *
     * @param <T> 数据实体
     * @return 设置后的观察者
     */
    public static <T> Observable.Transformer<T, T> switchThread() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        // onNext()
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
