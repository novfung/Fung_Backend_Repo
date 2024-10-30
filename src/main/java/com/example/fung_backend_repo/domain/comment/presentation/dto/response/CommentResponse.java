package com.example.fung_backend_repo.domain.comment.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponse {

    private final String comment;

    private final String accountId;
}
