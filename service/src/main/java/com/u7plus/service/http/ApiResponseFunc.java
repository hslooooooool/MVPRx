package com.u7plus.service.http;

import com.qs.base.entity.BaseResult;
import com.u7plus.service.http.entity.ServerException;

import rx.functions.Func1;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：拦截固定格式的公共数据类型Response<T>,判断里面状态码
 */
public class ApiResponseFunc<T> implements Func1<BaseResult<T>, T> {

    @Override
    public T call(BaseResult<T> result) {
        if (result.isError()) {
            throw new ServerException(201, "未知异常");
        }
        return result.getResults();
    }
}