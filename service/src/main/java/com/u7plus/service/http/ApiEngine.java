package com.u7plus.service.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qs.base.app.BaseApplication;
import com.u7plus.service.http.interceptor.AddCookiesInterceptor;
import com.u7plus.service.http.interceptor.NetWorkInterceptor;
import com.u7plus.service.http.interceptor.ReceivedCookiesInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：使用Retrofit+OkHttp搭建网路请求框架
 */
public class ApiEngine {

    public static boolean isUnitTest = false;
    private volatile static ApiEngine apiEngine;
    private Retrofit retrofit;

    // 设置缓存文件及大小100M
//    File cacheFile = new File(BaseApplication.getAppContext().getCacheDir(), "HttpCache");
//    Cache cache = new Cache(cacheFile, 1024 * 1024 * 100);

    ReceivedCookiesInterceptor receivedCookiesInterceptor = new ReceivedCookiesInterceptor(BaseApplication.getAppContext());
    AddCookiesInterceptor addCookiesInterceptor = new AddCookiesInterceptor(BaseApplication.getAppContext());

    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(12, TimeUnit.SECONDS)
            .writeTimeout(12, TimeUnit.SECONDS)
            // 网络拦截器
            .addNetworkInterceptor(new NetWorkInterceptor())
            // 日志拦截器
            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            // 获取COOKIE拦截器
            .addInterceptor(addCookiesInterceptor)
            // 植入COOKIE拦截器
            .addInterceptor(receivedCookiesInterceptor)
            // 将结果加入缓存
//            .cache(cache)
            .build();


    public static Retrofit getInstance(String baseUrl) {
        if (apiEngine == null) {
            synchronized (ApiEngine.class) {
                if (apiEngine == null) {
                    apiEngine = new ApiEngine(baseUrl);
                }
            }
        } else {
            if (apiEngine.retrofit.baseUrl().equals(baseUrl)) {
                return apiEngine.getRetrofit();
            } else {
                synchronized (ApiEngine.class) {
                    apiEngine = new ApiEngine(baseUrl);
                }
            }
        }
        return apiEngine.getRetrofit();
    }

    // 设置JSON转换时间格式
    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    private ApiEngine(String baseUrl) {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
