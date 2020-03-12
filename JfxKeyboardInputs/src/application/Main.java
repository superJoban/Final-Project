package application;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	
	//setting up instance variables
    private int W = 500; 
	private int H = 500;
    private Image image;
    private Node  spaceCraft;
    private boolean accelerate, up, down, right, left;
 
    
    //getters and setters for Width and Height
    public int getW() {return W;}

	public void setW(int w) {W = w;}

	public int getH() {return H;}

	public void setH(int h) {H = h;}
	
	//window method
    @Override
    public void start(Stage stage) throws Exception {
    	//image of the spaceship
    	image = new Image("resource/spaceship.png", 45,45,false,true);
        spaceCraft = new ImageView(image);
        Group solarSystem = new Group(spaceCraft);
        
        //spaceship placed middle of the screen
        moveTo(getW() / 2, getH() / 2);

        //scene(items in the stage): background color, size of the window
        Scene scene = new Scene(solarSystem, getW(), getH(), Color.AZURE);
        
        //functions of scene. This checks whether the user has the keys W,A,S,D,SHIFT pressed 
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
        
        //This checks whether the user let go of WASD, SHIFT
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
		
        //sets up scene in the stage
        stage.setScene(scene);
        stage.show();
        
        //This is for making the object move around the scene(imported above)
        AnimationTimer timer = new AnimationTimer() {	
            @Override
            public void handle(long now) {
            	//Initially spaceship is not moving so obviously changeInX=changeInY=0
                int changeInX = 0; 
                int changeInY = 0;
                //
                //when W is pressed, up=true and spaceship moves up by 1 unit. 
                if (up) {
                	//y=0 on the top so when spaceship goes up, y decreases
                	changeInY -= 1;
                }
              //when S is pressed, down=true and spaceship moves down by 1 unit. 
                if (down) {
                	changeInY += 1;
                }
              //when D is pressed, right=true and spaceship moves right by 1 unit. 
                if (right) {
                	changeInX += 1;
                }
              //when A is pressed, left=true and spaceship moves left by 1 unit. 
                if (left) {
                	changeInX -= 1;
                }
              //when shift is pressed, accelerate=true and spaceship moves any direction directed by user at times 3 speed. 
                if (accelerate) {
                	changeInX *= 3; changeInY *= 3;
                }
                
                //Spaceship moves from its current position with the instruction(up,down,left,right) above^
                moveFrom(changeInX, changeInY);
            }
        };
        timer.start();
    }
    //Spaceship moves from its initial position to newer 
    public void moveFrom(int changeInX, int changeInY) {
        if (changeInX == 0 && changeInY == 0) return;

        double centreX = spaceCraft.getBoundsInLocal().getWidth() / 2;
        double centreY = spaceCraft.getBoundsInLocal().getHeight() / 2;

        double x = centreX + spaceCraft.getLayoutX() + changeInX;
        double y = centreY + spaceCraft.getLayoutY() + changeInY;
        
        //Calling moveTo method to move spaceship to new position
        moveTo(x, y);
    }
    //Method for moving spaceship to its new position
    public void moveTo(double x, double y) {
    	double centreX = spaceCraft.getBoundsInLocal().getWidth() / 2;
        double centreY = spaceCraft.getBoundsInLocal().getHeight() / 2;

        if (x - centreX >= 0 && x + centreX <= W && y - centreY >= 0 && y + centreY <= H) {
        	spaceCraft.relocate(x - centreX, y - centreY);
        }
    }
    //Launches the stage
    public static void main(String[] args) { 
    	launch(args); 
    }
    
    //getter and setter for spaceship
	public Node getSpaceCraft() {
		return spaceCraft;
	}
	public void setSpaceCraft(Node spaceCraft) {
		this.spaceCraft = spaceCraft;
	}

}