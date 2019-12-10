package com.lb.celebrity_server_user.service;

import com.lb.celebrity_server_user.model.entity.User;

/**
 * @author: liuben
 * @date: 2019/9/18
 */
public interface UserService {

    /**
     * 根据ID获取用户
     * @param id
     * @return
     */
    User getUserById(Long id);
}
