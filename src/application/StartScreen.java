package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StartScreen {
	//Initialize Final variables for height and width.
	public static final int HEIGHT  = 500;
	public static final int WIDTH = 600;
	
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	public StartScreen() {
		mainPane = new AnchorPane();
		//Create a screen with the given width and height
		mainScene = new Scene(mainPane, WIDTH , HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		//Run all the button methods
		createButton();
		logo();
		//Run the background method
		createBackground();
	}
	
	//Getter for mainStage
	public Stage getMainStage() {
		return mainStage;
	}
	//Method which runs all the different buttons
	private void createButton() {
		playButton();
	}
	//Method for creating Play button
	public void playButton() {
		//Set the font inside the button
		Font font = Font.font("Algerian", FontWeight.EXTRA_BOLD, 25); 
		//Create the actual button, and place the text "Play" in it.
		Button button = new Button("   PLAY   ");
		//Style for the button
		button.setStyle("-fx-border-color: white; -fx-border-width: 5px; -fx-background-color: #38BFC5; -fx-text-fill: black");
		button.setFont(font);
		//Placement for the button
		button.setLayoutX(220);
		button.setLayoutY(200);
		mainPane.getChildren().add(button);
		
		//This method is called, when play button is clicked
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			//Open a new screen when play is pressed
			public void handle(ActionEvent event) {
				GameViewManager game = new GameViewManager();
				game.createNewGame(mainStage);;
				
			}
			
		});
	}
	
	//Method to create the background for start screen
	private void createBackground() {
		//Set backgroungImg to the image in the resource folder
		Image backgroundImg = new Image("resource/backGroundpic.jpg", 256,250,false,true);
		BackgroundImage background = new BackgroundImage(backgroundImg, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		//Set the actual background on the screen
		mainPane.setBackground(new Background(background));
	}
	private void logo() {
		Font font = Font.font("Algerian", FontWeight.EXTRA_BOLD, 55); 
		//Creating a Text object 
	      Text text = new Text();      
	      
	      //Setting the text to be added. 
	      text.setFont(font);
	      text.setText("Meteor Dodger");
	      text.setFill(Color.AQUA);
	      //setting the position of the text 
	      text.setX(100); 
	      text.setY(130);
	      mainPane.getChildren().add(text);
	         
		
		
	}
	
}