package com.lb.celebrity_server_user.service;

import com.lb.celebrity_server_user.model.entity.User;
import com.lb.celebrity_server_user.param.LoginParam;

/**
 * @author: 刘奔
 * @date: 2019/9/18
 */
public interface AuthService {

    /**
     * 登录
     *
     * @param param
     * @return
     */
    User login(LoginParam param);
}
