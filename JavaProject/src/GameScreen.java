
public class GameScreen {

	public static void main(String[] args) {
		
		
		String[][] gameOutline = Screen.getGameOutline();
		runGame.printGameOutline(gameOutline);
		gameMap();
		printGameOutline(gameOutline);
		keyboardInputGameplay.keyboardInput(gameOutline);
	}

	private static void gameMap() {
		// TODO Auto-generated method stub
		
	}

}
