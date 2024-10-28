package com.example.fung_backend_repo.global.s3.exception;

import com.example.fung_backend_repo.global.error.exception.CustomException;
import com.example.fung_backend_repo.global.error.exception.ErrorCode;

public class ImageValueNotFoundException extends CustomException {

    public static final ImageValueNotFoundException EXCEPTION = new ImageValueNotFoundException();

    private ImageValueNotFoundException() {
        super(ErrorCode.IMAGE_VALUE_NOT_FOUND);
    }
}
