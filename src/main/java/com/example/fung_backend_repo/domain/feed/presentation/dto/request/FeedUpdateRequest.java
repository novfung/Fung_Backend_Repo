package com.example.fung_backend_repo.domain.feed.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeedUpdateRequest {

    private String title;

    private String content;

    private String image_url;
}
