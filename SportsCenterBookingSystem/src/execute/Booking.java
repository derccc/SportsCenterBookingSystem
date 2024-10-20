package execute;

import java.util.ArrayList;

public class Booking {
	private String roomID;
	private String userID;
	private String date;
	private int startTime;
	private int endTime;
	private String bookingID;
	
	public Booking(String roomID, String userID, String date, int startTime, int endTime, String bookingID) {
        this.roomID = roomID;
        this.userID = userID;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookingID = bookingID;
    }
	
	public String getRoomID() {
		return this.roomID;
	}
	
	public String getUserID() {
		return this.userID;
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
	
	public String toString(){
		//RoomID UserID YYMMDD StartingTime EndingTime
        return roomID + " " + userID + " " +  date + " " + startTime + " " + endTime;
    }



	public static Booking getBookingById(ArrayList<Booking> bookingList, String bookingId){
		for(Booking b: bookingList){
			if(b.bookingID==bookingId){return b;}
		}
		return null;
	}


    
}
