package com.njit.cs602.java.week1.part2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PushCounter extends Application{
	private int count;
	private Text countText;
	public static void main(String[] args)  {
		// TODO Auto-generated method stub

	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		count = 0;
		countText = new Text("Pushes: 0");
		
		Button button = new Button("Push me!");
		button.setOnAction(this::processButtonPress);
		
		FlowPane pane = new FlowPane(button, countText);
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(20);
		Scene scene = new Scene(pane, 300, 100);
		
		stage.setTitle("Push Counter");
		stage.setScene(scene);
		stage.show();
		
		
	}
	public void processButtonPress(ActionEvent event) {
		count++;
		countText.setText("Pushes: "+count);
	}

}
