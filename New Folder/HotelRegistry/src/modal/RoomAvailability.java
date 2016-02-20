package modal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class RoomAvailability {

	private static HashMap<Integer, Information> kingRooms = new HashMap<Integer, Information>();
	private static HashMap<Integer, Information> queenRooms = new HashMap<Integer, Information>();
	private static HashMap<Integer, Information> twoDoubleRooms = new HashMap<Integer, Information>();
	private static HashMap<Integer, Information> twoDoubleCotRooms = new HashMap<Integer, Information>();
	
	private static HashSet<Integer> allocatedRooms = new HashSet<Integer>();
	private static HashMap<Integer,String> roomType = new HashMap<Integer,String>();
	
	private static boolean initiated = false;
	
	public static void Initialize() {
		
		if (initiated)
			return;
		
		initiated = true;
		
		kingRooms.put(100, null);
		kingRooms.put(102, null);
		kingRooms.put(105, null);
		kingRooms.put(114, null);
		queenRooms.put(104, null);
		queenRooms.put(106, null);
		queenRooms.put(108, null);
		twoDoubleRooms.put(101, null);
		twoDoubleRooms.put(107, null);
		twoDoubleRooms.put(110, null);
		twoDoubleRooms.put(111, null);
		twoDoubleRooms.put(112, null);
		twoDoubleRooms.put(113, null);	
		twoDoubleCotRooms.put(103, null);
		twoDoubleCotRooms.put(109, null);

		
		for (Integer i : kingRooms.keySet())
			roomType.put(i, ManageRooms.KING);
		for (Integer i : queenRooms.keySet())
			roomType.put(i, ManageRooms.QUEEN);
		for (Integer i : twoDoubleRooms.keySet())
			roomType.put(i, ManageRooms.DOUBLE_BED);
		for (Integer i : twoDoubleCotRooms.keySet())
			roomType.put(i, ManageRooms.DOUBLE_BED_COT);
	}
	
	public static ArrayList<String> getRoomList(String type) {
		if (type.equals(ManageRooms.KING)) {
			return getFreeRooms(kingRooms);
		} else if (type.equals(ManageRooms.QUEEN)) {
			return getFreeRooms(queenRooms);
		} else if (type.equals(ManageRooms.DOUBLE_BED)) {
			return getFreeRooms(twoDoubleRooms);
		} else if (type.equals(ManageRooms.DOUBLE_BED_COT)) {
			return getFreeRooms(twoDoubleCotRooms);
		}
		return null;
	}
	
	private static ArrayList<String> getFreeRooms(HashMap<Integer, Information> rooms) {
		ArrayList<String> list = new ArrayList<>();
		for (Integer i : rooms.keySet()) {
			if (rooms.get(i) == null)
				list.add(""+i);
		}
		return list;
	}

	public static String getFullName(int roomNo)
	{
		
		if (!roomType.containsKey(roomNo))
			return "-";
		
		String room = roomType.get(roomNo);
		
		if (room == ManageRooms.KING) {
			if (kingRooms.get(roomNo) != null )
				return kingRooms.get(roomNo).fname;
		} else if (room == ManageRooms.QUEEN) {
			if (queenRooms.get(roomNo) != null)
				return queenRooms.get(roomNo).fname;
		} else if (room == ManageRooms.DOUBLE_BED) {
			if (twoDoubleRooms.get(roomNo) != null)
				return twoDoubleRooms.get(roomNo).fname;
		} else if (room == ManageRooms.DOUBLE_BED_COT) {
			if (twoDoubleCotRooms.get(roomNo) != null)
				return twoDoubleCotRooms.get(roomNo).fname;
		}
		
		return "-";
	}
	
	public static boolean isRoomAvailable(Information info) {
		int roomNo = info.roomNumber;
		if (info.roomType == ManageRooms.KING) {
			if (kingRooms.containsKey(roomNo))
				return kingRooms.get(roomNo)==null;
		} else if (info.roomType == ManageRooms.DOUBLE_BED) {
			if (twoDoubleRooms.containsKey(roomNo))
				return twoDoubleRooms.get(roomNo)==null;
		} else if (info.roomType == ManageRooms.QUEEN) {
			if (queenRooms.containsKey(roomNo))
				return queenRooms.get(roomNo)==null;
		} else if (info.roomType == ManageRooms.DOUBLE_BED_COT) {
			if (twoDoubleCotRooms.containsKey(roomNo))
				return twoDoubleCotRooms.get(roomNo)==null;
		}
		return false;
	}
	
	
	public static int getGuestsInRoom(int roomNo) {
		String type = roomType.get(roomNo);
		if (type == ManageRooms.KING) {
			if (kingRooms.containsKey(roomNo))
				if (kingRooms.get(roomNo) != null)
					return kingRooms.get(roomNo).room.getTotalGuests();
		} else if (type == ManageRooms.DOUBLE_BED) {
			if (twoDoubleRooms.containsKey(roomNo))
				if (twoDoubleRooms.get(roomNo) != null)
					return twoDoubleRooms.get(roomNo).room.getTotalGuests();
		} else if (type == ManageRooms.QUEEN) {
			if (queenRooms.containsKey(roomNo))
				if (queenRooms.get(roomNo)!=null)
					return queenRooms.get(roomNo).room.getTotalGuests();
		} else if (type == ManageRooms.DOUBLE_BED_COT) {
			if (twoDoubleCotRooms.containsKey(roomNo))
				if (twoDoubleCotRooms.get(roomNo)!=null)
					return twoDoubleCotRooms.get(roomNo).room.getTotalGuests();
		}
		return 0;
	}
	
	public static int getAvailableRoomsForType(String type) {
		HashMap<Integer, Information> hm = null;
		if (type == ManageRooms.KING)
			hm = kingRooms;
		else if (type == ManageRooms.QUEEN)
			hm = queenRooms;
		else if (type == ManageRooms.DOUBLE_BED)
			hm = twoDoubleRooms;
		else if (type == ManageRooms.DOUBLE_BED_COT)
			hm = twoDoubleCotRooms;
		
		int avail = 0;
		if (hm != null) {
			for (Integer i : hm.keySet())
				if (hm.get(i) == null)
					avail++;
		}
		return avail;
	}
	
	public static boolean allocateRoom(Information info) {
		int roomNo = info.roomNumber;
		if (!isRoomAvailable(info)) {
			System.err.println("Room number " + roomNo + " is not available!");
			return false;
		}
		String type = info.roomType;
		if (type.equals(ManageRooms.KING)) {
			kingRooms.put(roomNo, info);
		} else if (type.equals(ManageRooms.QUEEN)) {
			queenRooms.put(roomNo, info);
		} else if (type.equals(ManageRooms.DOUBLE_BED)) {
			twoDoubleRooms.put(roomNo, info);
		} else if (type.equals(ManageRooms.DOUBLE_BED_COT)) {
			twoDoubleCotRooms.put(roomNo, info);
		}
		
		allocatedRooms.add(roomNo);
		return true;
	}
	
	public static boolean releaseRoom(int roomNo, Information info) {
		
		if (!roomType.containsKey(roomNo)) {
			info = null;
			return false;
		}
		
		String type = roomType.get(roomNo);
		
		if (type == ManageRooms.KING) {
			if (kingRooms.containsKey(roomNo)) {
				info = kingRooms.get(roomNo);
				kingRooms.put(roomNo, null);
			}
		} else if (type == ManageRooms.QUEEN) {
			if (queenRooms.containsKey(roomNo)) {
				info = queenRooms.get(roomNo);
				queenRooms.put(roomNo, null);
			}
		} else if (type == ManageRooms.DOUBLE_BED) {
			if (twoDoubleRooms.containsKey(roomNo)) {
				info = twoDoubleRooms.get(roomNo);
				twoDoubleRooms.put(roomNo, null);
			}
		} else if (type == ManageRooms.DOUBLE_BED_COT) {
			if (twoDoubleCotRooms.containsKey(roomNo)) {
				info = twoDoubleCotRooms.get(roomNo);
				twoDoubleCotRooms.put(roomNo, null);
			}
		}
		
		if (info != null) {
			info.invoiceAmount = info.room.getInvoice();
			info.room = null;
		}
		
		if (allocatedRooms.contains(roomNo))
			allocatedRooms.remove(roomNo);
		return true;
	}
	
	public static HashSet<String> getAllAllocatedRooms() {
		HashSet<String> hs = new HashSet<>();
		for (Integer i : allocatedRooms) {
			hs.add("" + i);
		}
		return hs;
	}
	
	public static int getRoomInvoice(int roomNo, String type) {
		if (type == ManageRooms.KING) {
			if (kingRooms.containsKey(roomNo) && kingRooms.get(roomNo)!=null)
				return kingRooms.get(roomNo).room.getInvoice();
		} else if (type == ManageRooms.DOUBLE_BED) {
			if (twoDoubleRooms.containsKey(roomNo) && twoDoubleRooms.get(roomNo)!=null)
				return twoDoubleRooms.get(roomNo).room.getInvoice();
		} else if (type == ManageRooms.QUEEN) {
			if (queenRooms.containsKey(roomNo) && queenRooms.get(roomNo) != null)
				return queenRooms.get(roomNo).room.getInvoice();
		} else if (type == ManageRooms.DOUBLE_BED_COT) {
			if (twoDoubleCotRooms.containsKey(roomNo) && twoDoubleCotRooms.get(roomNo)!=null)
				return twoDoubleCotRooms.get(roomNo).room.getInvoice();
		}
		return 0;
	}
	
}
