package com.example.fung_backend_repo.domain.user.presentation.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ChangeBirthRequest {


    private LocalDate birth;
}
