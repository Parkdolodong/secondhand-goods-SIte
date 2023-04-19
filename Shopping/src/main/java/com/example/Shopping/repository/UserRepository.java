package com.example.Shopping.repository;

import com.example.Shopping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByIdx(Long idx);
    Optional<User> findById(String id);
    Optional<List<User>> findByCreatedAtAfter(LocalDateTime createdAt);
    Optional<User> findByIdAndPassword(String id, String password);

    boolean existsById(String id);
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
}
