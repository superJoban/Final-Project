import java.util.Scanner;

	public class keyboardInputGameplay {
		public static void keyboardInput(String[][] gameOutline) {
			// instance variable
			boolean isGameRunning = true;
			// Finding current location of A
			for (int i = 0; i < gameOutline.length; i++) {
				for (int j = 0; j < (gameOutline[i].length); j++) {
					if (gameOutline[i][j].equals("A")) {
						// found the location of A, in row i and column j
						int row = i;
						int column = j;
	
						// created a loop asking the user to move, and updating the game outline
						//boolean isGameRunning = true;
						while (isGameRunning) {
							@SuppressWarnings("resource")
							Scanner scan = new Scanner(System.in);
							System.out.println("Use Keys (W,S,A,D) to Move");
							String userMove = scan.nextLine();
	
							// using switch/case to see which letter is typed by the user
							switch (userMove) {
							case "w":
								if (checkCollision.collisionW(gameOutline) == false) {
									gameOutline[row - 1][column] = "A";
									if (gameOutline[row][column].equals("A")) {
										gameOutline[row][column] = " ";
										row = row - 1;
									}
								}
								if (checkCollision.collisionW(gameOutline) == true) {
									isGameRunning = false;
									System.out.println("Game over");
									System.exit(0);		
								}
								break;
	
							case "d":
								if (checkCollision.collisionD(gameOutline) == false) {
									gameOutline[row][column + 3] = "A";
									if (gameOutline[row][column].equals("A")) {
										gameOutline[row][column] = " ";
										column = column + 3;
									}
								}
								if (checkCollision.collisionD(gameOutline) == true) {
									isGameRunning = false;
									System.out.println("Game over");
									System.exit(0);
								}
								break;
								
							case "s":
								if (checkCollision.collisionS(gameOutline) == false) {
									gameOutline[row + 1][column] = "A";
									if (gameOutline[row][column].equals("A")) {
										gameOutline[row][column] = " ";
										row = row + 1;
									}
								}
								if (checkCollision.collisionS(gameOutline) == true) {
									isGameRunning = false;
									System.out.println("Game over");
									System.exit(0);
								}
								break;
								
							case "a":
								if (checkCollision.collisionA(gameOutline) == false) {
									gameOutline[row][column - 3] = "A";
									if (gameOutline[row][column].equals("A")) {
										gameOutline[row][column] = " ";
										column = column - 3;
									}
								}
								if (checkCollision.collisionA(gameOutline) == true) {
									isGameRunning = false;
									System.out.println("Game over");
									System.exit(0);
								}
								break;
	
							}
							runGame.printGameOutline(gameOutline);
						}
					}	
				}
			}
		}		
	}
		
		
		
		

		
