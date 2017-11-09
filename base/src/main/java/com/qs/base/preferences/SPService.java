package com.qs.base.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：SharePreferences保存工具类
 */
public class SPService {

    private static final String SHARED_PRE = "SHARED_PRE";
    private static final String COOKIE = "COOKIE";

    /**
     * 保存cookie数据
     *
     * @param context
     */
    public static void saveCookie(Context context, String cookie) {
        SharedPreferences sp = context.getSharedPreferences(SHARED_PRE, Context.MODE_PRIVATE);
        sp.edit().putString(COOKIE, cookie).commit();
    }

    /**
     * 获取cookie数据
     *
     * @param context
     * @return
     */
    public static String getCookie(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SHARED_PRE, Context.MODE_PRIVATE);
        return sp.getString(COOKIE, "");
    }
}
