package monopoly;

public class TaxSpace extends Space {

	public TaxSpace(String name, GameBoard gameBoard) {
		this.name = name;
		this.gameBoard = gameBoard;
	}
	
	@Override
	public int getReward() {
		if (GameConfig.getGameConfig().taxAwards.containsKey(name))
			return GameConfig.getGameConfig().taxAwards.get(name);
		return 0;
	}

	@Override
	public String getName() {
		return name;
	}

}
