package monopoly;

public abstract class Space {

	GameBoard gameBoard;
	String name;
	
	public abstract int getReward();
	public abstract String getName();
	public void printCurrentCellDetails() {
		System.out.println("\nNow, player is at  [" + name + "] and current score is [" + this.gameBoard.getScore() + "]" );
	}
}
