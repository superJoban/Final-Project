package application;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameScreen{
	private AnchorPane gamePane;
	private Scene gameScene;
	private Stage gameStage;
	private Stage menuStage;
	
	//Method for the actual gameplay
	public void startGame() {
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, 600, 500);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		
	}

	public void newGame(Stage menuStage) {
		//start the game. Empty screen
		startGame();
		this.menuStage = menuStage;
		//Hide menu screen, and show the game play screen
		this.menuStage.hide();
		this.gameStage.show();
		
	}
}
