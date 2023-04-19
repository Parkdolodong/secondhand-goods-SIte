package com.example.Shopping.service;

import com.example.Shopping.dto.LoginDto;
import com.example.Shopping.dto.UserAddressDto;
import com.example.Shopping.dto.UserDto;
import com.example.Shopping.entity.UserAddress;
import com.example.Shopping.repository.UserAddressRepository;
import com.example.Shopping.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserAddressRepository userAddressRepository;
    @Autowired
    private UserRepository userRepository;

    @AfterEach
    void tearDown() {
        userAddressRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    void registerUserTest() {
        UserDto userDto = new UserDto();
        userDto.setId("user");
        userDto.setName("John Doe");
        userDto.setPassword("1234");
        userDto.setEmail("johndoe@example.com");
        userDto.setPhoneNumber("01012345679");

        UserAddressDto userAddressDto = new UserAddressDto();
        userAddressDto.setAddress("123 Main St");
        userAddressDto.setZonecode(1234);
        userAddressDto.setDetailedaddress("Apt 123");

        UserDto userDto1 = new UserDto();
        userDto1.setId("user1");
        userDto1.setName("John Doe");
        userDto1.setPassword("password");
        userDto1.setEmail("johndoe1@example.com");
        userDto1.setPhoneNumber("01012345678");

        UserAddressDto userAddressDto1 = new UserAddressDto();
        userAddressDto1.setAddress("123 Main St");
        userAddressDto1.setZonecode(1234);
        userAddressDto1.setDetailedaddress("Apt 123");

        userDto.setUserAddressDto(userAddressDto);
        userDto1.setUserAddressDto(userAddressDto1);

        UserDto registeredUserDto = userService.signUser(userDto);
        UserDto registeredUserDto1 = userService.signUser(userDto1);

        UserAddress userAddress = new UserAddress();
        userAddress.setAddress("123 Main St");
        userAddress.setZonecode(1234);
        userAddress.setDetailedaddress("Apt 123");
        UserAddress addr = userAddressRepository.save(userAddress);

        System.out.println(addr.getIdx());
        System.out.println(addr.getAddress());
        System.out.println(addr.getZonecode());
        System.out.println(addr.getDetailedaddress());

        assertThat(registeredUserDto).isNotNull();
        assertThat(registeredUserDto.getIdx()).isNotNull();
        assertThat(registeredUserDto.getName()).isEqualTo("John Doe");
        assertThat(registeredUserDto.getEmail()).isEqualTo("johndoe@example.com");
        assertThat(registeredUserDto.getPhoneNumber()).isEqualTo("01012345679");
        assertThat(registeredUserDto.getUserAddressDto()).isNotNull();
        assertThat(registeredUserDto.getUserAddressDto().getAddress()).isEqualTo("123 Main St");
        assertThat(registeredUserDto.getUserAddressDto().getZonecode()).isEqualTo(1234);
        assertThat(registeredUserDto.getUserAddressDto().getDetailedaddress()).isEqualTo("Apt 123");

        System.out.println(registeredUserDto.getIdx());
        System.out.println(registeredUserDto.getName());
        System.out.println(registeredUserDto.getEmail());
        System.out.println(registeredUserDto.getPhoneNumber());
        System.out.println(registeredUserDto.getUserAddressDto().getIdx());
        System.out.println(registeredUserDto.getUserAddressDto().getAddress());
        System.out.println(registeredUserDto.getUserAddressDto().getZonecode());
        System.out.println(registeredUserDto.getUserAddressDto().getDetailedaddress());


        LoginDto loginDto = new LoginDto();
        loginDto.setId("user");
        loginDto.setPassword("1234");

        System.out.println("------------------------------------------------------------");
        System.out.println(userDto.getId());
        System.out.println(userDto.getPassword());
        System.out.println(userRepository.findByIdAndPassword(loginDto.getId(), loginDto.getPassword()));
        System.out.println("------------------------------------------------------------");
    }
}