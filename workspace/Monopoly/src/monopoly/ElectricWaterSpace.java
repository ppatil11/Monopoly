package monopoly;

public class ElectricWaterSpace extends Space {

	public ElectricWaterSpace(String name, GameBoard gameBoard) {
		this.name = name;
		this.gameBoard = gameBoard;
	}
	
	@Override
	public int getReward() {
		int diceProduct = gameBoard.CURRENT_DICE_ROLL.getDiceProduct();
		if ( GameConfig.getGameConfig().electricityWaterAwards.containsKey(name))
			return diceProduct * GameConfig.getGameConfig().electricityWaterAwards.get(name);
		return 0;
	}

	@Override
	public String getName() {
		return name;
	}

}
