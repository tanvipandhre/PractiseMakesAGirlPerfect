package com.njit.cs602.java.week13;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ClickDistance extends Application{
	private Line line;
	private Text distanceText;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		line = new Line(0, 0, 0, 0);
		distanceText = new Text(150, 30, "Distance== ");
		
		Group root = new Group(line, distanceText);
		Scene scene = new Scene(root, 400, 300);
		scene.setOnMouseClicked(this:: processMouseClick);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void processMouseClick(MouseEvent event) {
		double clickX = event.getX();
		double clickY = event.getY();
		
		line.setEndX(clickX);
		line.setEndY(clickY);
		
		double distance = Math.sqrt(clickX * clickX + clickY * clickY);
		String distanceStr = String.format("%.2f", distance);
		distanceText.setText(distanceStr);
		
	}

}
