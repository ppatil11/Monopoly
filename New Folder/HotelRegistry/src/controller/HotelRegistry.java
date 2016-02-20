
package controller;

import java.awt.EventQueue;

import view.MainMenu;

/**
 * @author ppatil
 *  Main class
 */
public class HotelRegistry {
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					MainMenu mb = new MainMenu();
					mb.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}