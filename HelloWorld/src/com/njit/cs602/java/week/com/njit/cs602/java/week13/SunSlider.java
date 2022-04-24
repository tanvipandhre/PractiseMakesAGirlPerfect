package com.njit.cs602.java.week13;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class SunSlider extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Circle circle = new Circle(20);
		circle.setFill(Color.YELLOW);
		circle.setStroke(Color.BLUEVIOLET);
		
		Slider slider = new Slider(0, 500, 0);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(100);
		slider.setBlockIncrement(50);
		//root.
		slider.setMaxWidth(300);
		
		Translate translate = new Translate();
		
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				translate.setX((double) newValue);
				System.out.println("new value ===="+newValue);
				translate.setY(50);
				translate.setZ(100);
				
			}
			
		});
		
		circle.getTransforms().add(translate);
		
		VBox vbox = new VBox(85);
		vbox.setPadding(new Insets(10));
		vbox.getChildren().addAll(slider, circle);
		vbox.setStyle("-fx-background-color: BEIGE");
		
		Scene scene = new Scene(vbox, 400, 250);
		stage.setScene(scene);
		
		//root.getChildren().add(slider);
		stage.show();
	}

}
