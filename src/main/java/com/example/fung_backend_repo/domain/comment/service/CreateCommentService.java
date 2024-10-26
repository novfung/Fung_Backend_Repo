package com.example.fung_backend_repo.domain.comment.service;

import com.example.fung_backend_repo.domain.comment.domain.Comment;
import com.example.fung_backend_repo.domain.comment.domain.repository.CommentRepository;
import com.example.fung_backend_repo.domain.comment.presentation.request.CreateCommentRequest;
import com.example.fung_backend_repo.domain.feed.domain.Feed;
import com.example.fung_backend_repo.domain.feed.facade.FeedFacade;
import com.example.fung_backend_repo.domain.user.domain.User;
import com.example.fung_backend_repo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

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
        LocalDateTime createTime = LocalDateTime.now();

        commentRepository.save(
                Comment.builder()
                        .content(request.getContent())
                        .createTime(createTime)
                        .user(user)
                        .feed(feed)
                        .build()
        );
    }
}
