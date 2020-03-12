
public class GameScreen {

	public static void main(String[] args) {

		try {
			String[][] gameOutline = Screen.getGameOutline();
			runGame.printGameOutline(gameOutline);
			keyboardInputGameplay.keyboardInput(gameOutline);
		} catch (Exception e) {
			System.out.println("Game Over");
		}
	}

}
