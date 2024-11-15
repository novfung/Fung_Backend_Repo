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

    @Column(length = 30)
    private String interest;

    private LocalDate birth;

    private String imageUrl;

    private String gender;

    @Builder
    private User(String accountId, String password, String imageUrl, String interest, String gender, LocalDate birth) {
        this.accountId = accountId;
        this.password = password;
        this.interest = interest;
        this.imageUrl = imageUrl;
        this.birth = birth;
        this.gender = gender;
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
