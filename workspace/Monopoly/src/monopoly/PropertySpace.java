package monopoly;

import java.util.HashMap;

public class PropertySpace extends Space {

	public PropertySpace(String name, GameBoard game) {
		this.name = name;
		this.gameBoard = game;
	}
	
	@Override
	public int getReward() {
		if (GameConfig.getGameConfig().propertyAwards.containsKey(name))
			return GameConfig.getGameConfig().propertyAwards.get(name);
		return 0;
	}

	@Override
	public String getName() {
		return name;
	}
	
}
