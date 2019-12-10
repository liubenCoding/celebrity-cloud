package com.lb.celebrity_server_user.exception;

import com.lb.server_common.bean.ApiResult;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2016/12/2.
 */
@Getter
@Setter
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1227895436369906983L;

    /**
     * 状态码
     */
    private int code;

    private ApiResult apiResult;

    private String error;

    public BusinessException(ApiResult apiResult, String error, Throwable cause) {
        super(apiResult.getMsg(), cause);
        this.code = apiResult.getCode();
        this.apiResult = apiResult;
        this.error = error;
    }

    public BusinessException(ApiResult apiResult, String error) {
        super(apiResult.getMsg());
        this.code = apiResult.getCode();
        this.apiResult = apiResult;
        this.error = error;
    }

    public BusinessException(ApiResult apiResult) {
        super(apiResult.getMsg());
        this.code = apiResult.getCode();
        this.apiResult = apiResult;
    }
}
