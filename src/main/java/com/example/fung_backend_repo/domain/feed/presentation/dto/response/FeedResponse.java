package com.example.fung_backend_repo.domain.feed.presentation.dto.response;


import com.example.fung_backend_repo.domain.comment.presentation.dto.response.CommentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class FeedResponse {

    private final Long feedId;
    private final String title;
    private final String content;
    private final LocalDateTime createTime;
    private final String accountId;
    private final List<CommentResponse> commenList;
}
