package com.lb.celebrity_server_user.service.impl;

import com.lb.celebrity_server_user.mapper.UserMapper;
import com.lb.celebrity_server_user.model.entity.User;
import com.lb.celebrity_server_user.param.LoginParam;
import com.lb.celebrity_server_user.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author: 刘奔
 * @date: 2019/9/18
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User login(LoginParam param) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username", param.getUsername());
        User user = userMapper.selectOneByExample(example);
        if (!user.getPassword().equals(param.getPassword())) {
            return null;
        }
        return user;
    }
}
