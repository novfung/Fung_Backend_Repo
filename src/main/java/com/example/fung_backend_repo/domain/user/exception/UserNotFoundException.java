package com.example.fung_backend_repo.domain.user.exception;

import com.example.fung_backend_repo.global.error.exception.CustomException;
import com.example.fung_backend_repo.global.error.exception.ErrorCode;

public class UserNotFoundException extends CustomException {

    public static final UserNotFoundException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
