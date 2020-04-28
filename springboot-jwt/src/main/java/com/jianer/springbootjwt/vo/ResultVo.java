package com.jianer.springbootjwt.vo;

/**
 * @author 杨兴健
 * @Date 2020/4/27 16:53
 */
public class ResultVo {
    private int code;
    private String message;
    private Object data;

    /**
     * 自定义状态码和信息
     * @param code
     * @param message
     * @param data
     */
    public ResultVo(int code,String message,Object data) {
        this.code = code;
        this.message  = message;
        this.data = data;
    }

    /**
     * 只返回数据，默认成功
     * @param data
     */
    public ResultVo(Object data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getMessage();
        this.data = data;
    }

    /**
     * 返回状态码和数据
     * @param statusCode
     * @param data
     */
    public ResultVo(StatusCode statusCode,Object data) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
        this.data = data;

    }

    /**
     * 只返回状态码，默认数据为null
     * @param statusCode
     */
    public ResultVo(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
        this.data = null;
    }
}
