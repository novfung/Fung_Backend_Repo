package com.example.fung_backend_repo.domain.comment.presentation;

import com.example.fung_backend_repo.domain.comment.presentation.request.CreateCommentRequest;
import com.example.fung_backend_repo.domain.comment.presentation.request.UpdateCommentRequest;
import com.example.fung_backend_repo.domain.comment.service.CreateCommentService;
import com.example.fung_backend_repo.domain.comment.service.DeleteCommentService;
import com.example.fung_backend_repo.domain.comment.service.UpdateCommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/comment")
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CreateCommentService createCommentService;
    private final UpdateCommentService updateCommentService;
    private final DeleteCommentService deleteCommentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    public void createComment(@RequestBody @Valid CreateCommentRequest request, @PathVariable("feed-id") Long feedId ) {
        createCommentService.execute(request, feedId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{comment-id}")
    public void updateComment(@RequestBody @Valid UpdateCommentRequest request, @PathVariable("comment-id") Long commentId) {
        updateCommentService.execute(request, commentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{comment-id}")
    public void deleteComment(@PathVariable("comment-id") Long commentId) {
        deleteCommentService.execute(commentId);
    }
}
