package com.example.Shopping.service;

import com.example.Shopping.dto.UserAddressDto;
import com.example.Shopping.dto.UserDto;
import com.example.Shopping.entity.UserAddress;
import com.example.Shopping.entity.User;
import com.example.Shopping.repository.UserAddressRepository;
import com.example.Shopping.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserAddressRepository userAddressRepository;

    /**
     * 회원 가입
     */

    public UserDto signInUser(UserDto dto) {
        // 아이디 중복 검사
        if(userRepository.existsById(dto.getId())) {
            throw new RuntimeException("중복된 아이디입니다.");
        }
        // 이메일 중복 검사
        if(userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("중복된 이메일입니다.");
        }
        // 회원 정보 저장
        User user = userRepository.save(dtoToEntity(dto));
        return entityToDto(user);
    }

    /**
     * 사용자 등록 및 수정
     */
    public UserDto registerUser(UserDto dto) {
        User user = null;
        if(dto.getIdx() == null) user = userRepository.save(dtoToEntity(dto));
        else{
            var entity = userRepository.findByIdx(dto.getIdx()).get();
            entity.setId(dto.getId());
            entity.setPassword(dto.getPassword());
            entity.setName(dto.getName());
            entity.setEmail(dto.getEmail());
            entity.setPhoneNumber(dto.getPhoneNumber());
            entity.setUserAddress(dto.getUserAddress());
            user = userRepository.save(entity);
        }
        return entityToDto(user);
    }

    /**
     * 사용자 조회 함수
     */
    public List<UserDto> finalAllUser() {
        var users = userRepository.findAll();
        List<UserDto> dtoUsers = new ArrayList<>();
        users.forEach(u->{
            dtoUsers.add(entityToDto(u));
        });

        return dtoUsers;
    }


    /**
     * 중복되는 아이디 찾는 함수
     */
    public String idCheck(String userId) {
        Optional<User> id = userRepository.findById(userId);
        if (id.isPresent()) {
            return null;
        }
        else {
            return "ok";
        }
    }

    /**
     * User entity에 있는 사용자 정보를 UserDto로 넘겨주는 함수
     */
    private UserDto entityToDto(User user) {
        var address = userAddressRepository.findByIdx(user.getIdx()).get();
        var dto = UserDto.builder().id(user.getId())
                .password(user.getPassword())
                .name(user.getName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .userAddress(address)
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
        return dto;
    }

    /**
     *  UserDto에 있는 사용자 정보를 User entity로 넘겨주는 함수
     */
    private User dtoToEntity(UserDto userDto) {
        var address = userAddressRepository.findByIdx(userDto.getIdx()).get();
        var dto = User.builder().id(userDto.getId())
                .password(userDto.getPassword())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .userAddress(address)
                .createdAt(userDto.getCreatedAt())
                .updatedAt(userDto.getUpdatedAt())
                .build();
        return dto;
    }
}
