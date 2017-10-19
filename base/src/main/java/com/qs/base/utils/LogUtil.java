package com.qs.base.utils;

import android.util.Log;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：日志打印工具
 */
public class LogUtil {
    public static boolean isOpen = true;
    public static String TAG = "系统日志";

    public static void e(String msg) {
        if (isOpen) {
            Log.e(TAG, msg);
        }
    }

    public static void w(String msg) {
        if (isOpen) {
            Log.w(TAG, msg);
        }
    }

    public static void i(String msg) {
        if (isOpen) {
            Log.i(TAG, msg);
        }
    }

    public static void d(String msg) {
        if (isOpen) {
            Log.d(TAG, msg);
        }
    }

    public static void v(String msg) {
        if (isOpen) {
            Log.v(TAG, msg);
        }
    }
}
