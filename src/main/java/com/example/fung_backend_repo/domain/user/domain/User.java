package com.example.fung_backend_repo.domain.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String accountId;

    @Column(nullable = false)
    private String password;

    private String gender;

    @Column(length = 30)
    private String interest;

    private LocalDate birth;

    private String imageUrl;

    @Builder
    private User(String accountId, String password, String gender, String imageUrl, String interest, LocalDate birth) {
        this.accountId = accountId;
        this.password = password;
        this.gender = gender;
        this.interest = interest;
        this.imageUrl = imageUrl;
        this.birth = birth;
    }

    public void updatePassword (String password) {
        this.password = password;
    }

    public void updateAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void updateBirth(LocalDate birth) {
        this.birth = birth;
    }

    public void updateInterest(String interest) {
        this.interest = interest;
    }
}
