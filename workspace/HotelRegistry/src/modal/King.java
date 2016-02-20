package modal;

public class King extends Room {

	private King(Information info) {
		this.info = info;
		this.roomNumber = info.roomNumber;
		this.numberOfDays = info.numberOfDays;
		this.chargePerDay = 100;
	}
	
	public static King getKingRoom(Information info) {		
		return new King(info);
	}
}
