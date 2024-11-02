package execute;

import java.util.ArrayList;

public class Booking {
	private String roomID;
	private String userID;
	private String date;
	private int startTime;
	private int endTime;
	private int pricePaid;
	private String isCancelled;
	private String bookingID;
	
	public Booking(String roomID, String userID, String date, int startTime, int endTime, int pricePaid, String isCancelled, String bookingID) {
        this.roomID = roomID;
        this.userID = userID;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.pricePaid = pricePaid;
        this.isCancelled = isCancelled;
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
	
	public int getPricePaid() {
		return this.pricePaid;
		
	}
	
	public boolean getIsCancelled() {
		if (isCancelled.equals("Y")) {
			return true;
		} else if (isCancelled.equals("N")){
			return false;
		}
		return false;
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
	
	public void cancelBooking() {
		this.isCancelled = "Y";
		this.pricePaid = pricePaid/2;
	}
	
	public String toString(){
		//String saved to txt file
		//RoomID UserID YYMMDD StartingTime EndingTime bookingID
        return roomID + " " + userID + " " +  date + " " + startTime + " " + endTime + " " + pricePaid + " " + isCancelled + " " + bookingID;
    }
	
	public String viewUserBookingString() {
		SportsCenter sportsCenter = SportsCenter.getInstance();
		RoomType roomType = sportsCenter.getRoomByID(roomID).getRoomType();
		return "Booking ID: " + bookingID + " Room ID: " + roomID + " Room Type: " + roomType.getType() + " Date: " + date + " Start Time: " + startTime + " End Time: " + endTime + " Price Paid: $" + pricePaid;
	}
	
	public String viewRoomBookingString() {
		return "Booking ID: " + bookingID + " User ID: " + userID + " Date: " + date + " Start Time: " + startTime + " End Time: " + endTime;
	}



	public static Booking getBookingByID(ArrayList<Booking> allBookings, String bookingID){
		for(Booking b: allBookings){
			if(b.bookingID.equals(bookingID)){return b;}
		}
		return null;
	}

	public static ArrayList<Booking> getBoookingsOfSpecificDate(ArrayList<Booking> bookingList, String date) {
		//may help checkAvailability?
		ArrayList<Booking> result = new ArrayList<>();
		for (Booking b : bookingList) {
			if (b.date.equals(date)) {
				result.add(b);
			}
		}
		return result;
	}

	

	

	
    
}
