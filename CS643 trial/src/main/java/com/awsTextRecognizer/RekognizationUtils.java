/**
 * Dhruval Rana (Programming Assignment 1)
 * CS643 Fall 2022
 **/

package com.awsTextRecognizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.AmazonRekognitionException;
import com.amazonaws.services.rekognition.model.DetectLabelsRequest;
import com.amazonaws.services.rekognition.model.DetectLabelsResult;
import com.amazonaws.services.rekognition.model.DetectTextRequest;
import com.amazonaws.services.rekognition.model.DetectTextResult;
import com.amazonaws.services.rekognition.model.TextDetection;
import com.amazonaws.services.rekognition.model.Image;
import com.amazonaws.services.rekognition.model.Label;
import com.amazonaws.util.IOUtils;


public class RekognizationUtils {
    
    public Boolean detectCar(String photo, String confidence, String path) throws Exception {
        
        ByteBuffer imageBytes;
        // create byte stream of given input image
        try (InputStream inStream = new FileInputStream(new File(path + photo))) 
        {
            imageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inStream));
        }

        AmazonRekognition rekogClient = AmazonRekognitionClientBuilder.defaultClient();

        DetectLabelsRequest request = new DetectLabelsRequest()
                                        .withImage(new Image()
                                        .withBytes(imageBytes))
                                        .withMaxLabels(10)
                                        .withMinConfidence(Float.parseFloat(confidence));

        try {
            // send for object detection
            DetectLabelsResult result = rekogClient.detectLabels(request);
           
            List <Label> labelslist = result.getLabels();
            System.out.println("Labels are identified for" + photo);
            // iterate labels and identify 'car'
            for (Label label: labelslist) {             
               if (label.getName().equals("Car") && label.getConfidence() >= Integer.parseInt(confidence)) {
                   return true;
               }
            }
        } catch (AmazonRekognitionException e) {
            e.printStackTrace();
        }
        return false;
    }
  
    
    public String detectText(String photo, String path) throws Exception {
        ByteBuffer imageBytes;
        String detectedText = "";

        // generate byte stream for image
        try (InputStream inStream = new FileInputStream(new File(path + photo))) 
        {
            imageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inStream));
        }


        AmazonRekognition rekogClient = AmazonRekognitionClientBuilder.defaultClient();
        DetectTextRequest request = new DetectTextRequest()
                                        .withImage(new Image()
                                        .withBytes(imageBytes));

        try {
            DetectTextResult result = rekogClient.detectText(request);
            
            List<TextDetection> textDetections = result.getTextDetections();
            for (TextDetection text: textDetections) {
                if (detectedText.isEmpty()){
                  detectedText = text.getDetectedText();
                }
                else {
                    detectedText = detectedText +  " " + text.getDetectedText();
                }

            }
            
        } catch (AmazonRekognitionException e) {
            e.printStackTrace();
        }
        return detectedText;
    }
}
