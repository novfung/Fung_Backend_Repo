package com.example.fung_backend_repo.domain.feed.presentation;


import com.example.fung_backend_repo.domain.feed.presentation.dto.request.FeedCreateRequest;
import com.example.fung_backend_repo.domain.feed.presentation.dto.request.FeedUpdateRequest;
import com.example.fung_backend_repo.domain.feed.presentation.dto.response.FeedResponse;
import com.example.fung_backend_repo.domain.feed.service.FeedCreateService;
import com.example.fung_backend_repo.domain.feed.service.FeedDeleteService;
import com.example.fung_backend_repo.domain.feed.service.FeedUpdateService;
import com.example.fung_backend_repo.domain.feed.service.QueryFeedService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/feed")
@RestController
public class FeedController {

    private final FeedCreateService feedCreateService;
    private final FeedDeleteService feedDeleteService;
    private final FeedUpdateService feedUpdateService;
    private final QueryFeedService queryFeedService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(@RequestBody @Valid FeedCreateRequest feedCreateRequest) {
        feedCreateService.execute(feedCreateRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{feed-id}")
    public void updateFeed(@RequestBody @Valid FeedUpdateRequest feedUpdateRequest, @PathVariable("feed-id") Long feedId) {
        feedUpdateService.execute(feedId, feedUpdateRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public void deleteFeed(@PathVariable("feed-id") Long feedId){
        feedDeleteService.execute(feedId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{feed-id}")
    public FeedResponse getFeed(@PathVariable("feed-id") Long feedId) {
        return queryFeedService.execute(feedId);
    }
}
