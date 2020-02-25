
public class runGame {
	public static void printGameOutline(String[][] gameOutline) {
		for (String[] row : gameOutline) {
			for (String c : row) {
				System.out.print(c);
			}
			System.out.println();
		}	
	}
}
