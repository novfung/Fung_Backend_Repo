package com.example.fung_backend_repo.domain.comment.service;

import com.example.fung_backend_repo.domain.comment.facade.CommentFacade;
import com.example.fung_backend_repo.domain.comment.domain.Comment;
import com.example.fung_backend_repo.domain.comment.domain.repository.CommentRepository;
import com.example.fung_backend_repo.domain.comment.exception.CommentCannotBeDeleteException;
import com.example.fung_backend_repo.domain.user.domain.User;
import com.example.fung_backend_repo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteCommentService {

    private final CommentFacade commentFacade;
    private final CommentRepository commentRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long commentId) {
        Comment comment = commentFacade.getCommentById(commentId);
        User user = userFacade.getCurrentUser();

        if(!user.equals(comment.getUser())) {
            throw CommentCannotBeDeleteException.EXCEPTION;
        }

        commentRepository.delete(comment);
    }
}
