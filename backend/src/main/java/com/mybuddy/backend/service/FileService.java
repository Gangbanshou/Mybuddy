package com.mybuddy.backend.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String uploadTaskImage(MultipartFile file, Long userId);
    String parseTaskByAi(String imageUrl);
}
