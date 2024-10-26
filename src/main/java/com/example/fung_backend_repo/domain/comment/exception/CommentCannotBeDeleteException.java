package com.example.fung_backend_repo.domain.comment.exception;

import com.example.fung_backend_repo.global.error.exception.CustomException;
import com.example.fung_backend_repo.global.error.exception.ErrorCode;

public class CommentCannotBeDeleteException extends CustomException {

    public static final CommentCannotBeDeleteException EXCEPTION = new CommentCannotBeDeleteException();

    private CommentCannotBeDeleteException() {
        super(ErrorCode.CANNOT_BE_DELETE);
    }
}
