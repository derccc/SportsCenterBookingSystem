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
		//TODO: handle invalid Command
		if (!action.equals("m") && !action.equals("v") && !action.equals("c") && !action.equals("l")) {
			// throw new ExInvalidCommand(); 
		}
		
		return action;
	}
	
	@Override
    public boolean makeBooking() {
		User user = Main.getCurrentUser();
		user.makeUserBooking();
		
		return false;
    }

    @Override
    public void viewBooking() {
    	User user = Main.getCurrentUser();
    	user.viewUserBookingCalendar();
    }

    @Override
    public boolean cancelBooking() {
    	User user = Main.getCurrentUser();
    	user.cancelUserBooking();
    	
        return false;
    }
    
	@Override
	public String toString(String userID, String userPassword) {
		return userID + " N " + userPassword;
	}
	
}