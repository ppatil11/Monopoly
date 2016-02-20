package monopoly;

public class ChanceSpace extends Space {

	
	public ChanceSpace(String string, GameBoard gameBoard) {
		this.name = string;
		this.gameBoard = gameBoard;
	}

	private int selectCard() {
		String key = GameConfig.CHANCE_CARDS.get(getRandomIndex(GameConfig.CHANCE_CARDS.size()));
		int reward = UpdatePositions.performActionForChance(gameBoard, key);
		
		System.out.println("Player " + gameBoard.player.getPlayerName() + " selected card: "
				+ GameConfig.chanceCards.get(key));
		return reward;
	}
	
	private int getRandomIndex(int size) {
		int n = (int) (Math.random() * 100);
		n = n % size;
		return n;
	}

	@Override
	public int getReward() {
		printCurrentCellDetails();
		return selectCard();
	}

	@Override
	public String getName() {
		return name;
	}

}
