package monopoly;

import java.util.ArrayList;
import java.util.HashMap;

public class GameConfig {

	public static HashMap<String, Integer> propertyAwards = null;
	public static HashMap<String, Integer> taxAwards = null;
	public static HashMap<String, Integer> electricityWaterAwards = null;
	
	public static HashMap<String, String> chanceCards = null;
	public static ArrayList<String> CHANCE_CARDS = null;
	
	public static HashMap<String, String> communityChestCards = null;
	public static ArrayList<String> COMMUNITY_CARDS = null;
	
	public static GameConfig config = null;
	
	public static GameConfig getGameConfig() {
		if (config == null)
			config = new GameConfig();
		return config;
	}
	
	private GameConfig () {
		initializeGameConfig();
	}
	
	
	
	public void initializeGameConfig() {
		
		propertyAwards = new HashMap<String, Integer>();
		propertyAwards.put("Mediterranean Avenue", 60);
		propertyAwards.put("Baltic Avenue", 60);
		propertyAwards.put("Oriental Avenue", 100);
		propertyAwards.put("Vermont Avenue", 100);
		propertyAwards.put("Connecticut Avenue", 120);
		propertyAwards.put("St. Charles Place", 140);
		propertyAwards.put("States Avenue", 140);
		propertyAwards.put("Virginia Avenue", 160);
		propertyAwards.put("St. James Place", 180);
		propertyAwards.put("Tennessee Avenue", 180);
		propertyAwards.put("New York Avenue", 200);
		propertyAwards.put("Kentucky Avenue", 220);
		propertyAwards.put("Indiana Avenue", 220);
		propertyAwards.put("Illinois Avenue", 240);
		propertyAwards.put("Atlantic Avenue", 260);
		propertyAwards.put("Ventnor Avenue", 260);	
		propertyAwards.put("Marvin Gardens", 280);
		propertyAwards.put("Pacific Avenue", 300);
		propertyAwards.put("North Carolina Avenue", 300);
		propertyAwards.put("Pennsylvania Avenue", 320);
		propertyAwards.put("Park Place", 350);
		propertyAwards.put("Boardwalk", 400);
		
		chanceCards = new HashMap<String, String>();
		chanceCards.put("GoToJail", "Go directly to jail");
		chanceCards.put("PayMoney", "Bank pays you dividend of 50 credits");
		chanceCards.put("GoBack", "Go back 3 spaces");
		chanceCards.put("Credits", "You have won a crossword competition. Collect 10 credits");
		chanceCards.put("Chairman", "You have been elected Chairman of the Board. Collect 100 credits.");
		CHANCE_CARDS = new ArrayList<String>();
		CHANCE_CARDS.addAll(chanceCards.keySet());
		
		communityChestCards = new HashMap<String, String>();
		communityChestCards.put("BankError", "Bank error in your favor. Collect 200 credits");
		communityChestCards.put("SaleStock", "From sale of stock, you get 50 credits.");
		communityChestCards.put("GoToJail", "Go directly to Jail");
		communityChestCards.put("HolidayFund", "Holiday Fund matures. Receive 100 credits.");
		communityChestCards.put("TaxReturn", "Income tax refund. Collect 20 credits");
		COMMUNITY_CARDS = new ArrayList<String>();
		COMMUNITY_CARDS.addAll(communityChestCards.keySet());
	
		taxAwards = new HashMap<String, Integer>();
		taxAwards.put("Income Tax", 200);
		taxAwards.put("Luxury Tax", 100);
		
		electricityWaterAwards = new HashMap<String, Integer>();
		electricityWaterAwards.put("Electric Company", 5);
		electricityWaterAwards.put("Water Works", 10);
		
	}

}
