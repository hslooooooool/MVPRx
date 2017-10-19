package com.qs.base.mvp;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：View接口
 */
public interface BaseView {
    /**
     * UI是否激活
     *
     * @return UI是否激活
     */
    boolean isActive();

    /**
     * 获取上下文
     *
     * @return 上下文
     */
    @NonNull
    Context getContext();

    /**
     * 显示消息
     *
     * @param msg 消息
     */
    void showToast(String msg);

    /**
     * 消息弹窗
     *
     * @param msg 消息
     */
    void showDialog(String msg);

    /**
     * 结束当前页面
     */
    void finishThis();
}