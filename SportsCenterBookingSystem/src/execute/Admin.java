package execute;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin implements UserRole {
	
	@Override
    public boolean makeBooking() {
    	//TODO: make booking for specific user
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
