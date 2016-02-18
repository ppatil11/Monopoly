package controller;

import java.awt.EventQueue;

import view.PointOfSaleRegister;

public class PointOfSale {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try 
					{
						PointOfSaleRegister frame = new PointOfSaleRegister();
						frame.setVisible(true);
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}

		});
	}
}
