package com.jianer.springbootjwt.vo;

/**
 * @author 杨兴健
 * @Date 2020/4/28 20:23
 */
public enum  AppCode implements StatusCode {
    /**
     *
     */
    APP_ERROR(2000,"业务异常"),
    VALIDATE_ERROR(2001,"参数异常");

    private int code;
    private String message;

    AppCode(int code, String message) {
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

    public AppCode setCode(int code) {
        this.code = code;
        return this;
    }

    public AppCode setMessage(String message) {
        this.message = message;
        return this;
    }
}
