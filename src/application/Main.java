package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {
   public static void main(String[] args) {
       launch(args);
   }
   @Override
   public void start(Stage primaryStage) {
	   try {
		   StartScreen manager = new StartScreen();
		   primaryStage = manager.getMainStage();
		   primaryStage.setTitle("Game??");
		   primaryStage.show();
	   } catch(Exception e) {
		   e.printStackTrace();
	   }
       
   }

}