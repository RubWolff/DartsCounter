package Darts;
public class DartsGame {
	private Player[] players;
	private int counter;
	private int previousPoints;

	public DartsGame(int points, int numberOfPlayers) {
		counter = 0;
		players = new Player [numberOfPlayers];
		previousPoints = points;
		for(int i=0; i < numberOfPlayers; i++){
			players[i] = new Player("Player" + (i+1), points);
		}
	}

	public String generateScoreboard() {
		StringBuilder sb = new StringBuilder();
		
		for(Player p : players) {
			sb.append(p.getName()+ ": ");
			sb.append(p.getCurrentPoints() +" points");
			sb.append("\n");
			
		}
		return sb.toString();
	}

	public int substratPointsForCurrentPlayer(int score) {
		Player player = players[counter % players.length];
		int points = player.substractPoints(score);
		if (points < 0) {
			player.resetPointsToPreviousValue(previousPoints);
			points = player.getCurrentPoints() * (-1);
			
		}
		
		return points;
		
	}
	public void nextPlayer() {
		counter++;
		previousPoints = players[counter % players.length].getCurrentPoints();
	}
	public String getCurrentPlayer() {
	 return players[counter % players.length].getName();
	}

}
