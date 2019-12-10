package com.lb.celebrity_server_user.mapper;

import com.lb.celebrity_server_user.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**

    @author: 刘奔
    @date: 2019/9/18
*/   
@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {
}