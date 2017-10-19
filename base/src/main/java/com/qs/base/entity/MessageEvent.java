package com.qs.base.entity;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：EventBus事件消息实体
 */
public class MessageEvent {

    // 重新登录回调码
    final public static int LOGIN = 0;// 进行登录操作
    final public static int EXIT = 1;// 退出程序

    // 有新消息回调码
    final public static int HAS_NEW_NOTICE = 3;

    // 头像更改回调码
    final public static int USER_CODE_OVER = 30;
    final public static int USER_CODE_PHOTO = 31;
    final public static int USER_CODE_ALUM = 32;

    // 进程汇报回调码
    final public static int REPORT_CODE_OVER = 40;
    final public static int REPORT_CODE_PHOTO = 41;
    final public static int REPORT_CODE_ALUM = 42;
    final public static int REPORT_CODE_FILE = 43;
    final public static int REPORT_CODE_EVENT = 44;

    // 事件修改回调码
    final public static int EVENT_CODE_OVER = 50;
    final public static int EVENT_CODE_PHOTO = 51;
    final public static int EVENT_CODE_ALUM = 52;
    final public static int EVENT_CODE_FILE = 53;
    final public static int EVENT_CODE_EVENT = 54;

    // 通过模板创建事件回调码
    final public static int EVENT_BY_TEMPLATE_CODE_OVER = 60;
    final public static int EVENT_BY_TEMPLATE_CODE_PHOTO = 61;
    final public static int EVENT_BY_TEMPLATE_CODE_ALUM = 62;
    final public static int EVENT_BY_TEMPLATE_CODE_FILE = 63;
    final public static int EVENT_BY_TEMPLATE_CODE_EVENT = 64;

    // 节点编辑回调码
    final public static int NODE_CODE_OVER = 70;
    final public static int NODE_CODE_PHOTO = 71;
    final public static int NODE_CODE_ALUM = 72;
    final public static int NODE_CODE_FILE = 73;
    final public static int NODE_CODE_EVENT = 74;

    // 模板编辑回调码
    final public static int TEMPLATE_CODE_OVER = 80;
    final public static int TEMPLATE_CODE_PHOTO = 81;
    final public static int TEMPLATE_CODE_ALUM = 82;
    final public static int TEMPLATE_CODE_FILE = 83;
    final public static int TEMPLATE_CODE_EVENT = 84;

    // 评论回调码
    final public static int COMMENT_CODE_OVER = 90;
    final public static int COMMENT_CODE_PHOTO = 91;
    final public static int COMMENT_CODE_ALUM = 92;
    final public static int COMMENT_CODE_FILE = 93;
    final public static int COMMENT_CODE_EVENT = 94;

    // 百度定位回调码
    final public static int BD_LOCATION_CODE = 101;
    final public static int BD_LOCATION_ERROR_CODE = 102;

    // 结束创建
    final public static int CREATE_EVENT_OVER = 201;

    private String message;
    private int code;
    private Object value;

    public MessageEvent(int code, String message, Object value) {
        this.code = code;
        this.message = message;
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
