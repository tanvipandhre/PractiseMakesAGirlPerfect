package com.njit.cs602.java.week13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;

public class KeyExample  extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane pane = new BorderPane();
		Button button = new Button("Press me!");
		pane.setCenter(button);
		
		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		button.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if(event.getCode()==KeyCode.ALT) {
					System.out.println("Happy New Year!");
				}
				
			}
			
		});
		
	}

}
