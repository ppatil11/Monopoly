package monopoly;

public class CommunityChestSpace extends Space {

	private int selectCard() {
		String key = GameConfig.COMMUNITY_CARDS.get(getRandomIndex(GameConfig.COMMUNITY_CARDS.size()));
		int reward = UpdatePositions.performActionForChest(gameBoard, key);
		
		System.out.println("Player " + gameBoard.player.getPlayerName() + " selected card: "
					+ GameConfig.communityChestCards.get(key));		
		return reward;
	}
	
	public CommunityChestSpace(String name, GameBoard game) {
		this.name = name;
		this.gameBoard = game;
	}
	
	private static int getRandomIndex(int size) {
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
