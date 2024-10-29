package com.example.fung_backend_repo.domain.user.service;

import com.example.fung_backend_repo.domain.user.domain.User;
import com.example.fung_backend_repo.domain.user.domain.repository.UserRepository;
import com.example.fung_backend_repo.domain.user.facade.UserFacade;
import com.example.fung_backend_repo.domain.user.presentation.dto.response.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public UserInfoResponse execute() {
        User user = userFacade.getCurrentUser();

        return UserInfoResponse.builder()
                .birth(user.getBirth())
                .accountId(execute().getAccountId())
                .interest(execute().getInterest())
                .build();
    }
}

