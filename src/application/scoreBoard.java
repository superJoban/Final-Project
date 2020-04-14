package application;

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**This class is used to create the scoreboard on the top right of the screen.
 * Everytime a point is obtained, the scoreboard will be updated and will display total points
 *
 */
public class scoreBoard extends Label{
	
	public scoreBoard(String text) {
		setPrefWidth(130);
		setPrefHeight(50);
		BackgroundImage backgroungImage = new BackgroundImage(new Image("/resource/infoLabel.jpg", 130,50, false,true),BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		setBackground(new Background(backgroungImage));
		setAlignment(Pos.CENTER_LEFT);
		setPadding(new Insets(10,10,10,10));
		Font font = Font.font("Algerian", FontWeight.EXTRA_BOLD, 21);
		setFont(font);
		setText(text);
		
		
	}
	
}
