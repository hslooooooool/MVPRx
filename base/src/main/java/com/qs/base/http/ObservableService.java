package com.qs.base.http;

import com.qs.base.entity.BaseResult;

import rx.Observable;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：统一请求处理方式
 */
public class ObservableService {

    /**
     * 设置统一的请求处理
     *
     * @param observable 请求观察者
     * @param <T>        返回的数据对象（BaseResult中的data）
     * @return 请求观察者
     */
    public static <T> Observable setObservable(Observable<BaseResult<T>> observable) {
        return observable.map(new ApiResponseFunc<>())
                        .onErrorResumeNext(new HttpErrorFunc<>())
                        .compose(RxSchedulers.switchThread());
    }
}
