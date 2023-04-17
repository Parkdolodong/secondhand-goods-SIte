package com.example.Shopping.dto;

import com.example.Shopping.entity.Bid;
import com.example.Shopping.entity.Item;
import com.example.Shopping.entity.UserAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
