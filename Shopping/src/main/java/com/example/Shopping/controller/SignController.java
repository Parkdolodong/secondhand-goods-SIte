package com.example.Shopping.controller;

import com.example.Shopping.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SignController {
    private final UserService userService;


    @GetMapping("/sign-up")
    public String signUpView() {
        return "sign-up";
    }

}
