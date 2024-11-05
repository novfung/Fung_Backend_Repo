package com.example.fung_backend_repo.domain.comment.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class CommentResponse {
    
    private final String accountId;

    private final String content;

    private final LocalDateTime createTime;
}
