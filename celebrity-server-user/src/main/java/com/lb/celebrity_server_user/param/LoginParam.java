package com.lb.celebrity_server_user.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: liuben
 * @date: 2019/9/18
 */
@Setter
@Getter
@ToString
public class LoginParam {

    /**
     * 用户名称
     */
    String username;

    /**
     * 密码
     */
    String password;
}
