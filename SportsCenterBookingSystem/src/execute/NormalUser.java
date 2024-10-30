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
		String roomTypeID = scanner.nextLine();
		RoomType roomType = sportsCenter.getRoomTypeByID(roomTypeID);
		User user = Main.getCurrentUser();
		
		System.out.println("Please input the date, start time, end time for the booking (format: 241001 15 20):");
		String userInput = scanner.nextLine();
		String[] splittedUserInput = userInput.split(" ");
		String date = splittedUserInput[0];
		int startTime = Integer.parseInt(splittedUserInput[1]);
		int endTime = Integer.parseInt(splittedUserInput[2]);
		
		String roomID = sportsCenter.checkAvailability(roomTypeID, date, startTime, endTime);
		if (roomID != null) {
			System.out.println("Room available, are you confirm to book? (Y/N):");
			String action = scanner.nextLine();
			switch(action) {
				case "Y":
					System.out.println("");
					//TODO: collect payment, maybe need record payment method in booking class?
					int nextBookingID = sportsCenter.getNextBookingID();
					Booking booking = new Booking(roomID, user.getUserID(), date, startTime, endTime, String.valueOf(nextBookingID));
					user.addBooking(booking);
					//TODO: add booking to txt file
					break;
				case "N":
					System.out.println("Sorry, the room is ");
			}
			
		} else {
			System.out.println("Sorry, the room is not available at the time you want. Would you like to book another time or room? (Y/N):");
			String action = scanner.nextLine();
			switch(action) {
                case "Y":
                    makeBooking();
                    break;
                case "N":
                    showActionMenu();
                    break;
			}
		}
		return false;
        
    }

    @Override
    public void viewBooking() {
    	User user = Main.getCurrentUser();
    	System.out.println("Here are all your bookings:"); 
    	//TODO: show bookingID, roomID, roomType, date, startTime, endTime, price paid
        for (Booking b: user.getAllBookings()) {
        	System.out.println(b.viewUserBookingString());
        }
    }

    @Override
    public boolean cancelBooking() {
    	//TODO: show all bookings with bookingID
    	User user = Main.getCurrentUser();
    	
    	user.viewBooking();
    	
    	System.out.println("Please input the booking ID you want to cancel:");
    	Scanner scanner = new Scanner(System.in);
    	String bookingID = scanner.nextLine();
  
    	user.removeBookingByID(bookingID);
    	//TODO: remove booking from txt file
    	
        return false;
        
    }

	

	@Override
	public String toString(String userID, String userPassword) {
		return userID + " N " + userPassword;
	}
}