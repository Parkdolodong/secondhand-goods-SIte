package com.example.Shopping.controller;

import com.example.Shopping.dto.LoginDto;
import com.example.Shopping.dto.UserDto;
import com.example.Shopping.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/sign")
@RequiredArgsConstructor
public class SignController {
    private final UserService userService;
    @GetMapping("/sign-up")
    public String signUpView() {
        return "sign/sign-up";
    }

    @GetMapping("/sign-in")
    public String singInView() {
        return "sign/sign-in";
    }

    /**
     * 회원가입
     */
    @PostMapping("/register")
    public ResponseEntity<?> signUp(@RequestBody UserDto dto, HttpServletResponse response) {
        try {
            UserDto savedUserDto = userService.signUser(dto);
            response.sendRedirect("/sign/sign-in");
            return ResponseEntity.ok(savedUserDto);
        } catch (DuplicateKeyException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Redirect Error");
        }
    }

    /**
     * 로그인
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto,  HttpSession session, HttpServletResponse response) throws IOException {
        UserDto userDto = userService.findByLoginInfo(loginDto);
        if (userDto != null) {
            session.setAttribute("user", userDto);
            System.out.println("---------------------------------------");
            System.out.println(session);
            System.out.println(userDto);
            System.out.println(loginDto);
            System.out.println("---------------------------------------");
            return ResponseEntity.ok(userDto);
        } else {
            return ResponseEntity.badRequest().body("아이디 또는 비밀번호가 일치하지 않습니다.");
        }
    }
    /**
     * 로그아웃
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


    /**
    * 실시간 아이디 체크
     */
    @PostMapping("/id_check")
    public ResponseEntity<Map<String, Object>> checkId(@RequestParam String userId) {
        Map<String, Object> response = new HashMap<>();
        boolean isExists = userService.isIdExists(userId);
        if (isExists) {
            response.put("message", "아이디가 이미 존재합니다.");
            response.put("result", "fail");
        } else {
            response.put("message", "사용 가능한 아이디입니다.");
            response.put("result", "success");
        }
        return ResponseEntity.ok(response);
    }
}
