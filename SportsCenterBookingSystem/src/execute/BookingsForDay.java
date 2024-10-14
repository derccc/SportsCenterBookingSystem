package execute;
import java.util.ArrayList;

public class BookingsForDay {
	private String date;
	private ArrayList<Booking> bookings;

	public BookingsForDay(String date) {
		this.date = date;
		this.bookings = new ArrayList<>();
	}
	
	public String getDate() {
		return this.date;
	}

	public void addBooking(Booking booking) {
		if (checkAvailability(booking.getStartTime(), booking.getEndTime()))
				this.bookings.add(booking);
		else
			/////////
			throw new IllegalArgumentException("Booking time is not available");
	}

	public void removeBooking(Booking booking) {
		this.bookings.remove(booking);
	}

	
	public boolean checkAvailability(int startTime, int endTime) { //TODO: apply scheduling and move to bookingService
		for (Booking b : this.bookings) {
			int st = b.getStartTime();
			int et = b.getEndTime();
			if (startTime <= st && endTime > st || startTime < et && endTime >= et || startTime >= st && endTime <= et) {
				return false;
			}
		}
		return true;
	}

	//TODO: removeBookingById (ArrayList<>, String)
	//for loop traverse arraylist
	//call get bookingById in Booking
	//if not null, call removeBooking here
	//return boolean for success or use custom exception


	
}
