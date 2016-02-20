package monopoly;

public class JUnitInputOutput {

	private static int index = 0;
	
	private static int  []firstRoll = {2,1,2,1};
	private static int []secondRoll = {2,1,3,1};
	private static int []expectedScore = {200, 300, 440, 580};
	
	public static int getFirstRoll() {
		if (index >= firstRoll.length)
			index = 0;
		return firstRoll[index];
	}
	
	public static int getSecondRoll() {
		if (index >= firstRoll.length)
			index = 0;		
		return secondRoll[index];
	}
	
	public static int getExpectedScore() {
		return expectedScore[index++];
	}
	
}
