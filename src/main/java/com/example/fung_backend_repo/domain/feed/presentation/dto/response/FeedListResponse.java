package com.example.fung_backend_repo.domain.feed.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class FeedListResponse {

    private final List<FeedResponse> feedList;

    @Getter
    @Builder
    public static class FeedResponse {
        private final Integer feedId;
        private final String title;
        private final LocalDate createTime;
        private final String name;
    }

}
