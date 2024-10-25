package execute;

import java.util.ArrayList;
import java.util.Scanner;

public class NormalUser implements UserRole {

    @Override
    public void viewBooking(ArrayList<Booking> allBookings) {
        for (Booking b: allBookings) {
        	System.out.println(b.toString());
        }
    }

    @Override
    public boolean makeBooking() {
        return false;
        
    }

    @Override
    public boolean cancelBooking(String bookingID) {
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