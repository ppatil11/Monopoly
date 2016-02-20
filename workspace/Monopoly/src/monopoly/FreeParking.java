package monopoly;

public class FreeParking extends Space {

	public FreeParking(String name, GameBoard gameBoard) {
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
