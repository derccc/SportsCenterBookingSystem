package execute;

import java.util.ArrayList;

public class Area {
	private String areaID;
	private ArrayList<BookingsForDay> allbookings;
	
	public Area(String areaID) {
		this.areaID = areaID;
		this.allbookings = new ArrayList<>();
	}
	
	public String getAreaID() {
		return this.areaID;
	}
	
	public void addBooking(Booking booking) {
		if (getBookingsOfDay(booking.getDate()) == null) {
			BookingsForDay bookingsForDay = new BookingsForDay(booking.getDate());
			bookingsForDay.addBooking(booking);
			this.allbookings.add(bookingsForDay);
		} else {
			getBookingsOfDay(booking.getDate()).addBooking(booking);
		}
	}
	
	public void removeBooking(String bookingID) {

	}
	
	public BookingsForDay getBookingsOfDay(String date) {
		for (BookingsForDay b : this.allbookings) {
			if (b.getDate().equals(date)) {
				return b;
			}
		}
		return null;
	}
	
}
