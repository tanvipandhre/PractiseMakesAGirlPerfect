
package awsimagerecognizerUtils;

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

/**
 * @author tanvi
 * ucid - tp356
 *
 */

//Amazon S3 Java Client provides a simple interface that can be used  to store and retrieve any amount of data, at any time, from anywhere on the web

public class S3Utils{
	
    AmazonS3 s3Client;
    
    public S3Utils(){
        Regions clientRegion = Regions.US_EAST_1;
        //creating s3 client 
        s3Client = AmazonS3ClientBuilder.standard()
                            .withCredentials(new ProfileCredentialsProvider())
                            .withRegion(clientRegion)
                            .build();
    }
                            

    //checks if bucket exists
    public boolean isBucket(String bucket_name){
        try {
            if (s3Client.doesBucketExistV2(bucket_name)) {
                System.out.format("Bucket %s exists.\n", bucket_name);
                return true;
        }
    }
        catch (AmazonS3Exception e) {
            e.printStackTrace();
        }
        return false;
    }

   /// it returns list of keys from the s3 bucket
    public List<String> listOfKeysFromS3Bucket(String bucketName){
        List<String> s3keys = new ArrayList<String>();
        try {
            
            ListObjectsV2Request req = new ListObjectsV2Request().withBucketName(bucketName).withMaxKeys(20);
            ListObjectsV2Result result;
            do {
                result = s3Client.listObjectsV2(req);
                for (S3ObjectSummary summary : result.getObjectSummaries()) {
                    s3keys.add(summary.getKey());
                    
                }
                String token = result.getNextContinuationToken();
               
                req.setContinuationToken(token);
            } while (result.isTruncated());
        } catch (AmazonServiceException e) {
          
            e.printStackTrace();
        } catch (SdkClientException e) {
            
            e.printStackTrace();
        }
        return s3keys;
    }

   
    public void downloadBucketObjectByKey(String bucket_name, String key, String path){
            System.out.format("Downloading image no. "+ key + " from bucket "+ bucket_name);
            final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
            try {
                S3Object o = s3.getObject(bucket_name, key);
                S3ObjectInputStream s3is = o.getObjectContent();
                File file = new File(path + key);
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
                e.printStackTrace();
            } catch (FileNotFoundException e) {
            	e.printStackTrace();
            } catch (IOException e) {
            	e.printStackTrace();
            }
            System.out.println("Downloaded image no. " + key );
        }

}