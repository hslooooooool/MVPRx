package com.u7plus.service.http;

import rx.Observable;
import rx.functions.Func1;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：网络请求异常处理
 */
public class HttpErrorFunc<T> implements Func1<Throwable, Observable<T>> {

    @Override
    public Observable<T> call(Throwable throwable) {
        return Observable.error(ApiExceptionService.handleException(throwable));
    }
}