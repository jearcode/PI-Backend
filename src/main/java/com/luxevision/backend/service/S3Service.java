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

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

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

    String removeSpacesFromString (String name) {
        return name.replaceAll("\\s+", "");
    }

    public String uploadProfileImage(MultipartFile file, String studioName) throws IOException {
        String key = "studios/" + removeSpacesFromString(studioName) + "/profile-image";
        String contentType = file.getContentType();

        try {
            s3Client.putObject(PutObjectRequest.builder()
                            .bucket(bucketName)
                            .key(key)
                            .acl(ObjectCannedACL.PUBLIC_READ)
                            .contentType(contentType)
                            .build(),
                    software.amazon.awssdk.core.sync.RequestBody.fromBytes(file.getBytes()));
        } catch (IOException ioException) {
            throw new IOException(ioException.getLocalizedMessage());
        }

        return "https://" + bucketName + ".s3.amazonaws.com/" + key;

    }

    public String uploadPortfolioPhoto(MultipartFile file, String studioName, Integer number) throws IOException {
        String key = "studios/" + removeSpacesFromString(studioName) + "/photography-" + number;
        String contentType = file.getContentType();

        try {
            s3Client.putObject(PutObjectRequest.builder()
                            .bucket(bucketName)
                            .key(key)
                            .acl(ObjectCannedACL.PUBLIC_READ)
                            .contentType(contentType)
                            .build(),
                    software.amazon.awssdk.core.sync.RequestBody.fromBytes(file.getBytes()));
        } catch (IOException ioException) {
            throw new IOException(ioException.getLocalizedMessage());
        }


        return "https://" + bucketName + ".s3.amazonaws.com/" + key;

    }

    public String uploadSpecialtyImage(MultipartFile file, String specialtyName) throws IOException {
        String key = "specialties/" + removeSpacesFromString(specialtyName) + "/profile-image";
        String contentType = file.getContentType();

        try {
            s3Client.putObject(PutObjectRequest.builder()
                            .bucket(bucketName)
                            .key(key)
                            .acl(ObjectCannedACL.PUBLIC_READ)
                            .contentType(contentType)
                            .build(),
                    software.amazon.awssdk.core.sync.RequestBody.fromBytes(file.getBytes()));
        } catch (IOException ioException) {
            throw new IOException(ioException.getLocalizedMessage());
        }

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
                System.out.println("No objects were found with the specified prefix.");
                return;
            }

            listObjectsResponse.contents().forEach(s3Object -> {
                try {
                    s3Client.deleteObject(DeleteObjectRequest.builder()
                            .bucket(bucketName)
                            .key(s3Object.key())
                            .build());
                    System.out.println("Deleted: " + s3Object.key());
                } catch (S3Exception e) {
                    System.err.println("Error deleting object: " + s3Object.key() + " - " + e.getMessage());
                }
            });

        } catch (S3Exception e) {
            System.err.println("Error listing objects: " + e.getMessage());
        }
    }

    public void deleteObject(String studioName) {
        String key = "studios/" + removeSpacesFromString(studioName) + "/";

        ListObjectsV2Request listObjectsRequest = ListObjectsV2Request.builder()
                .bucket(bucketName)
                .prefix(key)
                .build();

        try {
            ListObjectsV2Response listObjectsResponse = s3Client.listObjectsV2(listObjectsRequest);

            if (listObjectsResponse.contents().isEmpty()) {
                System.out.println("No objects were found with the specified prefix: " + key);
                return;
            }

            listObjectsResponse.contents().forEach(s3Object -> {
                try {
                    s3Client.deleteObject(DeleteObjectRequest.builder()
                            .bucket(bucketName)
                            .key(s3Object.key())
                            .build());
                    System.out.println("Deleted: " + s3Object.key());
                } catch (S3Exception e) {
                    System.err.println("Error deleting object: " + s3Object.key() + " - " + e.getMessage());
                }
            });

        } catch (S3Exception e) {
            System.err.println("Error listing objects: " + e.getMessage());
        }
    }

    public String uploadPortfolioPhoto(byte[] fileData, String studioName, Integer number, String contentType) {
        String key = "studios/" + removeSpacesFromString(studioName) + "/photography-" + number;
        s3Client.putObject(PutObjectRequest.builder()
                        .bucket(bucketName)
                        .key(key)
                        .acl(ObjectCannedACL.PUBLIC_READ)
                        .contentType(contentType)
                        .build(),
                software.amazon.awssdk.core.sync.RequestBody.fromBytes(fileData));

        return "https://" + bucketName + ".s3.amazonaws.com/" + key;

    }

    public String uploadPortfolioPhotoFromUrl(String fileUrl, String studioName, Integer number) throws IOException {
        URL url = new URL(fileUrl);
        URLConnection connection = url.openConnection();
        String contentType = connection.getContentType();
        try (InputStream inputStream = new BufferedInputStream(connection.getInputStream());
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            return uploadPortfolioPhoto(outputStream.toByteArray(), studioName, number, contentType);
        }
    }


    public void updateStudioProfileImage(String oldStudio, String newStudioName) throws IOException {
        String oldProfileImageKey = "studios/" + removeSpacesFromString(oldStudio) + "/profile-image";
        String newProfileImageKey = "studios/" + removeSpacesFromString(newStudioName) + "/profile-image";

        CopyObjectRequest copyObjectRequest = CopyObjectRequest.builder()
                .sourceBucket(bucketName)
                .sourceKey(oldProfileImageKey)
                .destinationBucket(bucketName)
                .destinationKey(newProfileImageKey)
                .acl(ObjectCannedACL.PUBLIC_READ)
                .build();

        try {
            s3Client.copyObject(copyObjectRequest);
            s3Client.deleteObject(DeleteObjectRequest.builder()
                    .bucket(bucketName)
                    .key(oldProfileImageKey)
                    .build());
            System.out.println("Updated: " + oldProfileImageKey + " to " + newProfileImageKey);
        } catch (S3Exception e) {
            System.err.println("Error renaming object: " + oldProfileImageKey + " - " + e.getMessage());
        }
    }

    public void updateStudioPortfolioImages(String oldStudio, String newStudioName) throws IOException {
        for (int i = 1; i <= 5; i++) {
            String oldPortfolioKey = "studios/" + removeSpacesFromString(oldStudio) + "/photography-" + i;
            String newPortfolioKey = "studios/" + removeSpacesFromString(newStudioName) + "/photography-" + i;
            CopyObjectRequest copyObjectRequest = CopyObjectRequest.builder()
                    .sourceBucket(bucketName)
                    .sourceKey(oldPortfolioKey)
                    .destinationBucket(bucketName)
                    .destinationKey(newPortfolioKey)
                    .acl(ObjectCannedACL.PUBLIC_READ)
                    .build();
            try {
                s3Client.copyObject(copyObjectRequest);
                s3Client.deleteObject(DeleteObjectRequest.builder()
                        .bucket(bucketName)
                        .key(oldPortfolioKey)
                        .build());
                System.out.println("Updated: " + oldPortfolioKey + " to " + newPortfolioKey);
            } catch (S3Exception e) {
                System.err.println("Error renaming object: " + oldPortfolioKey + " - " + e.getMessage());
            }
        }
    }

    public void copySpecificObject(String objectKey, String newPath) throws IOException {
        ListObjectsV2Request listObjectsRequest = ListObjectsV2Request.builder()
                .bucket(bucketName)
                .prefix(objectKey)
                .build();

        try {
            ListObjectsV2Response listObjectsResponse = s3Client.listObjectsV2(listObjectsRequest);

            if (listObjectsResponse.contents().isEmpty()) {
                System.out.println("No objects were found with the specified prefix: " + objectKey);
                return;
            }

            for (S3Object s3Object : listObjectsResponse.contents()) {
                try {
                    String newKey = newPath;

                    CopyObjectRequest copyObjectRequest = CopyObjectRequest.builder()
                            .sourceBucket(bucketName)
                            .sourceKey(s3Object.key())
                            .destinationBucket(bucketName)
                            .destinationKey(newKey)
                            .acl(ObjectCannedACL.PUBLIC_READ)
                            .build();

                    s3Client.copyObject(copyObjectRequest);

                    System.out.println("Copied: " + s3Object.key() + " to " + newKey);

                } catch (S3Exception e) {
                    System.err.println("Error copying object: " + s3Object.key() + " - " + e.getMessage());
                }
            }

        } catch (S3Exception e) {
            System.err.println("Error getting object: " + e.getMessage());
        }
    }

}
