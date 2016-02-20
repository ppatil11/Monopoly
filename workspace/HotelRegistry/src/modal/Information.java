package modal;

public class Information {
	public String fname;
	public String lname;
	public String address;
	public String city;
	public String state;
	public String zipcode;
	public int    adults;
	public int    children;
	public String roomType;
	public int    roomNumber;
	public int    numberOfDays = 1;
	public Room   room;
	public int invoiceAmount;
	
	public void printinfo()
	{
		System.out.println("fname : "+ this.fname +"lname "+ this.lname + " address" +this.address + "room no" + this.roomNumber);
	}
	
}
