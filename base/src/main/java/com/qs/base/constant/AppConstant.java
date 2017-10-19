package com.qs.base.constant;

import android.text.TextUtils;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：全局常量
 */
public class AppConstant {

    public static String URL = "http://genzongbao.com.cn/";

    public static String API_BASE_URL = "http://genzongbao.com.cn/";

    public static void setBaseUrl(String url) {
        API_BASE_URL = url;
    }

    public static String getBaseUrl() {
        if (TextUtils.isEmpty(API_BASE_URL)) {
            API_BASE_URL = URL;
        }
        return API_BASE_URL;
    }

    // 登录
    public static final String API_URL_LOGIN = getBaseUrl() + "auth/login";
    // 版本文件
    public static final String API_UPDATE_URL = getBaseUrl() + "resource/gzb_version.xml";
    // 关于
    public static final String API_ABOUT_URL = getBaseUrl() + "html/aboutUs.html";
    // 忘记密码
    public static final String API_FORGET_URL = getBaseUrl() + "auth/forget-password";
    // 用户资料
    public static final String API_USER_INFO_URL = getBaseUrl() + "auth/customer-edit?cusId=%s" + "&loginCusId=%s";
    // 意见反馈+cusId
    public static final String API_FEEDBACK_URL = getBaseUrl() + "feed_back/add?cusId=%s";
    // 拼接openId,实现微信登录
    public static final String API_WX_LOGIN_URL = getBaseUrl() + "auth/wxlogin?openId=";
    // 绑定邮件
    public static final String API_EMAIL_URL = getBaseUrl() + "/auth/email-binding-into?cusId=";

    // 全局临时常量
    public static boolean exit = false;
}
