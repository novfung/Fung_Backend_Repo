package com.example.fung_backend_repo.domain.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Builder
    private User(String accountId, String password, String gender, String imageUrl) {
        this.accountId = accountId;
        this.password = password;
        this.gender = gender;
    }

    public void updatePassword (String password) {
        this.password = password;
    }

    public void updateAccountId(String accountId) {
        this.accountId = accountId;
    }
}
