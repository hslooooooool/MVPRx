package com.qs.base.http.interceptor;

import android.content.Context;

import com.qs.base.preferences.SPService;
import com.qs.base.utils.LogUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;

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
                .subscribe(cookie -> {
                    LogUtil.i("call: 添加Cookie进HttpHeader");

//                    builder.addHeader("Content-Type", "application/json; charset=UTF-8");
//                    builder.addHeader("Accept-Encoding", "gzip, deflate");
//                    builder.addHeader("Connection", "keep-alive");
//                    builder.addHeader("Accept", "application/json");
//                    builder.addHeader("Cookie", cookie);
                });
        return chain.proceed(builder.build());
    }
}