/**
 * Dhruval Rana (Programming Assignment 1)
 * CS643 Fall 2022
 **/

package com.awsTextRecognizer;

import org.apache.commons.io.FileUtils;
import com.amazonaws.services.sqs.model.Message;

import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.*;


public class TextRecognizer {
    private static String bucketName;
    private static List<String> keys;
    private static String path;
    private static String outputpath;
    private static String queuename;
    

    public static void main(String[] args) throws Exception
    {
        System.out.println("TextRecognizer to begin");
        // Instantiate Utils objects
        S3Utils S3 = new S3Utils();
        SQSUtils sqs = new SQSUtils();
        RekognizationUtils rkobject = new RekognizationUtils();
        
        // flag for stopping execution on index -1
        Boolean mFlag = true;

        String filetext = ""; 
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        
        // read config property file
        InputStream input = TextRecognizer.class.getClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();
        prop.load(input);
        bucketName = prop.getProperty("bucketname");
        path = prop.getProperty("imagedownloadpath");
        outputpath = prop.getProperty("outputstorepath");
        queuename = prop.getProperty("sqsqueuename");

       
        // verify S3 bucket exists
        Boolean result = S3.bucketExists(bucketName);
        if (! result){
            System.out.println("Time to exit");
            System.exit(1);
        }

        // get sqs queue name
        String queueUrl = sqs.getQueueUrl(queuename);
        HashMap<String, String> pImage = new HashMap<String, String>();
        
        System.out.println("Messages to be polled");
        // poll for messages from sqs queue
        do {
            List<Message> messages = sqs.receiveMessage(queueUrl);
            int size = messages.size();
            
            if (size != 0)
            {
               for(Message each_message: messages)
               {
                    String each_key = each_message.getBody();
                   // avoid duplicate message processing 
                   if (pImage.containsKey(each_key)){
                       continue;
                    }
                    // signal to stop processing
                    if (each_key.equals("-1")){
                        System.out.println("End Index (-1) received !!, Stopping Polling ");
                        sqs.deleteMessage(queueUrl, each_message);
                        mFlag = false;
                        break;
                    }

                    // create output.txt at output path
                    File file =new File(outputpath + "output.txt");
                    file.getParentFile().mkdirs(); 
                    if(!file.exists()){
                        file.createNewFile();
                    }
                    FileWriter fw = new FileWriter(file,true);
                    BufferedWriter bw = new BufferedWriter(fw);

      
                    // download image and detect text if any
                    S3.downloadBucketObjectByKey(bucketName, each_key, path);
                    String detectedText = rkobject.detectText(each_key, path);
                    pImage.put(each_key, detectedText);
                    
                    // ignore images without text
                    if (!detectedText.isEmpty())
                    {   filetext = "";
                        filetext = ("-------------------------------\n");

                        filetext = filetext + "message processed at\t: " + formatter.format(LocalDateTime.now()) + ""; 
                        filetext = filetext + "\nFileIndex:\t" + each_key;
                        filetext = filetext + ("\nTextFound:\t" + detectedText +"\n");
                        
                        System.out.println(filetext);
                        // writing text to file
                        bw.write(filetext);
                        bw.close();
                    }
                    sqs.deleteMessage(queueUrl, each_message);
                    
                }
                
            }
            else
                {
                    System.out.println("There is no message in the queue ");
                    System.out.println("Will poll after 2s");
                    System.out.println("Waiting for a message");
                    Thread.sleep(2000);
                }
        }while(mFlag);
        // clean up activity
        FileUtils.deleteDirectory(new File(path)); 
    
        //sqs.deleteQueue(queueUrl);
        System.out.println("Output being kept at " + outputpath + "output.txt" );
        System.out.println("All messages have been processed, time to exit");
        
    }  
}

