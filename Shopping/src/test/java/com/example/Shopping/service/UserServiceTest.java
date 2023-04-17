package com.example.Shopping.service;

import com.example.Shopping.entity.User;
import com.example.Shopping.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    void 회원가입() {
        //given
        User user = new User();
        user.setId("parkdong");

        //when
        Long saveId = userService.join(user);

        //then
        User findUser = userService.findOne(saveId).get();
        assertThat(user.getName()).isEqualTo(findUser.getName());
    }
}