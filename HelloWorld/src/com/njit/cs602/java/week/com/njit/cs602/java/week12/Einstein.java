package com.njit.cs602.java.week12;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Einstein extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Line line = new Line(35, 60, 150, 170);
		
		Circle circle = new Circle(100, 65, 20);
		circle.setFill(Color.BLUE);
		
		Rectangle rec = new Rectangle(60,70,250, 60);
		rec.setStroke(Color.RED);
		rec.setStrokeWidth(2);
		rec.setFill(null);
		
		
		
		Group group = new Group(line, circle, rec);
		Scene scene = new Scene(group, 500, 500);
		
		stage.setTitle("Einstein");
		stage.setScene(scene);
		stage.show();
		
		
	}

}
