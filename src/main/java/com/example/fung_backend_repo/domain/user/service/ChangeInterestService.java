package com.example.fung_backend_repo.domain.user.service;

import com.example.fung_backend_repo.domain.user.domain.User;
import com.example.fung_backend_repo.domain.user.domain.repository.UserRepository;
import com.example.fung_backend_repo.domain.user.facade.UserFacade;
import com.example.fung_backend_repo.domain.user.presentation.request.ChangeInterestRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeInterestService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public void updateInterest(ChangeInterestRequest request) {
        User user = userFacade.getCurrentUser();
        user.updateInterest(request.getInterest());

        userRepository.save(user);
    }
}
