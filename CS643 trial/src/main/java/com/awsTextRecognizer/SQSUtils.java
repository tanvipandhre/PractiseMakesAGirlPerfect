/**
 * Dhruval Rana (Programming Assignment 1)
 * CS643 Fall 2022
 **/

package com.awsTextRecognizer;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.QueueDoesNotExistException;

import com.amazonaws.services.sqs.model.QueueDeletedRecentlyException;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import java.util.List;
import java.util.UUID;
import java.lang.InterruptedException;


public class SQSUtils{
    AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
    String queue_url = null ;
    
    
    
    public String creatNewQueue(String queuename) throws InterruptedException {
        CreateQueueRequest cr = new CreateQueueRequest(queuename)
                                    .addAttributesEntry("FifoQueue", "true")
                                    .addAttributesEntry("MessageRetentionPeriod", "86400");
        try {
            sqs.createQueue(cr);
            this.queue_url = sqs.getQueueUrl(queuename).getQueueUrl();
        } catch (AmazonSQSException e) 
        {
            if (e.getErrorCode().equals("AWS.SimpleQueueService.QueueAlreadyExists")) {
                System.out.println("The queue exists");
                this.queue_url = sqs.getQueueUrl(queuename).getQueueUrl();
            }
            
            else if (e.getErrorCode().equals("AWS.SimpleQueueService.QueueDeletedRecently")){
                System.out.println("The queue has been deleted, so try again later");
                System.exit(1);
            }
            else{
                throw e;
            }
        }
        return this.queue_url;
     }

     
    public String getQueueUrl(String queuename)throws InterruptedException {
         try
         {
            return sqs.getQueueUrl(queuename).getQueueUrl();
         }
         catch (QueueDoesNotExistException e) 
        {
            if (e.getErrorCode().equals("AWS.SimpleQueueService.NonExistentQueue") ||
                e.getErrorCode().equals("QueueDeletedRecently")) 
            {
                return this.creatNewQueue(queuename);
            }
            else
            {
                throw e;
            }
        }

    }
    

    
    public void sendMessage(String Message, String queueUrl){   
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();

        SendMessageRequest msg_request = new SendMessageRequest()
                                            .withQueueUrl(queueUrl)
                                            .withMessageBody(Message)
                                            .withMessageGroupId("1")
                                            .withMessageDeduplicationId(uuidAsString);
        
        
        sqs.sendMessage(msg_request);
    }

   
    public List<Message> receiveMessage(String queueUrl){
        List<Message> messages = sqs.receiveMessage(queueUrl).getMessages();
        return messages;
   }

    
    public boolean deleteMessage(String queueUrl, Message m){
        sqs.deleteMessage(queueUrl, m.getReceiptHandle());
        return true;
   }

   
    public boolean deleteQueue(String queueUrl){
        sqs.deleteQueue(queueUrl);
        return true;
    }
}