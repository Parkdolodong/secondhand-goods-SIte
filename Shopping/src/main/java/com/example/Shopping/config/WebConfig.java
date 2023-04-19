package com.example.Shopping.config;


import com.example.Shopping.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//    @Autowired
//    private LoginInterceptor loginInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor)
//                .excludePathPatterns("/sign/sign-in")
//                .excludePathPatterns("/sign/sign-up")
//                .excludePathPatterns("/resources/**"); // Interceptor에서 제외할 URL 패턴 설정
//    }
//}