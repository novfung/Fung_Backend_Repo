package com.example.fung_backend_repo.domain.comment.facade;

import com.example.fung_backend_repo.domain.comment.domain.Comment;
import com.example.fung_backend_repo.domain.comment.domain.repository.CommentRepository;
import com.example.fung_backend_repo.domain.comment.exception.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommentFacade {
    private final CommentRepository commentRepository;

    public Comment getCommentById(Long id){
        return commentRepository.findById(id)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
    }
}
