package com.example.fung_backend_repo.domain.feed.exception;

import com.example.fung_backend_repo.global.error.exception.CustomException;
import com.example.fung_backend_repo.global.error.exception.ErrorCode;

public class FeedCannotBeModifyException extends CustomException {

    public static final FeedCannotBeModifyException EXCEPTION = new FeedCannotBeModifyException();

    private FeedCannotBeModifyException() {
        super(ErrorCode.CANNOT_BE_MODIFY);
    }


}
