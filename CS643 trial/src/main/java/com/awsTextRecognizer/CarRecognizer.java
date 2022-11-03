/**
 * Dhruval Rana (Programming Assignment 1)
 * CS643 Fall 2022
 **/

package com.awsTextRecognizer;
import java.util.*;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import java.io.*;


public class CarRecognizer {
    private static String bucketName;//= "njit-cs-643";
    private static List<String> keys;
    private static String confidence;//= "80";
    private static String path;
    private static String queuename;

    public static void main(String[] args) throws Exception
    {
        try
        {
            // Instantiate utils objects
            S3Utils S3 = new S3Utils();
            SQSUtils sqs = new SQSUtils();
            RekognizationUtils rkobject = new RekognizationUtils();


            // read config parameters
            InputStream input = CarRecognizer.class.getClassLoader().getResourceAsStream("config.properties");
            Properties prop = new Properties();
            prop.load(input);
            bucketName = prop.getProperty("bucketname");
            confidence = prop.getProperty("confidence");
            path = prop.getProperty("imagedownloadpath");
            queuename = prop.getProperty("sqsqueuename");
        
            // verify if bucket exists
            Boolean result = S3.bucketExists(bucketName);

            if (result){
                // list S3 bucket content
                keys = S3.listS3Bucket(bucketName);

                // create FIFO queue in aws SQS 
        
                String queueUrl = sqs.creatNewQueue(queuename);
            
                // iterate through bucket content 
                for (String each_key : keys) { 		 
                
                    // download each object     
                    S3.downloadBucketObjectByKey(bucketName, each_key, path);

                    // detect object in image using aws rekognization 
                    System.out.println("Image being scanned" + each_key + "for car");
                    boolean isCar = rkobject.detectCar(each_key, confidence, path);
                    if (isCar){
                        System.out.println("The car has been detected in the image" + each_key + ", index being sent to queue");
                        sqs.sendMessage(each_key, queueUrl);
                    }
            }
            sqs.sendMessage("-1", queueUrl);
        
            FileUtils.deleteDirectory(new File(path)); 
            System.out.println("Messages have been displayed, program over and out");
            }
        } 
        catch(InterruptedException e){
            throw e;
        }
        }
    }

