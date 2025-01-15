package org.example.services;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;


//public class JobRoleApplicationService {
//    private final String bucketName = "";
//    private final String localFile = "";
//    private final String targetLocation = "";
//    private void uploadFileToS3Bucket() {
//        S3Client client = S3Client.builder().build();
//        sop("S3 Client Initialized");
//        putObjectRequest request = PutObjectRequest.builder()
//                .bucket(bucketName).key(targetLocation + localFile).build();
//        sop("PutObjjectRequest is created sucessfully");
//        client.putObject(request, RequestBody.fromFile(new File(localFile)));
//        sop("File uploaded successfull!!");
//    }
//
//    private void sop(final String msg) {
//        System.out.println(msg); }
//}
