package com.lb.server_common.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: liuben
 * @date: 2019/9/18
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUser implements Serializable {

    public static final String EMPLOYEE_LOGIN_ERROR_COUNT = "user:login:error:";

    public static final String EMPLOYEE_LOGIN_TOKEN_REDIS_KEY_PREFIX = "user:login:token:v1:";

    /** "身份信息"参数名称 */
    public static final String PRINCIPAL_ATTRIBUTE_NAME = CurrentUser.class.getName() + ".PRINCIPAL";

    public static final String EMPLOYEE_ID_PARAMETER_NAME = "userId";

    public static final String ACCOUNT_TYPE_NAME = "atype";

    public static final String LOGIN_DEVICE_TYPE = "dtype";

    private static final long serialVersionUID = -2338669778607213069L;

    /** 员工ID */
    private Long userId;

    /** 账号类型 */
    private Integer type;

    private String username;

    /** 设备类型（0:APP,1:PC） */
    private Integer deviceType;

    private String token;

    public CurrentUser(Long userId, String username, Integer type) {
        this.userId = userId;
        this.username = username;
        this.type = type;
    }

    public String toTokenString(){
        JSONObject result = new JSONObject(3);
        result.put(EMPLOYEE_ID_PARAMETER_NAME, userId);
        result.put(ACCOUNT_TYPE_NAME, type);
        result.put(LOGIN_DEVICE_TYPE, deviceType);
        return result.toJSONString();
    }
}
