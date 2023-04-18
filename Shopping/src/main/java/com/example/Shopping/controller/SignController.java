package com.example.Shopping.controller;

import com.example.Shopping.dto.UserAddressDto;
import com.example.Shopping.dto.UserDto;
import com.example.Shopping.service.UserAddressService;
import com.example.Shopping.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/sign")
@RequiredArgsConstructor
public class SignController {
    private final UserService userService;
    private final UserAddressService userAddressService;

    @GetMapping("/sign-up")
    public String signUpView() {
        return "sign/sign-up";
    }

    @GetMapping("/sign-in")
    public String singInView() {
        return "sign/sign-in";
    }


//    @PostMapping("/id_check")
//    public @ResponseBody String idCheck(@RequestParam("userid") String userid) {
//        String checkResult = userService.idCheck(userid);
//        return checkResult;
//    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signInUser(@RequestBody UserDto userDto) {
        var dto = userService.registerUser(userDto);
        if(dto.getIdx() != null) {
            dto.setResult("OK");
            return ResponseEntity.ok(dto);
        }
        dto.setResult("FAIL");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dto);
    }

    @PostMapping("/signupaddr")
    public ResponseEntity<UserAddressDto> registerAddr(@RequestBody UserAddressDto userAddressDto) {
        var dto = userAddressService.registerAddr(userAddressDto);
        if(dto.getIdx() != null) {
            dto.setResult("OK");
            return ResponseEntity.ok(dto);
        }
        dto.setResult("FAIL");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dto);
    }
}
