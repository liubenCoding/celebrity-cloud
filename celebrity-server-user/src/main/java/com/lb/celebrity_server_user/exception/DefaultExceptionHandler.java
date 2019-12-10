/*
 * @project: awup
 * @module: aoup-wechat-restful
 * @author: zwq
 * @Date: 2016-12-02 19:00:42
 * @Copyright: 2016-2116 Zhanshu Team All rights reserved.
 * @Link: http://www.mobi-app.cn/   http://appof.cn/
 * Warning: The content is limited to the internal use of ZhanShu. Forbidden to leak and for other commercial purposes.
 */

package com.lb.celebrity_server_user.exception;

import com.lb.server_common.bean.ApiResult;
import com.lb.server_common.bean.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 *
 * @author ck
 * @date 2018-11-21
 */
@Slf4j
@ControllerAdvice
public class DefaultExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public ResponseData businessExceptionHandler(Exception ex) {
        log.error(ex.getMessage(), ex);
        BusinessException be = ((BusinessException) ex);
        return ResponseData.error(be.getApiResult());
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseData exceptionHandler(Exception ex) {
        log.error(ex.getMessage(), ex);
        return ResponseData.error(ApiResult.SYSTEM_EXCEPTION);
    }
}
