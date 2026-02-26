package com.mybuddy.backend.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.mybuddy.backend.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.access-key}")
    private String accessKey;
    @Value("${aliyun.oss.secret-key}")
    private String secretKey;
    @Value("${aliyun.oss.bucket}")
    private String bucket;

    @Override
    public String uploadTaskImage(MultipartFile file, Long userId) {
        String objectKey = "task-images/" + userId + "/" + UUID.randomUUID() + "-" + file.getOriginalFilename();
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKey, secretKey);
        try {
            ossClient.putObject(bucket, objectKey, file.getInputStream());
            return "https://" + bucket + "." + endpoint + "/" + objectKey;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            ossClient.shutdown();
        }
    }

    @Override
    public String parseTaskByAi(String imageUrl) {
        // 可以替换为通义千问VL、GPT-4o、Claude 3.5 Sonnet 等多模态API
        return "识别结果示例：完成高数作业第3章";
    }
}
