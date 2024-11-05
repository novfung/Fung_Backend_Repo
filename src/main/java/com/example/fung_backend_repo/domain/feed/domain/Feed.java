package com.example.fung_backend_repo.domain.feed.domain;

import com.example.fung_backend_repo.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountId;

    private String title;

    private String content;

    private String imageUrl;

    private LocalDateTime createTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Feed(String title, String content, String imageUrl, LocalDateTime createTime, User user) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.createTime = createTime;
        this.user = user;
        this.accountId = user.getAccountId();
    }

    public void feedUpdate(String title, String content, String image_url){
        this.title = title;
        this.content = content;
        this.imageUrl = image_url;
    }
}