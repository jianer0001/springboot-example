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
    VALIDATE_ERROR(2001,"参数校验失败");

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
