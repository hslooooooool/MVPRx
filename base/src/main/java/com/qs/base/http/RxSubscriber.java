package com.qs.base.http;

import android.util.Log;

import com.qs.base.http.entity.ApiException;
import com.qs.base.http.interceptor.ApiExceptionService;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：请求回调处理
 */
public   class RxSubscriber<T> extends ApiExceptionService<T> {

    @Override
    public void onStart() {
        super.onStart();

        Log.i("网络请求：", "onStart: 开始请求");
    }

    @Override
    protected void onError(ApiException ex) {

        Log.e("网络请求：", "onError: 请求异常");
    }

    @Override
    public void onCompleted() {

        Log.i("网络请求：", "onError: 请求完毕");
    }

    @Override
    public void onNext(T t) {

        Log.i("网络请求：", "onNext: 请求结果\n\n\n\n" + t.toString() + "\n\n\n\n");
    }
}
