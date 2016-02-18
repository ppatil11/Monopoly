package modal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CostOfProducts {
    
//	public static HashMap<String, String>costData = null;
	public ArrayList<Attributes>Cost_Data = null;
	
	public CostOfProducts(){
		
	try{
	   File costfile = new File("CostFile.txt");
	   FileReader filereader = new FileReader(costfile);
	   BufferedReader buffer = new BufferedReader(filereader);
	   
	   String line = null;
	  int index = -1;
	  Cost_Data = new ArrayList<Attributes>();
	  System.out.println("----Data on Cost File--------------------------------------");
	   while ((line = buffer.readLine()) != null) 
	   {
		   ++index;
		String sku = line.split("\\|")[0];
		System.out.print(sku+" ");
		String desc = line.split("\\|")[1];
		System.out.print(desc+" ");
		String ucost = line.split("\\|")[2];
		System.out.println(ucost+" ");
		
		
		Cost_Data.add(index , new CostAttributes(sku, desc, ucost));
		
		}
		buffer.close();
	}catch (IOException e)
	{
	  	e.printStackTrace();
	}
	System.out.println("-----------------------------------------------------------");		  
	}
}
