package execute;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin implements UserRole {
	
	@Override
    public boolean makeBooking() {
    	//TODO: make booking for specific user
		SportsCenter sportsCenter = SportsCenter.getInstance();
    	
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Please input the user ID you want to make the booking for:");
    	String userID = scanner.nextLine();
    	User user = sportsCenter.getUserByUserID(userID);
    	while (user == null) {
			System.out.println("User ID not found, please input again:");
			userID = scanner.nextLine();
			user = sportsCenter.getUserByUserID(userID);
		};
		
		
        return false;
        
    }
	
	@Override
	public void viewBooking(ArrayList<Booking> allBookings) {
		SportsCenter sportsCenter = SportsCenter.getInstance();
		
		//TODO: view specific user bookings, view specific room bookings, view all bookings
		
        sportsCenter.viewAllBookings();
    }

    

    @Override
    public boolean cancelBooking() {
    	//TODO: cancel booking for specific user
    	
    	SportsCenter sportsCenter = SportsCenter.getInstance();
    	
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Please input the user ID you want to cancel the booking for:");
    	String userID = scanner.nextLine();
    	User user = sportsCenter.getUserByUserID(userID);
    	
		while (user == null) {
			System.out.println("User ID not found, please input again:");
			userID = scanner.nextLine();
			user = sportsCenter.getUserByUserID(userID);
		};
		user.viewBooking();
		
    	System.out.println("Please input the booking ID you want to cancel:");
    	String bookingID = scanner.nextLine();
    	
    	Booking booking = sportsCenter.getBookingByBookingID(bookingID);
    	user.removeBooking(booking);
    	//TODO: remove booking from txt file
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
		return userID + " A " + userPassword;
	}
    
	

}
