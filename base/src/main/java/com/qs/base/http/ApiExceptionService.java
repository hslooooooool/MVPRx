package com.qs.base.http;

import android.net.ParseException;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.JsonParseException;
import com.qs.base.http.entity.ApiException;
import com.qs.base.http.entity.ErrorCode;
import com.qs.base.http.entity.ServerException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.HttpException;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：统一处理异常类
 */
public class ApiExceptionService {

    private static String TAG = "HandleException";

    // 对应HTTP的状态码
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;

    public static ApiException handleException(Throwable e) {
        Log.e(TAG, e.toString());

        ApiException ex;
        if (e instanceof HttpException) {
            // HTTP错误
            HttpException httpException = (HttpException) e;
            ex = new ApiException(e, ErrorCode.HTTP_ERROR);
            switch (httpException.code()) {
                case UNAUTHORIZED:
                case FORBIDDEN:
                case NOT_FOUND:
                case REQUEST_TIMEOUT:
                case GATEWAY_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    // 均视为网络错误
                    ex.setDisplayMessage("网络错误");
                    break;
            }
            return ex;
        } else if (e instanceof ServerException) {
            // 服务器返回的错误
            ServerException resultException = (ServerException) e;
            ex = new ApiException(resultException, resultException.getCode());
            if (TextUtils.isEmpty(resultException.getMsg())) {
                ex.setDisplayMessage("服务器异常");
            } else {
                ex.setDisplayMessage(resultException.getMsg());
            }
            return ex;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            // 均视为解析错误
            ex = new ApiException(e, ErrorCode.PARSE_ERROR);
            ex.setDisplayMessage("解析错误");
            return ex;
        } else if (e instanceof ConnectException) {
            // 均视为网络错误
            ex = new ApiException(e, ErrorCode.NETWORK_ERROR);
            ex.setDisplayMessage("连接失败");
            return ex;
        } else if (e instanceof SocketTimeoutException) {
            // 访问超时
            ex = new ApiException(e, ErrorCode.BACK_ERROR);
            ex.setDisplayMessage("访问超时");
            return ex;
        } else {
            ex = new ApiException(e, ErrorCode.UNKNOWN);
            // 未知错误
            ex.setDisplayMessage("未知错误");
            return ex;
        }
    }
}
