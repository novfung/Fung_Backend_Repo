package com.example.fung_backend_repo.domain.feed.exception;

import com.example.fung_backend_repo.global.error.exception.CustomException;
import com.example.fung_backend_repo.global.error.exception.ErrorCode;

public class FeedCannotBeDeleteException extends CustomException {

    public static final FeedCannotBeDeleteException EXCEPTION = new FeedCannotBeDeleteException();

    private FeedCannotBeDeleteException() {
        super(ErrorCode.CANNOT_BE_DELETE);
    }
}
