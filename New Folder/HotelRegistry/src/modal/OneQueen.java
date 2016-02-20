package modal;

public class OneQueen extends Room {
	
	private OneQueen(Information info) {
		this.info = info;
		this.roomNumber = info.roomNumber;
		this.numberOfDays = info.numberOfDays;
		this.chargePerDay = 200;
	}
	
	public static OneQueen getOneQueenRoom(Information info) {
		return new OneQueen(info);
	}
}
