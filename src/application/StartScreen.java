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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class StartScreen {
	public static final int HEIGHT  = 500;
	public static final int WIDTH = 600;
	
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	
	public static boolean pressStart = false;
	
	public StartScreen() {
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH , HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		createButton();
		createBackground();
	}

	public Stage getMainStage() {
		return mainStage;
	}
	private void createButton() {
		playButton();
		optionsButton();
		creditButton();
	}
	public void playButton() {
		Font font = Font.font("Algerian", FontWeight.EXTRA_BOLD, 25); 
		Button button = new Button("   PLAY   ");
		button.setStyle("-fx-border-color: white; -fx-border-width: 5px; -fx-background-color: #38BFC5; -fx-text-fill: black");
		button.setFont(font);
		button.setLayoutX(100);
		button.setLayoutY(100);
		mainPane.getChildren().add(button);
		
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				GameScreen game = new GameScreen();
				game.newGame(mainStage);;
				pressStart = true;
			}
			
		});
	}
	
	public void optionsButton() {
		Font font = Font.font("Algerian", FontWeight.EXTRA_BOLD, 25); 
		Button button = new Button(" OPTIONS");
		button.setStyle("-fx-border-color: white; -fx-border-width: 5px; -fx-background-color: #38BFC5; -fx-text-fill: black");
		button.setFont(font);
		button.setLayoutX(100);
		button.setLayoutY(200);
		mainPane.getChildren().add(button);
	}
	public void creditButton() {
		Font font = Font.font("Algerian", FontWeight.EXTRA_BOLD, 25); 
		Button button = new Button(" CREDITS ");
		button.setStyle("-fx-border-color: white; -fx-border-width: 5px; -fx-background-color: #38BFC5; -fx-text-fill: black");
		button.setFont(font);
		button.setLayoutX(100);
		button.setLayoutY(300);
		mainPane.getChildren().add(button);
	}
	private void createBackground() {
		Image backgroundImg = new Image("resource/backGroundpic.jpg", 256,250,false,true);
		BackgroundImage background = new BackgroundImage(backgroundImg, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}
	  





}
