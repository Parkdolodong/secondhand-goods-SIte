package com.example.Shopping.repository;

import com.example.Shopping.entity.User;
import com.example.Shopping.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
    Optional<UserAddress> findByIdx(Long idx);
}
