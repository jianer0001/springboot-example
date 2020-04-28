package com.jianer.springbootjwt.exceptionAdive;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.jianer.springbootjwt.vo.ResultCode;
import com.jianer.springbootjwt.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 杨兴健
 * @Date 2020/4/27 9:49
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MyLoginException.class)
    public String loginException(MyLoginException e) {
        return e.getMessage();
    }

    @ExceptionHandler(TokenExpiredException.class)
    public String tokenExpiredException(TokenExpiredException e) {
        return e.getMessage();
    }

    @ExceptionHandler(JWTVerificationException.class)
    public String jwtverificationexception(JWTVerificationException e){
        return e.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public String exception(Exception e) {
        log.error("系统错误",e);
        return e.getMessage();
    }

    @ExceptionHandler(BindException.class)
    public ResultVo bindException(BindException e) {
        log.error("验证请求参数错误",e);
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return new ResultVo(ResultCode.VALIDATE_ERROR,objectError.getDefaultMessage());
    }
    @ExceptionHandler(AppException.class)
    public ResultVo bindException(AppException e) {
        return new ResultVo(e.getCode(),e.getMsg(),e.getMessage());
    }

}
