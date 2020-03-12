package application;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameScreen{

	
    private int W = 500; 
	private int H = 500;
	
	private Image image;
    private Node  spaceCraft;
    private boolean accelerate, up, down, right, left;
    
    public int getW() {return W;}

	public void setW(int w) {W = w;}

	public int getH() {return H;}

	public void setH(int h) {H = h;}
	
	//Method for the actual gameplay

	public void newGame(Stage menuStage) {
		//start the game. Empty screen
		runGame(menuStage);
		
	}
	public void runGame(Stage stage) {
		image = new Image("resource/spaceshitpng.png", 50,50,false,true);
        spaceCraft = new ImageView(image);

        Group solarSystem = new Group(spaceCraft);
               
        moveTo(getW() / 2, getH() / 2);

        Scene scene = new Scene(solarSystem, getW(), getH(), Color.AZURE);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case W:    
                    	up = true; 
                    break;
                    case S:  
                    	down = true; 
                   	break;
                    case A:  
                    	left  = true; 
                   	break;
                    case D: 
                    	right  = true; 
                   	break;
                    case SHIFT: 
                    	accelerate = true; 
                   	break;
                }
            }
        });
        
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case W:    
                    	up = false; 
                    break;
                    case S:  
                    	down = false; 
                    break;
                    case A:  
                    	left  = false; 
                    break;
                    case D: 
                    	right  = false; 
                    break;
                    case SHIFT: 
                    	accelerate = false; 
                    break;
                }
            }
        });
		
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
        	
            @Override
            public void handle(long now) {
                int changeInX = 0; 
                int changeInY = 0;

                if (up) {
                	changeInY -= 1;
                }
                if (down) {
                	changeInY += 1;
                }
                if (right) {
                	changeInX += 1;
                }
                if (left) {
                	changeInX -= 1;
                }
                if (accelerate) {
                	changeInX *= 3; changeInY *= 3;
                }

                moveFrom(changeInX, changeInY);
            }
        };
        timer.start();
    }
	 public void moveFrom(int changeInX, int changeInY) {
	        if (changeInX == 0 && changeInY == 0) return;

	        double centreX = spaceCraft.getBoundsInLocal().getWidth() / 2;
	        double centreY = spaceCraft.getBoundsInLocal().getHeight() / 2;

	        double x = centreX + spaceCraft.getLayoutX() + changeInX;
	        double y = centreY + spaceCraft.getLayoutY() + changeInY;

	        moveTo(x, y);
	    }
	 public void moveTo(double x, double y) {
	    	double centreX = spaceCraft.getBoundsInLocal().getWidth() / 2;
	        double centreY = spaceCraft.getBoundsInLocal().getHeight() / 2;

	        if (x - centreX >= 0 && x + centreX <= W && y - centreY >= 0 && y + centreY <= H) {
	        	spaceCraft.relocate(x - centreX, y - centreY);
	        }
}
}