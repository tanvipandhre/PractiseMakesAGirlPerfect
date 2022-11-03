
package awsimagerecognizer;
import java.util.*;

import java.io.InputStream;
import org.apache.commons.io.FileUtils;

import awsimagerecognizerUtils.RekognizationUtils;
import awsimagerecognizerUtils.S3Utils;
import awsimagerecognizerUtils.SQSUtils;

import java.io.*;

/**
 * @author tanvi
 * ucid - tp356
 *
 */
public class ObjectRecognizer {
    private static String bucketName;//s3 bucket = "njit-cs-643";
    private static List<String> keys;
    private static String confidenceLevel;//"90";
    private static String path;
    private static String sqsQueueName;

    public static void main(String[] args) throws Exception
    {
        try
        {
            // Instantiate utils objects 
            S3Utils s3 = new S3Utils();
            SQSUtils sqs = new SQSUtils();
            RekognizationUtils rkobject = new RekognizationUtils();


            // read config.properties file and load all the properties
            InputStream input = ObjectRecognizer.class.getClassLoader().getResourceAsStream("config.properties");
            Properties prop = new Properties();
            prop.load(input);
            bucketName = prop.getProperty("bucketName");
            confidenceLevel = prop.getProperty("confidenceLevel");
            path = prop.getProperty("pathOfImages");
            sqsQueueName = prop.getProperty("sqsQueueName");
        
            Boolean bucketExist = s3.isBucket(bucketName);

            if (bucketExist){
                //lists all the keys from the bucket
                keys = s3.listOfKeysFromS3Bucket(bucketName);
                //create new queue called cs643-sqs-tanvi-queue.fifo
                String queueUrl = sqs.creatNewQueue(sqsQueueName);
            
                for (String key : keys) { 		 
                
                    // download each object  from the s3 bucket   
                    s3.downloadBucketObjectByKey(bucketName, key, path);

                     
                    System.out.println("Retrieving image no. " + key+"from S3 bucket ");
                    //check if the object is car with the sufficient confidence level.
                    boolean isCar = rkobject.detectObject(key, confidenceLevel, path);
                    
                    if (isCar){
                        System.out.println("Car detected on image no. " + key );
                      //Once we get the object it is checked whether the object is a car and send its index key to the sqs queue.
                        sqs.sendMessage(key, queueUrl);
                    }
            }
            //Once instance A  terminates its image processing, it adds index -1 to the queue to signal to instance B that no more indexes will come.
            sqs.sendMessage("-1", queueUrl);
        
            FileUtils.deleteDirectory(new File(path)); 
            System.out.println("All images have been processed.");
            }
        } 
        catch(InterruptedException e){
            e.printStackTrace();
        }
        }
    }

