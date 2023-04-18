package com.example.Shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserAddressDto {
    private String result;

    private Long idx;
    private String address;
    private int zonecode;
    private String detailedaddress;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
