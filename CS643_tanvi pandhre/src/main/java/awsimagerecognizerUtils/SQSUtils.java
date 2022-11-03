

package awsimagerecognizerUtils;

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
/**
 * @author tanvi
 * ucid - tp356
 *
 */
public class SQSUtils{
    AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
    String queue_url = null ;
    
    //it generates sqs queue url from the passed queue name
    public String getQueueUrl(String sqsQueueName)throws InterruptedException {
         try
         {
            return sqs.getQueueUrl(sqsQueueName).getQueueUrl();
         }
         catch (QueueDoesNotExistException e) 
        {
            if (e.getErrorCode().equals("AWS.SimpleQueueService.NonExistentQueue") ||
                e.getErrorCode().equals("QueueDeletedRecently")) 
            {
                return this.creatNewQueue(sqsQueueName);
            }
            else
            {
                throw e;
            }
        }

    }
    //This method will create new fifo queue with certain retention period. Will also check if queue already exists or not. Create one if not  
    
    public String creatNewQueue(String sqsQueueName) throws InterruptedException {
        CreateQueueRequest cr = new CreateQueueRequest(sqsQueueName)
                                    .addAttributesEntry("FifoQueue", "true")
                                    .addAttributesEntry("MessageRetentionPeriod", "86400");
        try {
            sqs.createQueue(cr);
            this.queue_url = sqs.getQueueUrl(sqsQueueName).getQueueUrl();
        } catch (AmazonSQSException e) 
        {
            if (e.getErrorCode().equals("AWS.SimpleQueueService.QueueAlreadyExists")) {
                System.out.println("Queue already exists!!");
                this.queue_url = sqs.getQueueUrl(sqsQueueName).getQueueUrl();
            }
            
            else if (e.getErrorCode().equals("AWS.SimpleQueueService.QueueDeletedRecently")){
                System.out.println("Queue recently deleted, Please wait for sometime and retry!!");
                System.exit(1);
            }
            else{
                throw e;
            }
        }
        return this.queue_url;
     }


    

    //It will generates a random unique identifier uuid. It will generate message to be sent to the sqs queue
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

    // It will receive all the messages passing through the sqs queue
    public List<Message> receiveMessage(String queueUrl){
        List<Message> messages = sqs.receiveMessage(queueUrl).getMessages();
        return messages;
   }

   //it will delete message pasing through the sqs queue
    public boolean deleteMessage(String queueUrl, Message m){
        sqs.deleteMessage(queueUrl, m.getReceiptHandle());
        return true;
   }

   //it will delete entire queue
    public boolean deleteQueue(String queueUrl){
        sqs.deleteQueue(queueUrl);
        return true;
    }
}