package com.example.Shopping.service;

import com.example.Shopping.dto.UserAddressDto;
import com.example.Shopping.entity.UserAddress;
import com.example.Shopping.repository.UserAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserAddressService {
    private final UserAddressRepository userAddressRepository;

    /**
     * 사용자 주소 등록 및 수정
     */
    public UserAddressDto registerAddr(UserAddressDto dto) {
        UserAddress userAddress = null;
        if(dto.getIdx() == null)
            userAddress = userAddressRepository.save(addrDtoToEntity(dto));
        else {
            var entity = userAddressRepository.findByIdx(dto.getIdx()).get();
            entity.setAddress(dto.getAddress());
            entity.setZonecode(dto.getZonecode());
            entity.setDetailedaddress(dto.getDetailedaddress());
            userAddress = userAddressRepository.save(entity);
        }
        return entityToAddrDto(userAddress);
    }

    /**
     * UserAddressDto에 있는 사용자 주소 정보를 UserAddress entity로 넘겨주는 함수
     */
    private UserAddressDto entityToAddrDto(UserAddress userAddress) {
        var addr = UserAddressDto.builder().address(userAddress.getAddress())
                .zonecode(userAddress.getZonecode())
                .detailedaddress(userAddress.getDetailedaddress())
                .createdAt(userAddress.getCreatedAt())
                .updatedAt(userAddress.getUpdatedAt())
                .build();
        return addr;
    }

    /**
     * UserAddress entity에 있는 사용자 주소 정보를 UserAddressDto로 넘겨주는 함수
     */
    private UserAddress addrDtoToEntity(UserAddressDto userAddressDto) {
        var addr = UserAddress.builder().address(userAddressDto.getAddress())
                .zonecode(userAddressDto.getZonecode())
                .detailedaddress(userAddressDto.getDetailedaddress())
                .createdAt(userAddressDto.getCreatedAt())
                .updatedAt(userAddressDto.getUpdatedAt())
                .build();
        return addr;
    }
}
