package monopoly;

public class RailRoadsSpace extends Space {

	public static int COUNTER = 1;
	
	public RailRoadsSpace(String name, GameBoard gameBoard) {
		this.name = name;
		this.gameBoard = gameBoard;
	}
	
	@Override
	public int getReward() {
		int reward = 200 * COUNTER;
		// increment COUNTER for every railRoad
		COUNTER++;
		return reward;
	}

	@Override
	public String getName() {
		return name;
	}

	
}
