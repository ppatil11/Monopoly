package modal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SaleOfProducts {
	
	ArrayList<Attributes> Sale_Data = null;
	
	public SaleOfProducts(){
		
		try{
			   File salefile = new File("SaleFile.txt");
			   FileReader filereader = new FileReader(salefile);
			   BufferedReader buffer = new BufferedReader(filereader);
			   
			   String line = null;
     			  int index = -1;
	    		  Sale_Data = new ArrayList<Attributes>();
	    	   System.out.println("----Data on Sales File-------------------------------------");
			   while ((line = buffer.readLine()) != null) 
			   {
				   ++index;
				String sku = line.split("\\|")[0];
				System.out.print(sku+" ");
				String discount = line.split("\\|")[1];
				System.out.print(discount+" ");
				if (discount.equals("DISCOUNT")){
					String percent = line.split("\\|")[2];
					int per = Integer.parseInt(percent);
					System.out.print(per+"\n");
					Sale_Data.add(index , new SaleAttributes(sku , discount, per));
				}
				else if (discount.equals("BUYXGET1FREE")) {
					String valueX = line.split("\\|")[2];
					System.out.print(valueX+"\n");
					Sale_Data.add(index, new SaleAttributes(sku , discount, valueX));
				}
				else if (discount.equals("BUYXFORY")) {
					String buyX = line.split("\\|")[2];
					String payY = line.split("\\|")[3];
					System.out.println("Buy "+buyX+" for price of "+payY);
					Sale_Data.add(index, new SaleAttributes(sku , discount, buyX, payY));
				}			
				}
				buffer.close();
			}catch (IOException e)
			{
			  	e.printStackTrace();
			}
		System.out.println("-----------------------------------------------------------");		  		
	}
}
	
	

