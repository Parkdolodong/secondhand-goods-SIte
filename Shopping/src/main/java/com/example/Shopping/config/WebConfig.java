package com.example.Shopping.config;



import com.example.Shopping.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/mgmt/**") // 적용할 URL 패턴을 설정합니다.
//                .excludePathPatterns("/sign"); // 제외할 URL 패턴을 설정합니다.
//    }
}