package com.qs.base.entity;

/**
 * @author 华清松
 * @time 2017/3/24 0024 14:27
 * @doc 描述：错误类型
 */
public enum ErrorCodeEnum {
    FAILUREINLINK("访问服务器失败，请检查网络连接"),
    SOCKETTIMEOUT("访问超时，服务器无响应"),
    SERVER_EXCEPTION("服务器未知错误"),
    APP_EXCEPTION("运行异常"),
    HAS_NEW_NOTICE("有新消息"),
    DATA_ERROR("数据错误"),
    NO_LOGIN("请先登录");
    private String title;

    private ErrorCodeEnum(String title) {
        this.title = title;
    }

    public String title() {
        return title;
    }
}
