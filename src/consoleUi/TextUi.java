package consoleUi;

import java.util.Scanner;

import Darts.Board;
import Darts.DartsGame;

public class TextUi {
	private DartsGame game;
	private Scanner kb = new Scanner(System.in);

	public TextUi(DartsGame game) {
		super();
		this.game = game;

		
	}

	public void playGame() {
		System.out.println("Hello Darts");
		System.out.println();
		
		gameLoop:
		do {
			System.out.println(game.generateScoreboard());
			System.out.println("Next Player: " + game.getCurrentPlayer());
			for (int d = 1; d <= 3; d++) {
				System.out.print("> ");

				String input = kb.nextLine().toLowerCase().trim();

				if (input.equals("exit"))
					break gameLoop;

				int score = Board.parseInput(input);
				score = game.substratPointsForCurrentPlayer(score);
				System.out.println("\t->" + Math.abs(score));
				
				if(score == 0) {
					System.out.println("Player wins!");
					break gameLoop;
				}else if(score < 0) {
					System.out.println("�berworfen!");
					break;
				}
				
			}
			game.nextPlayer();

		} while (true);

		kb.close();
		System.out.println("Das Spiel wurde beendet");
	}

}
