package monopoly;

public class GoSpace extends Space {

	private boolean firstVisit;
	
	public GoSpace(String name, GameBoard gameBoard) {
		this.name = name;
		this.gameBoard = gameBoard;
		firstVisit = true;
	}
	
	public boolean isFirstVisit() {
		return firstVisit == true;
	}
	
	public void markVisited() {
		firstVisit = false;
	}
	
	public boolean isVisited() {
		return !isFirstVisit();
	}
	
	@Override
	public int getReward() {
		if (this.firstVisit) {
			firstVisit = false;
			return getCompletedReward();
		}
		return 0;
	}

	public int getCompletedReward() {
		return 200;
	}

	@Override
	public String getName() {
		return name;
	}
}
