package execute;

public class Booking {
	private String bookingID;
	private int startTime;
	private int endTime;
	private int duration;
	
	public Booking(String bookingID, int startTime, int endTime) {
		this.bookingID = bookingID;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = endTime - startTime;
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

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
}
