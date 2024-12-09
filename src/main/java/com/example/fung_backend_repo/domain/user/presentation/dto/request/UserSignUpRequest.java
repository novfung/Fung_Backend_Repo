package com.example.fung_backend_repo.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class UserSignUpRequest {

    private String accountId;

    private String password;

    private String interest;

    private String imageUrl;

    private LocalDate birth;

    private String gender;
}