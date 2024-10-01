package Darts;

public class Player {
	public final String NAME;
	public int currentPoints;

	public Player(String name, int points) {
		NAME = name;
		currentPoints = points;
	}

	public String getName() {
		return NAME;
	}

	public int getCurrentPoints() {
		return currentPoints;
	}

	public int substractPoints(int score) {
		currentPoints -= score;
		return currentPoints;
		
	}

	public void resetPointsToPreviousValue(int previousPoints) {
		currentPoints = previousPoints;
		
	}

	
}
