package com.example.fung_backend_repo.global.s3.presentation.response;

public class ImageUploadResponse {

    private final String imageUrl;

    public ImageUploadResponse(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
