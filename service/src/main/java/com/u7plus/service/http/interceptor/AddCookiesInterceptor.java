package com.u7plus.service.http.interceptor;

import android.content.Context;

import com.qs.base.utils.LogUtil;
import com.u7plus.service.preferences.SPService;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.functions.Action1;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：添加COOKIE拦截器
 */
public class AddCookiesInterceptor implements Interceptor {
    private Context context;

    public AddCookiesInterceptor(Context context) {
        super();
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request.Builder builder = chain.request().newBuilder();
        Observable.just(SPService.getCookie(context))
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String cookie) {
                        // 添加cookie
                        builder.addHeader("Cookie", cookie);
                        LogUtil.e("call: 添加Cookie进HttpHeader");
                    }
                });
        return chain.proceed(builder.build());
    }
}