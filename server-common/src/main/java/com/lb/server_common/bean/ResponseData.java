package com.lb.server_common.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author ck
 * @date 2018-11-09
 */
@Setter
@Getter
public class ResponseData<T> implements Serializable {

    private static final long serialVersionUID = 7712906009669100661L;

    private int code;

    private String msg;

    private T data;

    public static <T> ResponseData<T> ok() {
        return ResponseData.ok(null);
    }

    public static <T> ResponseData<T> okMsg(String msg) {
        ResponseData<T> responseData = new ResponseData();
        responseData.setCode(ApiResult.SUCCESS.getCode());
        responseData.setMsg(msg);
        return responseData;
    }

    public static <T> ResponseData<T> ok(T data) {
        return ResponseData.res(ApiResult.SUCCESS, data);
    }

    public static <T> ResponseData<T> error(String msg) {
        ResponseData<T> responseData = new ResponseData();
        responseData.setCode(ApiResult.BUSINESS_FAIL.getCode());
        responseData.setMsg(msg);
        return responseData;
    }

    public static <T> ResponseData<T> error(ApiResult apiResult) {
        return ResponseData.res(apiResult, null);
    }

    public static <T> ResponseData<T> res(ApiResult apiResult, T data) {
        ResponseData<T> responseData = new ResponseData();
        responseData.setCode(apiResult.getCode());
        responseData.setMsg(apiResult.getMsg());
        responseData.setData(data);
        return responseData;
    }
}
