package com.njit.cs602.java.week12;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HellojavaFX extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Text hello = new Text(50, 50, "Hello");
		Text question = new Text(120, 80, "How are you?");
		
		Group group = new Group(hello, question);
		Scene scene = new Scene(group, 300, 120, Color.ALICEBLUE);
		
		stage.setTitle("JAVAFX program");
		stage.setScene(scene);
		stage.show();
	}

}
