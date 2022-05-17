package com.njit.cs602.java.week13;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;
import javafx.stage.Stage;


/**
 * @author Tanvi Pandhre
 * UCID - tp356
 *
 */
public class ColorChanger extends Application{
	int redVal, blueVal, greenVal;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Rectangle rec = new Rectangle(60,70,250, 60);
		rec.setStroke(Color.BLACK);
		rec.setStrokeWidth(2);
		rec.setFill(Color.BLACK);
		
		Slider redSlider = new Slider(0, 255, 0);
		redSlider.setShowTickLabels(true);
		redSlider.setShowTickMarks(true);
		
		Slider greenSlider = new Slider(0, 255, 0);
		greenSlider.setShowTickLabels(true);
		greenSlider.setShowTickMarks(true);
		
		Slider blueSlider = new Slider(0, 255, 0);
		blueSlider.setShowTickLabels(true);
		blueSlider.setShowTickMarks(true);
		
		
				
		
		redSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				
				System.out.println("new value ===="+redSlider.valueProperty());
				//redVal = newValue.intValue();
				redVal = redSlider.valueProperty().intValue();
				System.out.println("red value ===="+redVal);
				try {
					System.out.println("****"+redVal +"***"+greenVal+"***"+blueVal);
				 	 rec.setFill(Color.rgb(redVal, greenVal, blueVal));
				 }catch(IllegalArgumentException i) {
				 	System.out.println("Please place your cursor properly");
				 }
				
			}
			
		});
		
		blueSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue2) {
				// TODO Auto-generated method stub
				//translate.setX((double) newValue);
				System.out.println("new value 2 ===="+blueSlider.valueProperty());
				blueVal = blueSlider.valueProperty().intValue();
				System.out.println("blue value ===="+blueVal);
				try {
					System.out.println("****"+redVal +"***"+greenVal+"***"+blueVal);
				 	 rec.setFill(Color.rgb(redVal, greenVal, blueVal));
				 }catch(IllegalArgumentException i) {
				 	System.out.println("Please place your cursor properly");
				 }
				
			}
			
		});
		
		greenSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue3) {
				// TODO Auto-generated method stub
				//translate.setX((double) newValue);
				System.out.println("new value 3===="+greenSlider.valueProperty());
				greenVal = greenSlider.valueProperty().intValue();
				System.out.println("green value ===="+greenVal);
				try {
					System.out.println("****"+redVal +"***"+greenVal+"***"+blueVal);
				 	 rec.setFill(Color.rgb(redVal, greenVal, blueVal));
				 }catch(IllegalArgumentException i) {
				 	System.out.println("Please place your cursor properly");
				 }
				
			}
			
		});
		
        VBox vbox = new VBox(85);
		vbox.setPadding(new Insets(10));
		
		vbox.getChildren().addAll(redSlider, greenSlider, blueSlider,  rec);
		
		Scene scene = new Scene(vbox, 800, 500);
		stage.setScene(scene);
		stage.setTitle("Color Changer Box");
		stage.show();
		
		
	}
	

}
