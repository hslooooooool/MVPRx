package com.qs.base.http.interceptor;

import com.qs.base.http.entity.ApiException;

import rx.Subscriber;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：请求错误处理类
 */
public abstract class ApiExceptionService<T> extends Subscriber<T> {

    /**
     * 错误回调
     *
     * @param ex 错误实体
     */
    protected abstract void onError(ApiException ex);

    @Override
    public void onError(Throwable e) {
        if (e instanceof ApiException) {
            onError((ApiException) e);
        } else {
            onError(new ApiException(e, 123));
        }
    }
}
