package execute;

import java.util.ArrayList;
import java.util.Scanner;

public class NormalUser implements UserRole {
	
	@Override
	public String showActionMenu() {
		Scanner scanner = new Scanner(System.in);
		String action;
		System.out.println("Please input your action ([m] for make booking, [v] for view booking, [c] for cancel booking, [l] for logout):");
		action = scanner.nextLine();
		if (!action.equals("m") && !action.equals("v") && !action.equals("c") && !action.equals("l")) {
			// throw new ExInvalidCommand(); 
		}
		
		return action;
	}
	
	@Override
    public boolean makeBooking() {
		SportsCenter sportsCenter = SportsCenter.getInstance();
		System.out.println("Here are all the room types available:");
		sportsCenter.printAllRoomType();
		System.out.println("Please input the room type ID you want to book:");
		Scanner scanner = new Scanner(System.in);
		String roomType = scanner.nextLine();
		
		return false;
        
    }

    @Override
    public void viewBooking(ArrayList<Booking> allBookings) {
        for (Booking b: allBookings) {
        	System.out.println(b.toString());
        }
    }

    @Override
    public boolean cancelBooking() {
    	//TODO: show all bookings with bookingID
    	SportsCenter sportsCenter = SportsCenter.getInstance();
    	User user = Main.getCurrentUser();
    	
    	user.viewBooking();
    	
    	System.out.println("Please input the booking ID you want to cancel:");
    	Scanner scanner = new Scanner(System.in);
    	String bookingID = scanner.nextLine();
    	
    	Booking booking = sportsCenter.getBookingByID(bookingID);
    	user.removeBooking(booking);
    	//TODO: remove booking from txt file
    	
        return false;
        
    }

	

	@Override
	public String toString(String userID, String userPassword) {
		return userID + " N " + userPassword;
	}
}