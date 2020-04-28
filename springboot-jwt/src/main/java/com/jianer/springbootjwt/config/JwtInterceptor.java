package com.jianer.springbootjwt.config;

import com.jianer.springbootjwt.component.JwtUtil;
import com.jianer.springbootjwt.exceptionAdive.MyLoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 杨兴健
 * @Date 2020/4/26 22:07
 */
//@Configuration
public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    JwtUtil jwtUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*String token = request.getHeader("token");
        if (StringUtils.isEmpty(token) || !token.startsWith("token_")) {
            throw new MyLoginException("你还没登录，请登录");
        }
        if(jwtUtil.expire(token.substring(6))) {
            throw new MyLoginException("授权码过期，请重新登录");
        }*/

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
