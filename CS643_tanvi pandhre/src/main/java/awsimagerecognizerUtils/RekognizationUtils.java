
package awsimagerecognizerUtils;

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

/**
 * @author tanvi
 * ucid - tp356
 *
 */
public class RekognizationUtils {
    
   //Method detectObject will detect the object Car and with the particular confidence level.
    public Boolean detectObject(String image, String confidenceLevel, String path) throws Exception {
        
        ByteBuffer imageBytes;
        try (InputStream inStream = new FileInputStream(new File(path + image))) 
        {
            imageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inStream));
        }
        // AmazonRekognition object created.
        AmazonRekognition rekogAgent = AmazonRekognitionClientBuilder.defaultClient();

        DetectLabelsRequest request = new DetectLabelsRequest()
                                        .withImage(new Image()
                                        .withBytes(imageBytes))
                                        .withMaxLabels(10)
                                        .withMinConfidence(Float.parseFloat(confidenceLevel));

        try {
            // object detection
            DetectLabelsResult result = rekogAgent.detectLabels(request);
            List <Label> labelslist = result.getLabels();
            System.out.println("Label for " + image);
            // iterate labels and identify 'car'
            for (Label label: labelslist) {             
               if (label.getName().equals("Car") && label.getConfidence() >= Integer.parseInt(confidenceLevel)) {
                   return true;
               }
            }
        } catch (AmazonRekognitionException e) {
            e.printStackTrace();
        }
        return false;
    }
  
    //This method will detect text from the image that is passed.
    public String detectText(String image, String path) throws Exception {
        ByteBuffer imageBytes;
        String detectedText = "";

        // generate byte stream for image
        try (InputStream inStream = new FileInputStream(new File(path + image))) 
        {
            imageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inStream));
        }


        AmazonRekognition rekogAgent = AmazonRekognitionClientBuilder.defaultClient();
        DetectTextRequest request = new DetectTextRequest()
                                        .withImage(new Image()
                                        .withBytes(imageBytes));

        try {
            DetectTextResult result = rekogAgent.detectText(request);
            
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
