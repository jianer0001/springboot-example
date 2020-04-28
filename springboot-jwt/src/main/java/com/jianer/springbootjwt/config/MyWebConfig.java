package com.jianer.springbootjwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 杨兴健
 * @Date 2020/4/27 9:41
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {
//    @Autowired
    JwtInterceptor jwtInterceptor;
    @Autowired
    JwtInterceptor1 jwtInterceptor1;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**").excludePathPatterns("/login/**");
        registry.addInterceptor(jwtInterceptor1).addPathPatterns("/**");
    }
}
