package execute;

import java.util.ArrayList;
import java.util.Scanner;

public class NormalUser implements UserRole {
	
	@Override
	public String showActionMenu(Scanner scanner) {
		//Scanner scanner = new Scanner(System.in);
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
    public boolean makeBooking(Scanner scanner) {
		User user = Main.getCurrentUser();
		return user.makeUserBooking(scanner);
		

    }

    @Override
    public void viewBooking(Scanner scanner) {
    	User user = Main.getCurrentUser();
    	user.viewUserBookingCalendar(scanner);
    }

    @Override
    public boolean cancelBooking(Scanner scanner) {
    	User user = Main.getCurrentUser();
    	user.cancelUserBooking(scanner);
    	
        return false;
    }
    
	@Override
	public String toString(String userID, String userPassword) {
		return userID + " N " + userPassword;
	}
	
}