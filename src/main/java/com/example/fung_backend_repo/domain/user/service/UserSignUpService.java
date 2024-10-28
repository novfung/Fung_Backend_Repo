package com.example.fung_backend_repo.domain.user.service;

import com.example.fung_backend_repo.domain.user.domain.User;
import com.example.fung_backend_repo.domain.user.domain.repository.UserRepository;
import com.example.fung_backend_repo.domain.user.exception.UserAlreadyExistException;
import com.example.fung_backend_repo.domain.user.presentation.request.UserSignUpRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Getter
@RequiredArgsConstructor
public class UserSignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(UserSignUpRequest request) {
        if (userRepository.existsByAccountId(request.getAccountId())) {
            throw UserAlreadyExistException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .gender(request.getGender())
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .interest(request.getInterest())
                .imageUrl(request.getImageUrl())
                .birth(request.getBirth())
                .build());
    }
}
