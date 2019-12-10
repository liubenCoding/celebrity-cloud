package com.lb.server_common.bean;

public enum ApiResult {

    SUCCESS(20000, "响应成功"),

    ILLEGAL_PARAMS(40001, "参数错误"),

    UN_CORRECT_ACCOUNT_PWD(41001, "账号或密码错误"),

    UN_CORRECT_VERIFY_CODE(41002, "验证码不正确"),

    UN_REGISTERED_PHONE(41003, "手机号未注册"),

    SEND_SMS_FREQUENTLY(41004, "发送验证码频繁"),

    TO_LOGIN(41005, "请登录"),

    PASSWORD_ERROR(41006, "密码错误"),

    WAYBILL_SN_REPEAT(41007, "运单编号重复"),

    UN_SUPPORTED_OPERATION(41008, "不支持的操作"),

    NOT_SET_DEFAULT(41009, "未设置默认的收货人、发货人"),

    NOT_ENOUGH_OPERATE_AUTH(41010, "操作权限不足"),

    FREEZE_ACCOUNT(41011, "您的账号已被冻结"),

    TRUCK_LOCATION_ERROR(41012, "车辆信息查询失败"),

    TRUCK_NO_EXISTED(41013, "该车牌号已存在"),

    BUSINESS_FAIL(40005, "业务处理失败"),

    NOT_ENABLED_ACCOUNT(45001, "账号已被禁用"),

    ACCOUNT_EXPIRE(45002, "您的平台有效期已到，情续费后继续操作"),

    DATA_NOT_FOUND(40004, "数据不存在"),

    USERNAME_EXISTS(40008, "用户名已存在"),

    PHONE_HAS_REGISTERED(40010, "手机号已被注册"),

    BANNER_SIZE_LIMITED(40011, "广告图已达数量上限"),

    COMPANY_NAME_IS_EXISTED(40012, "公司名称已被使用"),

    SYSTEM_EXCEPTION(50000, "系统异常");

    private final int code;

    private final String msg;

    ApiResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
