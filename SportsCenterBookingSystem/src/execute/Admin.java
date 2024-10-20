package execute;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {

	public Admin(String userID, String userPassword) {
		super(userID, userPassword);
	}
	
	public String showActionMenu() {
		Scanner scanner = new Scanner(System.in);
        String action;

		do {
    		System.out.println("Please input your action ([v] for view booking, [c] for cancel booking, [l] for logout):");
            action = scanner.nextLine();
    	} while (!action.equals("v") && !action.equals("c") && !action.equals("l"));
        
        
        scanner.close();
        return action;
	}
	
	public void viewBooking(){
		
		
		Scanner scanner = new Scanner(System.in);
		String action;
		do {
			System.out.println("Please input your action ([1] for view specific user's booking(s), [2] for view specific room's booking(s), [3] for view all bookings):");
			action = scanner.nextLine();
			
		} while (!action.equals("1") && !action.equals("2") && !action.equals("3"));
	
		SportsCenter sportsCenter = SportsCenter.getInstance();
		ArrayList<Booking> allBookings = sportsCenter.getAllBookings();
		switch (action) {
		case "1":
			System.out.println("Please input the user ID:");
			String userID = scanner.nextLine();
			for (Booking b : allBookings) {
				if (b.getUserID().equals(userID)) {
					System.out.println(b.toString());
				}
			}
			break;
			
		case "2":
			System.out.println("Please input the room ID:");
			String roomID = scanner.nextLine();
			for (Booking b : allBookings) {
				if (b.getRoomID().equals(roomID)) {
					System.out.println(b.toString());
				}
			}
			break;
			
		case "3":
			for (Booking b : allBookings) {
				System.out.println(b.toString());
			}
			break;
		}

        scanner.close();
    }

}
