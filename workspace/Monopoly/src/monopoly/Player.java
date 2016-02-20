package monopoly;

public class Player {
	
	private String playerName;
	private Space curSpace;
	
	public Player(String name) {
		this.playerName = name;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setCurrentSPace(Space s) {
		curSpace = s;
	}
	
	public Space getCurrentSpace() {
		return curSpace;
	}
}
