package com.jianer.springbootjwt.vo;

/**
 * @author 杨兴健
 * @Date 2020/4/27 16:56
 */
public enum ResultCode implements StatusCode{
    /**
     *
     */
    SUCCESS(200,"请求成功"),
    FAILED(500,"请求失败"),
    LOGIN_FAILED_1(1001,"用户名或密码为空"),
    LOGIN_FAILED_2(1002,"用户名或密码错误");

    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
