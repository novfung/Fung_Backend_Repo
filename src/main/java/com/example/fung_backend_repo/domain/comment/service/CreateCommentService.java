package com.example.fung_backend_repo.domain.comment.service;

import com.example.fung_backend_repo.domain.comment.domain.Comment;
import com.example.fung_backend_repo.domain.comment.domain.repository.CommentRepository;
import com.example.fung_backend_repo.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.example.fung_backend_repo.domain.feed.domain.Feed;
import com.example.fung_backend_repo.domain.feed.facade.FeedFacade;
import com.example.fung_backend_repo.domain.user.domain.User;
import com.example.fung_backend_repo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateCommentService {

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;

    @Transactional
    public void execute(CreateCommentRequest request, Long feedId) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeedById(feedId);

        commentRepository.save(
                Comment.builder()
                        .content(request.getContent())
                        .createTime(LocalDateTime.now())
                        .user(user)
                        .feed(feed)
                        .build()
        );
    }
}
