package com.example.Shopping.service;

import com.example.Shopping.dto.LoginDto;
import com.example.Shopping.dto.UserAddressDto;
import com.example.Shopping.dto.UserDto;
import com.example.Shopping.entity.UserAddress;
import com.example.Shopping.entity.User;
import com.example.Shopping.repository.UserAddressRepository;
import com.example.Shopping.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserAddressRepository userAddressRepository;

    /**
     * 회원 가입
     */
    @Transactional
    public UserDto signUser(UserDto dto) throws DuplicateKeyException {
        // 아이디와 이메일이 이미 존재하는지 확인
        if(userRepository.existsById(dto.getId())) {
            throw new DuplicateKeyException("아이디가 이미 존재합니다.");
        }
        if(userRepository.existsByEmail(dto.getEmail())) {
            throw new DuplicateKeyException("이메일이 이미 존재합니다.");
        }
        if(userRepository.existsByPhoneNumber(dto.getPhoneNumber())) {
            throw new DuplicateKeyException("이미 사용 중인 전화번호입니다");
        }
        // UserAddress 객체 생성 및 저장
        UserAddressDto userAddressDto = dto.getUserAddressDto();
        UserAddress userAddress = userAddressDtoToEntity(userAddressDto);
        userAddress = userAddressRepository.save(userAddress);

        // User 객체 생성 및 저장
        User user = dtoToEntity(dto, userAddress);
        user = userRepository.save(user);

        // 저장된 User 객체를 DTO로 변환하여 반환
        return entityToDto(user);
    }

    /**
     * 사용자 등록 및 수정
     */
    public UserDto registerUser(UserDto dto) {
        User user = null;
        if(dto.getIdx() == null) {
            UserAddressDto userAddressDto = dto.getUserAddressDto();
            UserAddress userAddress = userAddressRepository.save(userAddressDtoToEntity(userAddressDto));
            user = userRepository.save(dtoToEntity(dto, userAddress));
        }
        else{
            var entity = userRepository.findByIdx(dto.getIdx()).get();
            entity.setId(dto.getId());
            entity.setPassword(dto.getPassword());
            entity.setName(dto.getName());
            entity.setEmail(dto.getEmail());
            entity.setPhoneNumber(dto.getPhoneNumber());
            UserAddressDto userAddressDto = dto.getUserAddressDto();
            UserAddress userAddress = userAddressRepository.save(userAddressDtoToEntity(userAddressDto));
            entity.setUserAddress(userAddress);
            user = userRepository.save(entity);
        }
        return entityToDto(user);
    }

    /**
     *  로그인 함수
     */

    public UserDto findByLoginInfo(LoginDto loginDto) {
        Optional<User> user = userRepository.findByIdAndPassword(loginDto.getId(), loginDto.getPassword());
        return user.map(this::entityToDto).orElse(null);
    }

    /**
     * 중복되는 아이디 찾는 함수
     */
    public boolean isIdExists(String userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.isPresent();
    }

    /**
     * UserDto에 있는 사용자 정보를 User entity로 넘겨주는 함수
     */
    private User dtoToEntity(UserDto dto, UserAddress userAddress) {
        return User.builder()
                .id(dto.getId())
                .password(dto.getPassword())
                .name(dto.getName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .userAddress(userAddress)
                .build();
    }

    /**
     * User entity에 있는 사용자 정보를 UserDto로 넘겨주는 함수
     */
    private UserDto entityToDto(User user) {
        UserAddressDto userAddressDto = userAddressEntityToDto(user.getUserAddress());
        return UserDto.builder()
                .idx(user.getIdx())
                .id(user.getId())
                .password(user.getPassword())
                .name(user.getName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .userAddressDto(userAddressDto)
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    /**
     * UserAddressDto에 있는 사용자 주소 정보를 UserAddress entity로 넘겨주는 함수
     */
    private UserAddress userAddressDtoToEntity(UserAddressDto userAddressDto) {
        return UserAddress.builder()
                .address(userAddressDto.getAddress())
                .zonecode(userAddressDto.getZonecode())
                .detailedaddress(userAddressDto.getDetailedaddress())
                .build();
    }

    /**
     * UserAddress entity에 있는 사용자 주소 정보를 UserAddressDto로 넘겨주는 함수
     */
    private UserAddressDto userAddressEntityToDto(UserAddress userAddress) {
        return UserAddressDto.builder()
                .idx(userAddress.getIdx())
                .address(userAddress.getAddress())
                .zonecode(userAddress.getZonecode())
                .detailedaddress(userAddress.getDetailedaddress())
                .createdAt(userAddress.getCreatedAt())
                .updatedAt(userAddress.getUpdatedAt())
                .build();
    }

}
