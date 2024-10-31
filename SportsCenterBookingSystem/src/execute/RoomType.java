package execute;

import java.util.ArrayList;

public class RoomType {
	private String typeID;
	private String type;
	private int price;
	
	public RoomType(String typeID, String type, int price) {
		this.typeID = typeID;
		this.type = type;
		this.price = price;
	}
	
	public String getTypeID() {
		return typeID;
	}
	
	public String getType() {
		return type;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public static RoomType getRoomTypeByID(ArrayList<RoomType> allRoomTypes, String roomTypeID) {
		for(RoomType r: allRoomTypes){
			if (r.typeID.equals(roomTypeID)){return r;}
		}
		return null;
	}
	
	public String printAllRoomTypeString() {
		return "ID: " + typeID + " Name: " + type + " Price: " + price;
	}

	public String toString(){
		//TypeID Type Price
		return typeID + " " + type + " " + price;
	}
}
