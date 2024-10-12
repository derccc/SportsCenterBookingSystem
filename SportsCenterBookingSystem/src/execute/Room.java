package execute;

import java.util.ArrayList;

public class Room {
	private String roomID;
	private RoomType roomType;
	private ArrayList<BookingsForDay> allbookings;
	
	public Room(String roomID, RoomType roomType) {
		this.roomID = roomID;
		this.roomType=roomType;
		this.allbookings = new ArrayList<>();
	}
	
	public String getRoomID() {
		return this.roomID;
	}

	public RoomType getRoomType(){
		return roomType;
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
	
	public void removeBooking(String bookingID) { //TODO: add this later
		
	}


	//TODO: pass back to Class bookingsforday
	public BookingsForDay getBookingsOfDay(String date) {
		for (BookingsForDay b : this.allbookings) {
			if (b.getDate().equals(date)) {
				return b;
			}
		}
		return null;
	}

	public static Room getRoomById(ArrayList<Room> allRooms, String roomID) {
		for(Room r: allRooms){
			if(r.roomID.equals(roomID)){
				return r;
			}
		}
		return null;
	}
	
}
