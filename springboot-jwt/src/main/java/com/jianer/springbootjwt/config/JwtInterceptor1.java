package com.jianer.springbootjwt.config;

import com.jianer.springbootjwt.annotation.TokenValidate;
import com.jianer.springbootjwt.component.JwtUtil;
import com.jianer.springbootjwt.exceptionAdive.MyLoginException;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author 杨兴健
 * @Date 2020/4/26 22:07
 */
@Configuration
public class JwtInterceptor1 implements HandlerInterceptor {

    @Resource
    JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            Method method = handlerMethod.getMethod();
            if(method.isAnnotationPresent(TokenValidate.class)) {
                TokenValidate annotation = method.getAnnotation(TokenValidate.class);
                if(annotation.validate()) {

                    if(StringUtils.isEmpty(token)) {
                        throw new MyLoginException("授权码为空");
                    }
                    jwtUtil.verifyToken(token.substring(6));
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
