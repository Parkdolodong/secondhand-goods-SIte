package com.example.Shopping.service;

import com.example.Shopping.entity.User;
import com.example.Shopping.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    /**
     * 회원 가입
     */
    public Long join(User user) {
        // 같은 이름이 있는 중복 회원X
        validateDuplicateMember(user); //중복 회원 검증
        userRepository.save(user);
        return user.getIdx();
    }

    private void validateDuplicateMember(User user) {
        userRepository.findById(user.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(Long userId) {
        return userRepository.findById(userId);
    }
}
