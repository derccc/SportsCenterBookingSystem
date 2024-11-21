package execute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Room {
	private String roomID;
	private RoomType roomType;
	private ArrayList<Booking> allBookings;
	
	public Room(String roomID, RoomType roomType) {
		this.roomID = roomID;
		this.roomType = roomType;
		this.allBookings = new ArrayList<>();
	}
	
	public String getRoomID() {
		return this.roomID;
	}

	public RoomType getRoomType(){
		return roomType;
	}
	
	public ArrayList<Booking> getAllBookings() {
		return allBookings;
	}
	
	public static Room getRoomByID(ArrayList<Room> allRooms, String roomID) {
		for(Room r: allRooms){
			if(r.roomID.equals(roomID)){return r;}
		}
		return null;
	}
	
	public void addBooking(Booking booking) {
		allBookings.add(booking);
		Collections.sort(allBookings);
	}
	
	public String toString(){
		//roomID roomTypeID
		return roomID + " " + roomType.getTypeID();
	}

	public void viewRoomBookingCalendar(Scanner scanner) {
		if (allBookings.size()>0) {
			ViewBookingService viewBookingService = new ViewBookingService();
			viewBookingService.viewBooking(allBookings, scanner);
		} else {
			System.out.println("No booking records.");
		}
	}
	
}
