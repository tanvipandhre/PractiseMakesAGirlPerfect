/**
 * Dhruval Rana (Programming Assignment 1)
 * CS643 Fall 2022
 **/

package com.awsTextRecognizer;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class S3Utils{

    AmazonS3 clientS3;
   
    // constructor creat client for S3
    public S3Utils(){
        Regions clientRegion = Regions.US_EAST_1;
        clientS3 = AmazonS3ClientBuilder.standard()
                            .withCredentials(new ProfileCredentialsProvider())
                            .withRegion(clientRegion)
                            .build();
    }
                            

    /**
     * verify given bucket exists in Cs-643 s3 account
     * @return boolean True/False
     */
    public boolean bucketExists(String bucket_name){
        try {
            if (clientS3.doesBucketExistV2(bucket_name)) {
                System.out.format("Bucket %s exists.\n", bucket_name);
                return true;
        }
    }
        catch (AmazonS3Exception e) {
            System.err.println(e.getErrorMessage());
        }
        return false;
    }

    
    public List<String> listS3Bucket(String bucketName){
        List<String> s3keys = new ArrayList<String>();
        try {
            System.out.println("S3Bucket objects being shown");
            ListObjectsV2Request req = new ListObjectsV2Request().withBucketName(bucketName).withMaxKeys(15);
            ListObjectsV2Result result;
            do {
                result = clientS3.listObjectsV2(req);
                for (S3ObjectSummary objectSummary : result.getObjectSummaries()) {
                    s3keys.add(objectSummary.getKey());
                    System.out.printf(" - %s\n", objectSummary.getKey());
                }
                String token = result.getContinuationToken();
                System.out.println("Continuation Token: " + token);
                req.setContinuationToken(token);
            } while (result.isTruncated());
        } catch (AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process 
            // it, so it returned an error response.
            e.printStackTrace();
        } catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
        return s3keys;
    }

   
    public void downloadBucketObjectByKey(String bucket_name, String key_name, String path){
            System.out.format("Downloading %s from S3 bucket %s...\n", key_name, bucket_name);
            final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
            try {
                S3Object o = s3.getObject(bucket_name, key_name);
                S3ObjectInputStream s3is = o.getObjectContent();
                File file = new File(path + key_name);
                file.getParentFile().mkdirs(); 
                file.createNewFile();
                FileOutputStream fos = new FileOutputStream(file, false);
                byte[] read_buf = new byte[1024];
                int read_len = 0;
                while ((read_len = s3is.read(read_buf)) > 0) {
                    fos.write(read_buf, 0, read_len);
                }
                s3is.close();
                fos.close();
            } catch (AmazonServiceException e) {
                System.err.println(e.getErrorMessage());
                System.exit(1);
            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
                System.exit(1);
            } catch (IOException e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
            System.out.println("Downloading done for " + key_name );
        }

}