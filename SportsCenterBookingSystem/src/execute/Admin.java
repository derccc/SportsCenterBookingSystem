package execute;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin implements UserRole {
	
	@Override
	public String showActionMenu() {
		Scanner scanner = new Scanner(System.in);
		String action;
		System.out.println("Please input your action ([m] for make booking, [v] for view booking, [c] for cancel booking, [l] for logout, [d] for mark closing date of sports center, [a] add room, [p] for modify room type price):");
		action = scanner.nextLine();
		//TODO: handle invalid Command
		if (!action.equals("m") && !action.equals("v") && !action.equals("c") && !action.equals("l") && !action.equals("d") && !action.equals("a") && !action.equals("p")) {
			// throw new ExInvalidCommand();
		}
		
		return action;
	}
	
	@Override
    public boolean makeBooking() {
		SportsCenter sportsCenter = SportsCenter.getInstance();
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Please input the User ID you would like to make booking for:");
    	String userID = scanner.nextLine();
    	User user = sportsCenter.getUserByID(userID);
    	while (user == null) {
			System.out.println("User ID not found, please input again:");
			userID = scanner.nextLine();
			user = sportsCenter.getUserByID(userID);
		};
		
		user.makeUserBooking();
		
        return false; 
    }
	
	@Override
	public void viewBooking() {
		SportsCenter sportsCenter = SportsCenter.getInstance();
		Scanner scanner = new Scanner(System.in);
		String action;
		
		System.out.println("Please input your action ([a] for view all user booking, [u] for view specific user booking, [r] for view specific room booking):");
		action = scanner.nextLine();
		
		switch (action) {
			case "a":
					ViewBookingService viewBookingService = new ViewBookingService();
					viewBookingService.viewBooking(sportsCenter.getAllBookings());
					break;
			case "u":
				System.out.println("Please input the User ID you would like to view booking for:"); //maybe all this ask for user ID can be put in a function
				String userID = scanner.nextLine();
				User user = sportsCenter.getUserByID(userID);
		    	while (user == null) {
					System.out.println("User ID not found, please input again:");
					userID = scanner.nextLine();
					user = sportsCenter.getUserByID(userID);
				};
				
				user.viewUserBookingCalendar();
				
				break;
				
			case "r":
				System.out.println("Please input the Room ID you would like to view booking for:");
				String roomID = scanner.nextLine();
				Room room = sportsCenter.getRoomByID(roomID);
				while (room == null) {
					System.out.println("Room ID not found, please input again:");
					roomID = scanner.nextLine();
					room = sportsCenter.getRoomByID(roomID);
				}
				
				room.viewRoomBookingCalendar();
				
			    break;
			    
			default:
				//TODO: handle invalid Command
				break;
		
		}
        
    }

    @Override
    public boolean cancelBooking() {
    	SportsCenter sportsCenter = SportsCenter.getInstance();
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Please input the User ID you would like to cancel booking for:");
    	String userID = scanner.nextLine();
    	User user = sportsCenter.getUserByID(userID);
    	
		while (user == null) {
			System.out.println("User ID not found, please input again:");
			userID = scanner.nextLine();
			user = sportsCenter.getUserByID(userID);
		};
		
		user.cancelUserBooking();
		
        return false;
    }

	@Override
	public String toString(String userID, String userPassword) {
		return userID + " A " + userPassword;
	}

}
