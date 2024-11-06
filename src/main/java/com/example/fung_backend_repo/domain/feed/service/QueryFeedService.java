package com.example.fung_backend_repo.domain.feed.service;

import com.example.fung_backend_repo.domain.comment.domain.Comment;
import com.example.fung_backend_repo.domain.comment.domain.repository.CommentRepository;
import com.example.fung_backend_repo.domain.comment.presentation.dto.response.CommentResponse;
import com.example.fung_backend_repo.domain.feed.domain.Feed;
import com.example.fung_backend_repo.domain.feed.domain.repository.FeedRepository;
import com.example.fung_backend_repo.domain.feed.exception.FeedNotFoundException;
import com.example.fung_backend_repo.domain.feed.presentation.dto.response.FeedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryFeedService {

    private final FeedRepository feedRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public FeedResponse execute(Long feedId) {

        Feed feed = feedRepository.findById(feedId)
                .orElseThrow(()-> FeedNotFoundException.EXCEPTION);

        List<CommentResponse> commentResponses = commentRepository.findByFeedId(feedId)
                .stream()
                .map(comment -> CommentResponse.builder()
                        .accountId(comment.getUser().getAccountId())
                        .content(comment.getContent())
                        .createTime(comment.getCreateTime())
                        .build())
                .collect(Collectors.toList());

        return FeedResponse.builder()
                .feedId(feed.getId())
                .title(feed.getTitle())
                .content(feed.getContent())
                .createTime(feed.getCreateTime())
                .accountId(feed.getUser().getAccountId())
                .commenList(commentResponses)
                .build();
    }
}
