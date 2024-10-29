package com.example.fung_backend_repo.domain.user.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class UserInfoResponse {

    private String accountId;

    private LocalDate birth;

    private String interest;
}
