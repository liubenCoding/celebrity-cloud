package com.lb.celebrity_server_user.controller;

/**
 * @author: liuben
 * @date: 2019/9/18
 */

import com.alibaba.fastjson.JSON;
import com.lb.server_common.bean.CurrentUser;
import com.lb.server_common.bean.ResponseData;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
public abstract class BaseApiController {

    /**
     * 获得登录人信息
     *
     * @return
     */
    protected CurrentUser getCurrentFromAuth() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        String infoStr = request.getHeader(CurrentUser.PRINCIPAL_ATTRIBUTE_NAME);
        if (StringUtils.isNotEmpty(infoStr)) {
            return JSON.parseObject(infoStr, CurrentUser.class);
        }
        return null;
    }

    /**
     * 错误信息
     *
     * @param bindingResult
     * @return
     */
    protected ResponseData errorMsg(BindingResult bindingResult) {
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        StringBuilder errorStr = new StringBuilder();
        for (ObjectError error : allErrors) {
            errorStr.append(error.getDefaultMessage()).append(" ");
        }
        return ResponseData.error(errorStr.toString());
    }
}
