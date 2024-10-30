package com.example.fung_backend_repo.domain.comment.service;

import com.example.fung_backend_repo.domain.comment.facade.CommentFacade;
import com.example.fung_backend_repo.domain.comment.domain.Comment;
import com.example.fung_backend_repo.domain.comment.exception.CommentNotFoundException;
import com.example.fung_backend_repo.domain.comment.presentation.dto.request.UpdateCommentRequest;
import com.example.fung_backend_repo.domain.user.domain.User;
import com.example.fung_backend_repo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateCommentService {

    private final UserFacade userFacade;
    private final CommentFacade commentFacade;

    @Transactional
    public void execute(UpdateCommentRequest request, Long commentId) {
        User user = userFacade.getCurrentUser();
        Comment comment = commentFacade.getCommentById(commentId);

        if(!user.equals(comment.getUser())) {
            throw CommentNotFoundException.EXCEPTION;
        }

        comment.updateComment(request.getContent());
    }
}
