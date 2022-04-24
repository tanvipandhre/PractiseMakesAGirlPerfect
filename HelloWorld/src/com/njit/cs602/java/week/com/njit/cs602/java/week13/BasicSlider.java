package com.njit.cs602.java.week13;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class BasicSlider extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Group root = new Group();
		Scene scene = new Scene(root, 700, 200);
		
		stage.setScene(scene);
		stage.setTitle("Slider sample");
		//						max min default
		//Slider slider = new Slider(0, 1, 0.5);
		Slider slider = new Slider(0, 255, 0);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(50);
		slider.setBlockIncrement(50);
		//root.
		slider.setMaxWidth(500);
		
		root.getChildren().add(slider);
		stage.show();
	}

}
