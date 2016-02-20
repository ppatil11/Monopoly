package monopoly;

public class JailSpace extends Space {

	public JailSpace(String name, GameBoard gameBoard) {
		this.name = name;
		this.gameBoard = gameBoard;
	}
	
	@Override
	public int getReward() {
		return 0;
	}

	@Override
	public String getName() {
		return name;
	}

	
}
