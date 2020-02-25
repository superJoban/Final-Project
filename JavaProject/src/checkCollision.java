
public class checkCollision {
	
	public static boolean collisionW(String[][] gameOutline) {
		// Finding current location of A
		boolean hitwall = false;
		for (int i = 0; i < gameOutline.length; i++) {
			for (int j = 0; j < (gameOutline[i].length); j++) {
				if (gameOutline[i][j].equals("A")) {
					// found the location of A, in row i and column j
					
					// check if 'A' is going to collide with the floor/ ceiling tile
					if (gameOutline[i-1][j] == "_") {
						hitwall = true;
					}
				}
			}
		}
		return hitwall;
	}
	
	public static boolean collisionD(String[][] gameOutline) {
		// Finding current location of A
		boolean hitwall = false;
		for (int i = 0; i < gameOutline.length; i++) {
			for (int j = 0; j < (gameOutline[i].length); j++) {
				if (gameOutline[i][j].equals("A")) {
					// found the location of A, in row i and column j
					
					if (gameOutline[i][j+3].contentEquals("|") || gameOutline[i][j+2].contentEquals("|") || gameOutline[i][j+1].contentEquals("|")) {
						hitwall = true;
					}
				}
			}
		}
		return hitwall;
	}
	
	public static boolean collisionS(String[][] gameOutline) {
		// Finding current location of A
		boolean hitwall = false;
		for (int i = 0; i < gameOutline.length; i++) {
			for (int j = 0; j < (gameOutline[i].length); j++) {
				if (gameOutline[i][j].equals("A")) {
					// found the location of A, in row i and column j
					
					if (gameOutline[i+1][j].contentEquals("_")) {
						hitwall = true;
					}
				}
			}
		}
		return hitwall;
	}
	
	public static boolean collisionA(String[][] gameOutline) {
		// Finding current location of A
		boolean hitwall = false;
		for (int i = 0; i < gameOutline.length; i++) {
			for (int j = 0; j < (gameOutline[i].length); j++) {
				if (gameOutline[i][j].equals("A")) {
					// found the location of A, in row i and column j
					
					if (gameOutline[i][j-3].contentEquals("|") || gameOutline[i][j-2].contentEquals("|") || gameOutline[i][j-1].contentEquals("|")) {
						hitwall = true;
					}
				}
			}
		}
		return hitwall;
	}
}
