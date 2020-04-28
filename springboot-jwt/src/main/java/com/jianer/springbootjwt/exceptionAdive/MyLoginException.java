package com.jianer.springbootjwt.exceptionAdive;

/**
 * @author 杨兴健
 * @Date 2020/4/27 9:39
 */
public class MyLoginException extends RuntimeException {
    public MyLoginException(String s) {
        super(s);
    }
}
