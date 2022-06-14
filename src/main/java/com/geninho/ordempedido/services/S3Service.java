package com.geninho.ordempedido.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;


@Service
public class S3Service {
    private Logger LOG = LoggerFactory.getLogger(S3Service.class);

    @Autowired
    AmazonS3 s3client;

    @Value("${s3.bucket}")
    private String bucketName;

    public void uploadFile(String localFilePath){
        try{
            File file = new File(localFilePath);
            LOG.info("Iniciando upload.");
            s3client.putObject(new PutObjectRequest(bucketName,"teste.jpg",file));
            LOG.info("Upload finalizado.");
        } catch (AmazonServiceException e){
            LOG.info("AmazonServiceException: " + e.getErrorMessage() );
            LOG.info("Status code: " + e.getErrorCode());
        } catch (AmazonClientException e){
            LOG.info("AmazonClientException: " + e.getMessage() );
        }
    }
}
