package com.example.Shopping.service;

import com.example.Shopping.dto.UserAddressDto;
import com.example.Shopping.dto.UserDto;
import com.example.Shopping.entity.User;
import com.example.Shopping.entity.UserAddress;
import com.example.Shopping.repository.UserAddressRepository;
import com.example.Shopping.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser() {
        UserDto userDto = new UserDto();
        userDto.setId("test1234");
        userDto.setPassword("password");
        userDto.setName("John Doe");
        userDto.setEmail("johndoe@example.com");
        userDto.setPhoneNumber("123-456-7890");

        User user = new User();
        user.setId("test1234");
        user.setPassword("password");
        user.setName("John Doe");
        user.setEmail("johndoe@example.com");
        user.setPhoneNumber("123-456-7890");

        when(userRepository.save(user)).thenReturn(user);

        UserDto result = userService.registerUser(userDto);

        assertNotNull(result);
        assertThat(result.getId()).isEqualTo(user.getId());
        assertThat(result.getPassword()).isEqualTo(user.getPassword());
        assertThat(result.getName()).isEqualTo(user.getName());
        assertThat(result.getEmail()).isEqualTo(user.getEmail());
        assertThat(result.getPhoneNumber()).isEqualTo(user.getPhoneNumber());
    }

    @Test
    public void testSignInUser() {
        // given
        UserDto userDto = new UserDto();
        userDto.setIdx(1L);
        userDto.setId("testId");
        userDto.setEmail("test@test.com");
        userDto.setPassword("password");
        userDto.setEmail("johndoe@example.com");
        userDto.setPhoneNumber("123-456-7890");


        when(userRepository.existsById(userDto.getId())).thenReturn(false);
        when(userRepository.existsByEmail(userDto.getEmail())).thenReturn(false);

        // when
        UserDto result = userService.signInUser(userDto);

        // then
        assertNotNull(result);
        assertEquals(userDto.getId(), result.getId());
        assertEquals(userDto.getEmail(), result.getEmail());
        assertEquals(userDto.getPassword(), result.getPassword());
    }
}