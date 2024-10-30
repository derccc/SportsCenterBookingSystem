package execute;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin implements UserRole {
	
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
    	//TODO: make booking for specific user
		SportsCenter sportsCenter = SportsCenter.getInstance();
    	
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Please input the user ID you want to make the booking for:");
    	String userID = scanner.nextLine();
    	User user = sportsCenter.getUserByID(userID);
    	while (user == null) {
			System.out.println("User ID not found, please input again:");
			userID = scanner.nextLine();
			user = sportsCenter.getUserByID(userID);
		};
		
		
        return false;
        
    }
	
	@Override
	public void viewBooking() {
		SportsCenter sportsCenter = SportsCenter.getInstance();
		Scanner scanner = new Scanner(System.in);
		String action;
		//TODO: view specific user bookings, view specific room bookings
		System.out.println("Please input your action ([u] for view specific user booking(s), [r] for view specific room booking(s)):");
		action = scanner.nextLine();
		switch (action) {
			case "u":
				System.out.println("Please input the user ID you want to view the booking for:"); //maybe all this ask for user ID can be put in a function
				String userID = scanner.nextLine();
				User user = sportsCenter.getUserByID(userID);
		    	while (user == null) {
					System.out.println("User ID not found, please input again:");
					userID = scanner.nextLine();
					user = sportsCenter.getUserByID(userID);
				};
				//show bookingID, roomID, roomType, date, startTime, endTime, price paid  
				System.out.printf("Here are all the bookings for User %s: \n", userID);
				for (Booking b : user.getAllBookings()) {
					System.out.println(b.viewUserBookingString());
				}
				
				
				break;
				
			case "r":
				System.out.println("Please input the room ID you want to view the booking for:");
				String roomID = scanner.nextLine();
				Room room = sportsCenter.getRoomByID(roomID);
				while (room == null) {
					System.out.println("Room ID not found, please input again:");
					roomID = scanner.nextLine();
					room = sportsCenter.getRoomByID(roomID);
				}
				//show bookingID, userID, date, startTime, endTime
				System.out.printf("Here are all the bookings for Room %s (Room Type: %s): \n", roomID, room.getRoomType());
				for (Booking b: room.getAllBookings()) {
					System.out.println(b.viewRoomBookingString());
				}
				
			    break;
		
		}
			
		
        
    }

    

    @Override
    public boolean cancelBooking() {
    	//TODO: cancel booking for specific user
    	
    	SportsCenter sportsCenter = SportsCenter.getInstance();
    	
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Please input the user ID you want to cancel the booking for:");
    	String userID = scanner.nextLine();
    	User user = sportsCenter.getUserByID(userID);
    	
		while (user == null) {
			System.out.println("User ID not found, please input again:");
			userID = scanner.nextLine();
			user = sportsCenter.getUserByID(userID);
		};
		user.viewBooking();
		
    	System.out.println("Please input the booking ID you want to cancel:");
    	String bookingID = scanner.nextLine();
    	
    	Booking booking = sportsCenter.getBookingByID(bookingID);
    	user.removeBooking(booking);
    	//TODO: remove booking from txt file
    	
        return false;
       
    }

	

	@Override
	public String toString(String userID, String userPassword) {
		return userID + " A " + userPassword;
	}
    
	

}
