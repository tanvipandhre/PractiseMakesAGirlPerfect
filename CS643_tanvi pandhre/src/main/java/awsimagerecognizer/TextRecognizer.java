
package awsimagerecognizer;

import org.apache.commons.io.FileUtils;
import com.amazonaws.services.sqs.model.Message;

import awsimagerecognizerUtils.RekognizationUtils;
import awsimagerecognizerUtils.S3Utils;
import awsimagerecognizerUtils.SQSUtils;

import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.*;


/**
 * @author tanvi
 * ucid - tp356
 *
 */
public class TextRecognizer {
    private static String bucketName;
    private static List<String> keys;
    private static String path;
    private static String outputPath;
    private static String sqsQueueName;
    

    public static void main(String[] args) throws Exception
    {
        System.out.println("------Starting TextRecognizer -------");
        // Instantiate Utils objects
        S3Utils s3 = new S3Utils();
        SQSUtils sqs = new SQSUtils();
        RekognizationUtils rkobject = new RekognizationUtils();
        
        // flag for stopping execution on index -1
        Boolean mFlag = true;

        String content = ""; 
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        
        // read config property file
        InputStream input = TextRecognizer.class.getClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();
        prop.load(input);
        bucketName = prop.getProperty("bucketName");
        path = prop.getProperty("pathOfImages");
        outputPath = prop.getProperty("resultantPath");
        sqsQueueName = prop.getProperty("sqsQueueName");

       
        // check if S3 bucket exists
        Boolean bucketExist = s3.isBucket(bucketName);
        if (!bucketExist){
            System.out.println("Bucket "+bucketName+" does not exists.");
            System.exit(1);
        }

        // get sqs queue name
        String queueUrl = sqs.getQueueUrl(sqsQueueName);
        HashMap<String, String> map = new HashMap<String, String>();
        // receiving messages from sqs queue
        System.out.println("Receiving Messages..");
        
        do {
            List<Message> messages = sqs.receiveMessage(queueUrl);
            int size = messages.size();
            
            if (size != 0)
            {
               for(Message msg: messages)
               {
                    String key = msg.getBody();
                   // check if whether the key already exists 
	                   if (!map.containsKey(key)){
	                	   // signal to stop processing
	                       if (key.equals("-1")){
	                           System.out.println("Polling needs to be stopped. -1 is received from SQS. ");
	                           sqs.deleteMessage(queueUrl, msg);
	                           mFlag = false;
	                           break;
	                       }
	
	                       // create output.txt at output path
	                       File file =new File(outputPath + "output.txt");
	                       file.getParentFile().mkdirs(); 
	                       if(!file.exists()){
	                           file.createNewFile();
	                       }
	                       FileWriter fw = new FileWriter(file,true);
	                       BufferedWriter bw = new BufferedWriter(fw);
	
	         
	                       // download image and detect text if any
	                       s3.downloadBucketObjectByKey(bucketName, key, path);
	                       String text = rkobject.detectText(key, path);
	                       map.put(key, text);
	                       
	                       // ignore images without text
	                       if (!text.isEmpty())
	                       {   content = "";
	                           content = ("-------------------------------\n\n");
	
	                            
	                           content = content + "\nIndex:\t" + key;
	                           content = content + ("\nText:\t" + text +"\n");
	                           
	                           System.out.println(content);
	                           // writing text to file
	                           bw.write(content);
	                           bw.close();
	                       }
	                       sqs.deleteMessage(queueUrl, msg);
	                       
	
	                    }
                }
                
            }
            else
                {
                    System.out.println("No Message found in queue");
                    System.out.println("Will poll after 3s");
                    System.out.println("-------waiting for message------------");
                    Thread.sleep(3000);
                }
        }while(mFlag);
        FileUtils.deleteDirectory(new File(path)); 
        System.out.println("Please find the output in " + outputPath + "output.txt" );
        System.out.println("------Tanvi's programming assignment 1 of CS634 is completed.------------");
        
    }  
}

