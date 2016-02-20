package monopoly;

import java.util.ArrayList;

// added for junit test cases
//import static org.junit.Assert.assertEquals;
//import org.junit.Test;

public class GameBoard {

	
	private int SCORE = 0;
	
	public static DiceRoll CURRENT_DICE_ROLL = null;
	public static Space CURRENT_SPACE = null;
	public static int CURRENT_SPACE_INDEX = -1;
	public static Player player = null;
	
	public static GameConfig gameConfig = null;
	public static boolean INPUT_BY_USER = false;
	public static boolean JUNIT_TEST = false;
	
	public static int JAIL_SPACE = -1;
	public static int GO_SPACE = -1;
	public static int MAX_SPACES = -1;
	
	ArrayList<Space> GAME_BOARD = null;
	
	public GameBoard(Player player, boolean userInput, boolean unitTest) {
		this.player = player;
		this.INPUT_BY_USER = userInput;
		this.JUNIT_TEST = unitTest;
		gameConfig = GameConfig.getGameConfig();
		initializeGame();
	}

	public GameBoard(Player player) {
		this.player = player;
		gameConfig = GameConfig.getGameConfig();
		initializeGame();
	}
	
	public int getScore() {
		return SCORE;
	}
	
	public void setScore(int i) {
		SCORE = i;
	}
	
	public void playGame() {
		
		GoSpace goSpace = (GoSpace) GAME_BOARD.get(GO_SPACE);
		
		while ( !goSpace.isVisited() ) {
			
			CURRENT_DICE_ROLL = new DiceRoll(INPUT_BY_USER, JUNIT_TEST);
			CURRENT_DICE_ROLL.rollDices();
			
			int targetPosition = CURRENT_DICE_ROLL.getDiceSum();
			targetPosition = UpdatePositions.getRoundedPosition(MAX_SPACES, targetPosition, CURRENT_SPACE_INDEX);

			UpdatePositions.updatePositionFromToAndScores(this, CURRENT_SPACE_INDEX, targetPosition);
			
			//SCORE += CURRENT_SPACE.getReward();			
			CURRENT_SPACE.printCurrentCellDetails();
			
//			if (JUNIT_TEST) {
//				int expectedScore = JUnitInputOutput.getExpectedScore();
//				assertEquals("current score should be " + SCORE, expectedScore, SCORE);
//			}
		}
		
		System.out.println("\n-----------------------------------------");
		System.out.println("Player " + player.getPlayerName() + " completed the game!");
		System.out.println("Total score: " + SCORE);
		System.out.println("-----------------------------------------");
		
	}
	
	private void initializeGame() {
		int index = 0;	
		GAME_BOARD = new ArrayList<Space>();
		GAME_BOARD.add(index++, new GoSpace("GO", this));
		GO_SPACE = index - 1;
		GAME_BOARD.add(index++, new PropertySpace("Mediterranean Avenue", this));
		GAME_BOARD.add(index++, new CommunityChestSpace("Community Chest", this));
		GAME_BOARD.add(index++, new PropertySpace("Baltic Avenue", this));
		GAME_BOARD.add(index++, new TaxSpace("Income Tax", this));
		GAME_BOARD.add(index++, new RailRoadsSpace("Reading Railroad", this));
		GAME_BOARD.add(index++, new PropertySpace("Oriental Avenue", this));
		GAME_BOARD.add(index++, new ChanceSpace("Chance", this));
		GAME_BOARD.add(index++, new PropertySpace("Vermont Avenue", this));
		GAME_BOARD.add(index++, new PropertySpace("Connecticut Avenue", this));
		GAME_BOARD.add(index++, new JailSpace("Jail", this));
		JAIL_SPACE = index - 1;
		
		GAME_BOARD.add(index++, new PropertySpace("St. Charles Place", this));
		GAME_BOARD.add(index++, new ElectricWaterSpace("Electric Company", this));
		GAME_BOARD.add(index++, new PropertySpace("States Avenue", this));
		GAME_BOARD.add(index++, new PropertySpace("Virginia Avenue", this));
		GAME_BOARD.add(index++, new RailRoadsSpace("Pennsylvania Railroad", this));
		GAME_BOARD.add(index++, new PropertySpace("St. James Place", this));
		GAME_BOARD.add(index++, new CommunityChestSpace("Community Chest", this));
		GAME_BOARD.add(index++, new PropertySpace("Tennessee Avenue", this));
		GAME_BOARD.add(index++, new PropertySpace("New York Avenue", this));
		GAME_BOARD.add(index++, new FreeParking("Free Parking", this));
		
		GAME_BOARD.add(index++, new PropertySpace("Kentucky Avenue", this));
		GAME_BOARD.add(index++, new ChanceSpace("Chance", this));
		GAME_BOARD.add(index++, new PropertySpace("Indiana Avenue", this));
		GAME_BOARD.add(index++, new PropertySpace("Illinois Avenue", this));
		GAME_BOARD.add(index++, new RailRoadsSpace("B. & O. Railroad", this));
		GAME_BOARD.add(index++, new PropertySpace("Atlantic Avenue", this));
		GAME_BOARD.add(index++, new PropertySpace("Ventnor Avenue", this));
		GAME_BOARD.add(index++, new ElectricWaterSpace("Water Works", this));
		GAME_BOARD.add(index++, new PropertySpace("Marvin Gardens", this));
		GAME_BOARD.add(index++, new GoToJail("Go To Jail", this));
		
		GAME_BOARD.add(index++, new PropertySpace("Pacific Avenue", this));
		GAME_BOARD.add(index++, new PropertySpace("North Carolina Avenue", this));
		GAME_BOARD.add(index++, new CommunityChestSpace("Community Chest", this));
		GAME_BOARD.add(index++, new PropertySpace("Pennsylvania Avenue", this));
		GAME_BOARD.add(index++, new RailRoadsSpace("Short Line", this));
		GAME_BOARD.add(index++, new ChanceSpace("Chance", this));
		GAME_BOARD.add(index++, new PropertySpace("Park Place", this));
		GAME_BOARD.add(index++, new TaxSpace("Luxury Tax", this));
		GAME_BOARD.add(index++, new PropertySpace("Boardwalk", this));
		MAX_SPACES = index;
		
		CURRENT_SPACE = GAME_BOARD.get(GO_SPACE);  //getting the Space value at 0(GO_SPACE's index)
		CURRENT_SPACE_INDEX = GO_SPACE;            //getting space index of Go_SPACE(0)
	}
	
}
