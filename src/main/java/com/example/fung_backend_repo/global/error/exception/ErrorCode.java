package com.example.fung_backend_repo.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    PASSWORD_MISMATCH(401, "Password Mismatch"),
    EXPIRED_JWT(401, "Expired Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),
    CANNOT_BE_DELETE(401, "Cannot Be Delete"),
    CANNOT_BE_MODIFY(401, "Cannot Be Modify"),

    USER_NOT_FOUND(404, "User Not Found"),
    FEED_NOT_FOUND(404, "Feed Not Found"),
    COMMENT_NOT_FOUND(404, "Comment Not Found"),

    IMAGE_UPLOAD_FAILED(404, "Image Upload Failed"),
    IMAGE_VALUE_NOT_FOUND(404, "Image Value Not Found"),


    USER_ALREADY_EXIST(409, "User Already Exist"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;
}
