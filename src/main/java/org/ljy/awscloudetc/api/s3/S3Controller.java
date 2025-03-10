package org.ljy.awscloudetc.api.s3;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.core.sync.RequestBody;

import java.io.IOException;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/s3")
public class S3Controller {

    private final S3Client s3Client;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;
    
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String fileUrl = this.uploadFileService(file);
        return ResponseEntity.ok(fileUrl);
    }



     private String uploadFileService(MultipartFile file) {
         try {
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

            // 파일을 바이트 배열로 변환
            byte[] fileBytes = file.getBytes();

            // S3 업로드 요청
            s3Client.putObject(
                PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(fileName)
                    .build(),
                RequestBody.fromBytes(fileBytes) // ✅ 수정된 부분
            );

            return "https://" + bucketName + ".s3.amazonaws.com/" + fileName;

        } catch (IOException e) {
            throw new RuntimeException("파일 업로드 실패", e);
        }
    }

}