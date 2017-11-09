package com.qs.base.http.interceptor;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：日志拦截器
 */
public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();

        long t1 = System.nanoTime();
        Log.i("OkHttp3==>", String.format("Sending request %s on %s%n%s", request.url()
                , chain.connection(), request.headers()));

        Response response = chain.proceed(request);

        long t2 = System.nanoTime();
        Log.i("OkHttp3==>", String.format("Received response for %s in %.1fms%n%s"
                , response.request().url(), (t2 - t1) / 1e6d, response.headers()));

        return response;
    }
}