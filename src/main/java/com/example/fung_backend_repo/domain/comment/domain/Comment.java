package com.example.fung_backend_repo.domain.comment.domain;

import com.example.fung_backend_repo.domain.feed.domain.Feed;
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
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String content;

    private LocalDateTime createTime;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    @Builder
    public Comment(String content, LocalDateTime createTime, User user, Feed feed) {
        this.content = content;
        this.createTime = createTime;
        this.user = user;
        this.feed = feed;
    }

    public void updateComment(String content) {
        this.content = content;
    }
}
