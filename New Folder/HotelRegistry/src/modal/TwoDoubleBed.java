package modal;

public class TwoDoubleBed extends Room {

	private TwoDoubleBed(Information info) {
		this.info = info;
		this.roomNumber = info.roomNumber;
		this.numberOfDays = info.numberOfDays;
		this.chargePerDay = 300;
	}

	public static TwoDoubleBed getTwoDoubleBedRoom(Information info) {
		return new TwoDoubleBed(info);
	}
}
