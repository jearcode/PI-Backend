package com.luxevision.backend.service;

import com.luxevision.backend.entity.Specialty;
import com.luxevision.backend.entity.Studio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.IOException;

@Service
public class S3Service {

    private final S3Client s3Client;
    private final String bucketName;

    public S3Service(@Value("${AWS_ACCESS_KEY_ID}") String accessKeyId,
                     @Value("${AWS_SECRET_ACCESS_KEY}") String secretAccessKey,
                     @Value("${AWS_S3_BUCKET_NAME}") String bucketName,
                     @Value("${AWS_S3_REGION}") String region) {
        AwsBasicCredentials awsCredentials = AwsBasicCredentials.create(accessKeyId, secretAccessKey);
        this.s3Client = S3Client.builder()
                .credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
                .region(Region.of(region))
                .build();
        this.bucketName = bucketName;
    }

    public String uploadFile(MultipartFile file, String studioName, String portfolioName) throws IOException {

        String key = "studios/" + studioName + "/";

        if(!portfolioName.isEmpty()) {
            key += portfolioName;
        } else {
            key += "profile-image";
        }

        String contentType = file.getContentType();

        s3Client.putObject(PutObjectRequest.builder()
                        .bucket(bucketName)
                        .key(key)
                        .acl(ObjectCannedACL.PUBLIC_READ)
                        .contentType(contentType)
                        .build(),
                software.amazon.awssdk.core.sync.RequestBody.fromBytes(file.getBytes()));

        return "https://" + bucketName + ".s3.amazonaws.com/" + key;
    }

    public String uploadImage(MultipartFile file, String categoryName) throws IOException {

        String key = "specialties/" + categoryName + "/profile-image";

        String contentType = file.getContentType();

        s3Client.putObject(PutObjectRequest.builder()
                        .bucket(bucketName)
                        .key(key)
                        .acl(ObjectCannedACL.PUBLIC_READ)
                        .contentType(contentType)
                        .build(),
                software.amazon.awssdk.core.sync.RequestBody.fromBytes(file.getBytes()));

        return "https://" + bucketName + ".s3.amazonaws.com/" + key;
    }

    public void deleteObject(Specialty specialty, Studio studio) {

        String key;
        if (specialty != null) {
            key = "specialties/" + specialty.getSpecialtyName() + "/";
        } else {
            key = "studios/" + studio.getStudioName() + "/";
        }

        ListObjectsV2Request listObjectsRequest = ListObjectsV2Request.builder()
                .bucket(bucketName)
                .prefix(key)
                .build();

        try {
            ListObjectsV2Response listObjectsResponse = s3Client.listObjectsV2(listObjectsRequest);

            if (listObjectsResponse.contents().isEmpty()) {
                System.out.println("No se encontraron objetos con el prefijo especificado.");
                return;
            }

            listObjectsResponse.contents().forEach(s3Object -> {
                try {
                    s3Client.deleteObject(DeleteObjectRequest.builder()
                            .bucket(bucketName)
                            .key(s3Object.key())
                            .build());
                    System.out.println("Eliminado: " + s3Object.key());
                } catch (S3Exception e) {
                    System.err.println("Error al eliminar el objeto: " + s3Object.key() + " - " + e.getMessage());
                }
            });

        } catch (S3Exception e) {
            System.err.println("Error al listar objetos: " + e.getMessage());
        }
    }

}
