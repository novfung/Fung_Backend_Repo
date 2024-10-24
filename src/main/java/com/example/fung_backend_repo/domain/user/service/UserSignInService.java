package com.example.fung_backend_repo.domain.user.service;

import com.example.fung_backend_repo.domain.auth.presentation.response.TokenResponse;
import com.example.fung_backend_repo.domain.user.domain.User;
import com.example.fung_backend_repo.domain.user.domain.repository.UserRepository;
import com.example.fung_backend_repo.domain.user.exception.PasswordMismatchException;
import com.example.fung_backend_repo.domain.user.exception.UserNotFoundException;
import com.example.fung_backend_repo.domain.user.presentation.request.UserSignInRequest;
import com.example.fung_backend_repo.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserSignInService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse signIn(UserSignInRequest request) {

        User user =userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        String accessToken =jwtTokenProvider.generateAccessToken(request.getAccountId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(request.getAccountId());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
