package monopoly;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DiceRoll {

	private boolean commandLine;
	private boolean junitTest;
	
	private int firstRoll;
	private int secondRoll;
	
	public DiceRoll(boolean INPUT_BY_USER, boolean jUnitTest) {
		firstRoll = 0;
		secondRoll = 0;
		commandLine = INPUT_BY_USER;
		junitTest = jUnitTest;
	}
	
	public void rollDices() {
		rollFirstDice();
		rollSecondDice();
		
		if (commandLine)
			System.out.println("User rolled dice as " + firstRoll + " and " + secondRoll + "  [sum:" + getDiceSum() + "]");
		else
			System.out.println("Machine rolled dice as " + firstRoll + " and " + secondRoll + "  [sum:" + getDiceSum() + "]");
	}
	
	private int rollFirstDice() {
		
		if (firstRoll != 0)
			return firstRoll;
	
		if (commandLine) {
			boolean enter = true;
			try {
				while (enter) {
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			        System.out.print("\nroll first dice:");
			        String s = br.readLine();
			        try{
			            int i = Integer.parseInt(s);
			            if (i > 0 && i < 7) {
			            	enter = false;
			            	firstRoll = i;
			            }
			        }catch(NumberFormatException nfe){
			            System.err.println("Invalid number! Enter (number between 1 - 6)");
			        }
				}
			} catch (Exception e) {
				System.out.println("Not able to input from user!");
			}
			
		} else if (junitTest) {
			firstRoll = JUnitInputOutput.getFirstRoll();
		} else {
			int n = (int) (Math.random() * 100);
			n = (n % 6) + 1;
			firstRoll = n;
		}
		return firstRoll;
	}
	
	private int rollSecondDice() {
		
		if (secondRoll != 0)
			return secondRoll;
		
		if (commandLine) {
			boolean enter = true;
			try {
				while (enter) {
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			        System.out.print("roll second dice");
			        String s = br.readLine();
			        try{
			            int i = Integer.parseInt(s);
			            if (i > 0 && i < 7) {
			            	enter = false;
			            	secondRoll = i;
			            }
			        }catch(NumberFormatException nfe){
			            System.err.println("Invalid number! Enter (number between 1 - 6)");
			        }
				}
			} catch (Exception e) {
				System.out.println("Not able to input from user!");
			}
		} else if (junitTest) {
			secondRoll = JUnitInputOutput.getSecondRoll();
		} else {
			int n = (int) (Math.random() * 100);
			n = (n % 6) + 1;
			secondRoll = n;
		}
		return secondRoll;
	}
	
	public int getFirstRollValue() {
		return firstRoll;
	}
	
	public int getSecondRollValue() {
		return secondRoll;
	}
	
	public int getDiceSum() {
		return (firstRoll+secondRoll) % GameBoard.MAX_SPACES;
	}
	
	public int getDiceProduct() {
		return firstRoll*secondRoll;
	}
}
