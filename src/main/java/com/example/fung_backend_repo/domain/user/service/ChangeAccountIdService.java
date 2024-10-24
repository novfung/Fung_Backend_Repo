package com.example.fung_backend_repo.domain.user.service;

import com.example.fung_backend_repo.domain.user.domain.User;
import com.example.fung_backend_repo.domain.user.domain.repository.UserRepository;
import com.example.fung_backend_repo.domain.user.facade.UserFacade;
import com.example.fung_backend_repo.domain.user.presentation.request.ChangeAccountIdRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeAccountIdService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public void updateAccountId(ChangeAccountIdRequest request) {
        User user = userFacade.getCurrentUser();
        user.updateAccountId(request.getAccountId());

        userRepository.save(user);
    }
}

