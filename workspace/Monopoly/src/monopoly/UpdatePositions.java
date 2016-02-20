package monopoly;

public class UpdatePositions {

	public static void updatePositionFromToAndScores(GameBoard gameBoard, int from, int target) {
		
		//System.out.println(gameBoard.MAX_SPACES + " " + gameBoard.CURRENT_DICE_ROLL.getFirstRollValue() + " " + gameBoard.CURRENT_DICE_ROLL.getSecondRollValue()
		//+ " " + gameBoard.CURRENT_DICE_ROLL.getDiceSum() + " " + target);

		
		gameBoard.CURRENT_SPACE = gameBoard.GAME_BOARD.get(target);
		gameBoard.CURRENT_SPACE_INDEX = target;			
		gameBoard.player.setCurrentSPace(gameBoard.CURRENT_SPACE);
		
		gameBoard.setScore( gameBoard.getScore() + gameBoard.CURRENT_SPACE.getReward());
	}
	
	public static void updatePositionToJail(GameBoard gameBoard) {
		//System.out.println(gameBoard.JAIL_SPACE + " " + gameBoard.GAME_BOARD.size());
		
		gameBoard.CURRENT_SPACE = gameBoard.GAME_BOARD.get(gameBoard.JAIL_SPACE);
		gameBoard.CURRENT_SPACE_INDEX = gameBoard.JAIL_SPACE;
		gameBoard.player.setCurrentSPace(gameBoard.CURRENT_SPACE);
	}
	
	public static int updateThreePositionsBack(GameBoard gameBoard) {
		gameBoard.CURRENT_SPACE_INDEX = ((gameBoard.CURRENT_SPACE_INDEX - 3 ) >= 0 ) ? (gameBoard.CURRENT_SPACE_INDEX-3) : (gameBoard.MAX_SPACES + gameBoard.CURRENT_SPACE_INDEX - 3);
		gameBoard.CURRENT_SPACE = gameBoard.GAME_BOARD.get(GameBoard.CURRENT_SPACE_INDEX);
		gameBoard.player.setCurrentSPace(gameBoard.CURRENT_SPACE);
		
		gameBoard.CURRENT_SPACE.printCurrentCellDetails();
		
		return gameBoard.CURRENT_SPACE.getReward();
	}
	
	public static int performActionForChance(GameBoard gameBoard, String action) {
		if (action.equals("PayMoney"))
			return 50;
		else if (action.equals("Credits"))
			return 10;
		else if (action.equals("Chairman"))
			return 100;
		else if (action.equals("GoBack")) {
			return updateThreePositionsBack(gameBoard);
		} else if (action.equals("GoToJail"))
			updatePositionToJail(gameBoard);
		return 0;
	}

	public static int performActionForChest(GameBoard gameBoard, String action) {
		if (action.equals("BankError"))
			return 200;
		else if (action.equals("SaleStock"))
			return 50;
		else if (action.equals("HolidayFund"))
			return 100;
		else if (action.equals("TaxReturn"))
			return 20;
		else if (action.equals("GoToJail"))
			updatePositionToJail(gameBoard);
		return 0;
	}

	public static int getRoundedPosition(int MAX, int a, int b) {
		return (a+b)%MAX;
	}
}
