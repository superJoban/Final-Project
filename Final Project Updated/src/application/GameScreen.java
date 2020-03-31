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

	// Setting up instance variables
    private int W = 500; 
	private int H = 500;
	
	private Image image;
    private Node  spaceCraft;
    private boolean accelerate, up, down, right, left;
    
    // Getters and setters for width and height
    public int getW() {return W;}

	public void setW(int w) {W = w;}

	public int getH() {return H;}

	public void setH(int h) {H = h;}
	
	// Method for the actual gameplay
	public void newGame(Stage menuStage) {
		// Start the game. Empty screen
		runGame(menuStage);
		
	}
	public void runGame(Stage stage) {
		// Image of the spaceship
		image = new Image("resource/spaceshitpng.png", 50,50,false,true);
        spaceCraft = new ImageView(image);

        Group solarSystem = new Group(spaceCraft);
        
        // Spaceship placed at the middle of the screen
        moveTo(getW() / 2, getH() / 2);
        
        // Scene(items in the stage): background color, size of the window
        Scene scene = new Scene(solarSystem, getW(), getH(), Color.AZURE);
        
        // Functions of scene. This checks whether the user has the keys W,A,S,D,SHIFT pressed
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
        
        // This checks whether the user let go of WASD, SHIFT
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
		
        // Sets up scene in the stage
        stage.setScene(scene);
        stage.show();

        //This is for making the object move around the scene(imported above)
        AnimationTimer timer = new AnimationTimer() {
        	
            @Override
            public void handle(long now) {
            	// Initially spaceship is not moving hence changeInX = changeInY = 0
                int changeInX = 0; 
                int changeInY = 0;
                // When key 'W' is pressed, up=true and spaceship moves up by 1 unit. 
                if (up) {
                	changeInY -= 1;
                }
                // When key 'S' is pressed, down=true and spaceship moves down by 1 unit.
                if (down) {
                	changeInY += 1;
                }
                // When key 'D' is pressed, right=true and spaceship moves right by 1 unit.
                if (right) {
                	changeInX += 1;
                }
                // When key 'A' is pressed, left=true and spaceship moves left by 1 unit.
                if (left) {
                	changeInX -= 1;
                }
                // When shift is pressed, accelerate=true and spaceship moves any direction directed by user at times 3 speed.
                //if (accelerate) {
                //	changeInX *= 3; changeInY *= 3;
                //}
                
                // Runs the moveFrom method
                moveFrom(changeInX, changeInY);
            }
        };
        timer.start();
    }
	//Spaceship moves from its initial position to newer 
	public void moveFrom(int changeInX, int changeInY) {
		// Return nothing when changeInX=changeInY=0
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
		 double xCoord = x;
		 double yCoord = y;
		 if (x - centreX >= 0 && x + centreX <= W && y - centreY >= 0 && y + centreY <= H) {
			 spaceCraft.relocate(x - centreX, y - centreY);	 
			 }
		objectLocation(xCoord, yCoord);
		 
	 	}

	 public void objectLocation(double xCoord, double yCoord) {
		 System.out.println("X: "+xCoord +" Y: "+yCoord);
	 }
}

























