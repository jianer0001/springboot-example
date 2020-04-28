package com.jianer.springbootjwt.exceptionAdive;

import com.jianer.springbootjwt.vo.AppCode;
import com.jianer.springbootjwt.vo.StatusCode;

/**
 * @author 杨兴健
 * @Date 2020/4/28 20:33
 */
public class AppException extends RuntimeException{
    private int code;
    private String msg;

    /**
     * 手动设置异常
     * @param code
     * @param message 用于用户设置抛出错误详情
     */
    public AppException(StatusCode code, String message) {
        super(message);
        this.code = code.getCode();
        /**
         * 状态码配套的msg
         */
        this.msg = code.getMessage();
    }

    /**
     * 默认异常，使用APP_ERROR异常
     * @param message
     */
    public AppException(String message) {
        super(message);
        this.code = AppCode.APP_ERROR.getCode();
        this.msg = AppCode.APP_ERROR.getMessage();
    }

    public int getCode() {
        return code;
    }

    public AppException setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public AppException setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
