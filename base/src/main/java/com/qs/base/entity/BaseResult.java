package com.qs.base.entity;

/**
 * @author 华清松
 * @email 821034742@qq.com
 * @weixin hslooooooool
 * @doc 类说明：结果实体
 */
public class BaseResult<T> {

    private boolean error;

    private T results;

    public BaseResult() {

    }

    public final boolean isError() {
        return error;
    }

    public final void setError(boolean error) {
        this.error = error;
    }

    public final T getResults() {
        return results;
    }

    public final void setResults(T results) {
        this.results = results;
    }
}
