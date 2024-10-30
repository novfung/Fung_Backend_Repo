package com.example.fung_backend_repo.global.s3.service;

import com.example.fung_backend_repo.global.s3.facade.ImageUtil;
import com.example.fung_backend_repo.global.s3.presentation.response.ImageUploadResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageUploadService {

    private final ImageUtil imageUtil;

    public ImageUploadService(ImageUtil imageUtil) {
        this.imageUtil = imageUtil;
    }

    public ImageUploadResponse execute(MultipartFile multipartFile) {
        String imageUrl = imageUtil.uploadImage(multipartFile);
        return new ImageUploadResponse(imageUrl);
    }
}
