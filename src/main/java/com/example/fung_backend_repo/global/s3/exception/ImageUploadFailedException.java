package com.example.fung_backend_repo.global.s3.exception;

import com.example.fung_backend_repo.global.error.exception.CustomException;
import com.example.fung_backend_repo.global.error.exception.ErrorCode;

public class ImageUploadFailedException extends CustomException {

    public static final ImageUploadFailedException EXCEPTION = new ImageUploadFailedException();

    private ImageUploadFailedException() {
        super(ErrorCode.IMAGE_UPLOAD_FAILED);
    }
}
