package com.qs.base.app;

import android.app.Application;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：BaseApplication
 */
public class BaseApplication extends Application {

    private static BaseApplication mContext;

    public static BaseApplication getAppContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
}
