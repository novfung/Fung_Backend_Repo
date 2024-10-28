package com.example.fung_backend_repo.domain.user.presentation.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSignUpRequest {

    private String accountId;

    private String password;

    private String gender;
}