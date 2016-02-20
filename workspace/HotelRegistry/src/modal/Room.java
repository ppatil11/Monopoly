package modal;

public abstract class Room {

	String roomType;
	int roomNumber;

	Information info;
	
	int chargePerDay = -1;
	int numberOfDays = -1;
	
	public int getInvoice() {
		return chargePerDay * numberOfDays;
	}
	
	public String getRoomType() {
		return roomType;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public int getNumberOfAdults() {
		return info.adults;
	}
	
	public int getNumberOfChildren() {
		return info.children;
	}
	
	public int getChargesPerDay() {
		return chargePerDay;
	}
	
	public int getNumberOfDays() {
		return numberOfDays;
	}
	
	public int getTotalGuests() {
		return info.adults + info.children;
	}
}
