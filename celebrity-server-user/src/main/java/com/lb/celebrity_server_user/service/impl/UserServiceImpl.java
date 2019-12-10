package com.lb.celebrity_server_user.service.impl;

import com.lb.celebrity_server_user.mapper.UserMapper;
import com.lb.celebrity_server_user.model.entity.User;
import com.lb.celebrity_server_user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**

    @author: 刘奔
    @date: 2019/9/18
*/
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
