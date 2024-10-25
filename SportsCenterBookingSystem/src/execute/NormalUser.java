package execute;

import java.util.ArrayList;
import java.util.Scanner;

public class NormalUser implements UserRole {
	
	@Override
    public boolean makeBooking() {
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
    	
    	System.out.println("Please input the booking ID you want to cancel:");
    	Scanner scanner = new Scanner(System.in);
    	String bookingID = scanner.nextLine();
    	
    	Booking booking = sportsCenter.getBookingByBookingID(bookingID);
    	//user.removeBooking(booking); (use getCurrentUser or pass user object here?)
    	scanner.close();
        return false;
        
    }

	@Override
	public String showActionMenu() {
		Scanner scanner = new Scanner(System.in);
		String action;
		System.out.println("Please input your action ([m] for make booking, [v] for view booking, [c] for cancel booking, [l] for logout):");
		action = scanner.nextLine();
		if (!action.equals("m") && !action.equals("v") && !action.equals("c") && !action.equals("l")) {
			// throw new ExInvalidCommand(); 
		}
		scanner.close();
		return action;
	}

	@Override
	public String toString(String userID, String userPassword) {
		return userID + " N " + userPassword;
	}
}