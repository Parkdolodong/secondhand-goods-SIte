package com.example.Shopping.interceptor;

import com.example.Shopping.dto.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@Component
//
//public class LoginInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();
//        UserDto userDto = (UserDto) session.getAttribute("user");
//        if (userDto == null) {
//            response.sendRedirect("/sign/sign-in");
//            return false;
//        }
//        return true;
//    }
//}