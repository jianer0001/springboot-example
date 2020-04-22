package com.jiaenr.springbootinterceptor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 杨兴健
 * @Date 2020/4/22 8:46
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    public LoginHandlerInterceptor2 loginHandlerInterceptor2;

    @Autowired
    public LoginHandlerInterceptor1 loginHandlerInterceptor1;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandlerInterceptor1)
                .addPathPatterns("/user/**");
        registry.addInterceptor(loginHandlerInterceptor2).
                    addPathPatterns("/user/**");
    }
}
