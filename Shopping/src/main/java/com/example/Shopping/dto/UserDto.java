package com.example.Shopping.dto;

import com.example.Shopping.entity.UserAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
    private String result;

    private Long idx;
    private String id;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private UserAddressDto userAddressDto;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
