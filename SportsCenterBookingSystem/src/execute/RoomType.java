package execute;

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
}
