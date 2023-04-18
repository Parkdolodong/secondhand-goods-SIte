package com.example.Shopping.service;

import com.example.Shopping.dto.UserAddressDto;
import com.example.Shopping.dto.UserDto;
import com.example.Shopping.entity.UserAddress;
import com.example.Shopping.repository.UserAddressRepository;
import com.example.Shopping.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserAddressRepository userAddressRepository;

    @Test
    void signInUser() {
        var addr = UserAddress.builder().address("경상북도 경산시 진량읍")
                .zonecode(38449)
                .detailedaddress("101호")
                .build();

        var user1 = UserDto.builder().id("parkdong")
                .password("1234")
                .name("박동진")
                .email("park@naver.com")
                .phoneNumber("01012345678")
                .userAddress(addr)
                .build();

        System.out.println(addr);
        System.out.println(user1);
    }

    @Test
    void registerUser() {
    }

    @Test
    void finalAllUser() {
    }
}