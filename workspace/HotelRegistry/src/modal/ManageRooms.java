package modal;

public class ManageRooms {

	public static final String KING = "king";
	public static final String QUEEN = "queen";
	public static final String DOUBLE_BED = "doubleBed";
	public static final String DOUBLE_BED_COT = "doubleBedCot";
	
	private static Room _allocateRoom(Information info) {  
		if (info.roomType == KING)
			return King.getKingRoom(info);
		if (info.roomType == QUEEN)
			return OneQueen.getOneQueenRoom(info);
		if (info.roomType == DOUBLE_BED )
			return TwoDoubleBed.getTwoDoubleBedRoom(info);
		if (info.roomType == DOUBLE_BED_COT)
			return TwoDoubleBedAndCot.getTwoDoubleBedAndCot(info);
		return null;
	}
	
	public static Room allocateRoom(Information info) {
		
		info.printinfo();
		Room room = _allocateRoom(info);
		
		if (RoomAvailability.isRoomAvailable(info)) {
			info.room = room;
			RoomAvailability.allocateRoom(info);
			return room;
		} else {
			return null;
		}
	}
	
	public static boolean releaseRoom(int roomNo, Information info) {
		return RoomAvailability.releaseRoom(roomNo, info);
	}
	
//	public static int getRoomInvoice(int roomNo, String roomType) {
//		
//	}
	
	
}
