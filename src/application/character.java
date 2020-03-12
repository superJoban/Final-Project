package application;
	
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.FillTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.Scene;

public abstract class character extends Application{
	int height = 10;
	int width = 10;
	
	int intialy = 0;
	int intialx = 0;
	
	static final int cellSize = 300;
	private static GridPane grid = new GridPane();
	
	public static void addCharacter(int x, int y) {
		
		Circle circle = new Circle(500, Color.BLACK);
		grid.add(circle, x, y);
		
		
	}
	
}
