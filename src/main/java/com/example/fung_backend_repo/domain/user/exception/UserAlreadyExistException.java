package com.example.fung_backend_repo.domain.user.exception;

import com.example.fung_backend_repo.global.error.exception.CustomException;
import com.example.fung_backend_repo.global.error.exception.ErrorCode;

public class UserAlreadyExistException extends CustomException {

    public static final UserAlreadyExistException EXCEPTION = new UserAlreadyExistException();

    private UserAlreadyExistException() {
        super(ErrorCode.USER_ALREADY_EXIST);
    }
}
