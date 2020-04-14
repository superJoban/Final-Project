package application;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import  javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

 /** After "Play" has been clicked, a new window pops up which is controlled by this class. 
 * GameViewManager class is used to display the actual game play of the Meteor Dodger game
 */
public class GameViewManager {
	
	//Initialize variables
	private AnchorPane gamePane;
	private Scene gameScene;
	private Stage gameStage;
	private Stage menuStage;
	private boolean isLeftKeyPressed;
	private boolean isRightKeyPressed;
	private AnimationTimer gameTimer;
	private int angle;
	private GridPane gridPane1;
	private GridPane gridPane2;
	
	//Set game width and Height
	private static final int GAME_WIDTH = 600;
	private static final int GAME_HEIGHT = 600;
	
	/*Upload ship image and initialize it to the variable Ship*/
	Image image = new Image("resource/spaceShips_007.png", 55, 55, false, true);
	ImageView ship = new ImageView(image);
	
	//Background Image
	private final static String BACKGROUND_IMAGE = "resource/stars.jpg";
	
	//Uploading meteor image and initializing it to the variable meteor
	Image meteor = new Image("resource/spaceMeteors_001.png", 55, 55, false, true);
	private static ImageView[] meteors;
	
	public static final int STAR_RADIUS = 25;
	public static final int METEOR_RADIUS = 23;
	public static final int SHIP_RADIUS = 27;
	Random rand = new Random();
	
	private ImageView star;
	private scoreBoard pointsLabel;
	private int playerLife;
	private int points;
	
	//uploading and Initializing star which give points
	Image stars = new Image("resource/star.png", 45, 45, false, true);
	
	//Constructor
	public GameViewManager() {
		initializeStage();
		createKeyListeners();
	}

	/*This method is responsible for keyboard input.
	 * Using the arrow key, the user can move the ship either left and right
	 */
	private void createKeyListeners() {
		
		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.LEFT) {
					isLeftKeyPressed = true;
				} else if (event.getCode() == KeyCode.RIGHT) {
					isRightKeyPressed = true;
				}
			}
		});		
		gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.LEFT) {
					isLeftKeyPressed = false;
				} else if (event.getCode() == KeyCode.RIGHT) {
					isRightKeyPressed = false;
				}			
			}
		});
	}
	
	//Method used to create the gameboard
	private void initializeStage() {
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, GAME_WIDTH,GAME_HEIGHT);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
	}
	
	//Main method that creates the actual game and runs the other methods
	public void createNewGame(Stage menuStage) {
		this.menuStage = menuStage;
		this.menuStage.hide();
		createBackground();
		createShip();
		createGameElements();
		createGameLoop();
		gameStage.show(); 
	}
	
	//Game loop for moving ship, meteors and background
	private void createGameLoop() {
		gameTimer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				moveBackground();
				moveElements();
				respawn();
				moveShip();
				collisionDetection();
			}
			
		};	
		gameTimer.start();
	}
	
	//Method used to move the actual ship
	private void moveShip() {
		if (isLeftKeyPressed && !isRightKeyPressed) {
			if(angle > -30) {
				angle -= 5;
			}
			ship.setRotate(angle);
			
			if(ship.getLayoutX() > -20) {
				ship.setLayoutX(ship.getLayoutX() -3);
			}
		}		
		if (isRightKeyPressed && !isLeftKeyPressed) {
			if(angle < 30) {
				angle +=5;
			}
			ship.setRotate(angle);
			
			if(ship.getLayoutX() < 522) {
				ship.setLayoutX(ship.getLayoutX()+3);
			}
		}	
		if (!isLeftKeyPressed && !isRightKeyPressed) {
			if(angle < 0) {
				angle += 5;
			}else if (angle > 0) {
				angle -= 5;
			}
			ship.setRotate(angle);
			
		}
		if (isLeftKeyPressed && isRightKeyPressed) {
			if(angle < 0) {
				angle += 5;
			}else if (angle > 0) {
				angle -= 5;
			}
			ship.setRotate(angle);
		}	
	}
	
	//Method for background creation
	private void createBackground() {
		gridPane1 = new GridPane();
		gridPane2 = new GridPane();
		
		for(int i = 0; i < 12; i++) {
			ImageView backgroundImage1 = new ImageView(BACKGROUND_IMAGE);
			ImageView backgroundImage2 = new ImageView(BACKGROUND_IMAGE);
			GridPane.setConstraints(backgroundImage1, i%3, i/3);
			GridPane.setConstraints(backgroundImage2, i%3, i/3);
			gridPane1.getChildren().add(backgroundImage1);
			gridPane1.getChildren().add(backgroundImage2);
		}
		gridPane2.setLayoutY(-1024);
		gamePane.getChildren().addAll(gridPane1, gridPane2);
	}
	
	//Method that allows the background.
	private void moveBackground() {
		gridPane1.setLayoutY(gridPane1.getLayoutY()+0.5);
		gridPane2.setLayoutY(gridPane1.getLayoutY()+0.5);
		
		if(gridPane1.getLayoutY() >= 0) {
			gridPane1.setLayoutY(-1024);	
		}
		if(gridPane2.getLayoutY() >= 0) {
			gridPane2.setLayoutY(-1024);	
		}
	}
	
	//Method to create the actual ship and place it on the gameboard
	public void createShip() {
		ship.setLayoutX(GAME_WIDTH/2);
		ship.setLayoutY(GAME_HEIGHT - 90);
		gamePane.getChildren().add(ship);
	}
	
	/**Method used to create and place game elements.
	 * Game elements include meteors, and stars
	 */
	public void createGameElements() {
		star = new ImageView(stars);
		setPosition(star);
		gamePane.getChildren().add(star);
		pointsLabel = new scoreBoard("POINTS: 00");
		pointsLabel.setLayoutX(460);
		pointsLabel.setLayoutY(20);
		gamePane.getChildren().add(pointsLabel);
		
		meteors = new ImageView[3];
		for(int i = 0; i < meteors.length; i++) {
			meteors[i] = new ImageView(meteor);
			setPosition(meteors[i]);
			gamePane.getChildren().add(meteors[i]);
		}
	}
	
	//Method that allows the game elements to move
	public  void moveElements() {
		star.setLayoutY(star.getLayoutY()+5);
		
		for(int i = 0; i < meteors.length; i++) {
			meteors[i].setLayoutY(meteors[i].getLayoutY()+7);
			meteors[i].setRotate(meteors[i].getRotate()+4);
		}
	}
	
	/*Once the game elements reach the bottom of the screen, this 
	 * method allows them to respawn at the top allowing them to continuously coming
	 */
	public void respawn() {
		if(star.getLayoutY() > 1200) {
			setPosition(star);
		}
		for(int i = 0; i < meteors.length; i++) {
			if(meteors[i].getLayoutY() > 900) {
				setPosition(meteors[i]);
			}
		}
	}
	
	//Method used to place the game elements randomly 
	public void setPosition(ImageView image) {
		image.setLayoutX(rand.nextInt(400));
		image.setLayoutY(-(rand.nextInt(1000)+500));
	}
	
	/**Method that check for collision. If the meteor hits the ship, it will call the method playerLife,
	 * and this will bring you back to the main menu. If the ship hits the star, a point will be added to the 
	 * scoreboard.
	 */
	private void collisionDetection() {
		//Star detection
		if(SHIP_RADIUS + STAR_RADIUS > calculateDistance(ship.getLayoutX() + 49, star.getLayoutX() + 15, ship.getLayoutY() + 37, star.getLayoutY() + 15)) {
			setPosition(star);
			points++;
			String textToSet = "POINTS : ";
			if(points < 10 ) {
				textToSet = textToSet + "0";
			}
			pointsLabel.setText(textToSet + points);
		}
		//Meteor detection
		for(int i = 0; i < meteors.length; i++) {
			if(METEOR_RADIUS + SHIP_RADIUS > calculateDistance(ship.getLayoutX() + 49, meteors[i].getLayoutX() + 20, ship.getLayoutY() + 37, meteors[i].getLayoutY() + 20)) {
				playerLife();
			}
		}
	}
	
	/* Set playerLife to 1, and once the ship hits a meteor,
	 * decrease playerLife, and if playerLife is less than 1, stop the game, 
	 * and display main menu
	 */
	private void playerLife() {
		playerLife = 1;
		playerLife--;
		if(playerLife < 1) {
			gameStage.close();
			gameTimer.stop();
			menuStage.show();
		}
	}
	private double calculateDistance(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2,2));
	}

	
	
}
