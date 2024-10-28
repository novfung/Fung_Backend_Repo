package com.example.fung_backend_repo.global.s3.presentation;

import com.example.fung_backend_repo.global.s3.presentation.response.ImageUploadResponse;
import com.example.fung_backend_repo.global.s3.service.ImageUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RequestMapping("/images")
@RestController
public class ImageUploadController {

    private final ImageUploadService imageUploadService;

    @PostMapping("profile")
    public ImageUploadResponse ProfileImageUpload(@RequestParam("file") MultipartFile multipartFile) {
        return imageUploadService.execute(multipartFile);
    }

    @PostMapping("feed-image")
    public ImageUploadResponse FeedImageUpload(@RequestParam("file") MultipartFile multipartFile) {
        return imageUploadService.execute(multipartFile);
    }
}
