package monopoly;

public class TestMonopoly {

	public static void main(String[] args) {
		
		boolean GET_INPUT_FROM_USER = false;
		boolean UNIT_TEST = false;
		
		if (args.length > 0 && args[0].equals("-junit")) {
			UNIT_TEST = true;
		}
		
		if (args.length > 0 && args[0].equals("-dice")) {
			GET_INPUT_FROM_USER = true;
		}
			
		Player player = new Player("Prashant");
		GameBoard gameBoard = new GameBoard(player, GET_INPUT_FROM_USER, UNIT_TEST);
		gameBoard.playGame();
	}

}
