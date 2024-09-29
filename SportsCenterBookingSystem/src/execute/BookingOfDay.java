package execute;
import java.util.ArrayList;

public class BookingOfDay {
	private String date;
	private ArrayList<Booking> bookings;

	public BookingOfDay(String date) {
		this.date = date;
		this.bookings = new ArrayList<>();
	}

	public void addBooking(Booking booking) {
		
		this.bookings.add(booking);
	}

	public void removeBooking(Booking booking) {
		this.bookings.remove(booking);
	}
	
	public boolean checkAvailability(int startTime, int endTime) {
		for (Booking b : this.bookings) {
			int st = b.getStartTime();
			int et = b.getEndTime();
			if (startTime <= st && endTime > st || startTime < et && endTime >= et || startTime >= st && endTime <= et) {
				return false;
			}
		}
		return true;
	}
}
