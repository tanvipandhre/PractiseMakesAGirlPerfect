package com.njit.cs602.java.week1.part2;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ImageDisplay extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Image img = new Image("T://Download dump//SHWETA.jpeg");
		ImageView imgView = new ImageView(img);
		
		StackPane pane = new StackPane(imgView);
		pane.setStyle("-fx-background-color: cornsilk");
		
		Scene scene = new Scene(pane, 500, 350);
		
		stage.setTitle("Einstein");
		stage.setScene(scene);
		stage.show();
		
	}

}
