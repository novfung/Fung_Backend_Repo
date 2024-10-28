package com.example.fung_backend_repo.global.s3.facade;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUtil {

    String uploadImage(MultipartFile image);
}
