package execute;

public class Booking {
	private String roomID;
	private String UserID;
	private String date;
	private int startTime;
	private int endTime;
	private String bookingID;
	
	public Booking(String roomID, String UserID, String date, int startTime, int endTime, String bookingID) {
        this.roomID = roomID;
        this.UserID = UserID;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookingID = bookingID;
    }
	
	public String getRoomID() {
		return this.roomID;
	}
	
	public String getUserID() {
		return this.UserID;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public String getBookingID() {
		return this.bookingID;
	}
	
	public int getStartTime() {
		return this.startTime;
	}
	
	public int getEndTime() {
		return this.endTime;
	}
	
	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	
//	public void setUserID(String UserID) {
//		this.UserID = UserID;
//	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
//	public void setBookingID(String bookingID) {
//		this.bookingID = bookingID;
//	}
	
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
}
