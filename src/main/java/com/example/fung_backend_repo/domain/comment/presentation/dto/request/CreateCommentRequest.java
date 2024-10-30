package com.example.fung_backend_repo.domain.comment.presentation.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CreateCommentRequest {

    private Long feedId;

    @NotNull
    private String content;

    private LocalDateTime createTime;
}
