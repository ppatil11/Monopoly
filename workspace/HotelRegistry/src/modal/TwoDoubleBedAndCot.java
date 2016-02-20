package modal;

public class TwoDoubleBedAndCot extends Room {
	
	private TwoDoubleBedAndCot (Information info) {
		this.info = info;
		this.roomNumber = info.roomNumber;
		this.numberOfDays = info.numberOfDays;
		this.chargePerDay = 400;
	}
	
	public static TwoDoubleBedAndCot getTwoDoubleBedAndCot (Information info) {
		return new TwoDoubleBedAndCot(info);
	}
}
