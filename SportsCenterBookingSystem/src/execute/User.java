package execute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class User {
	private String userID;
	private UserRole userRole;
    private String userPassword;
    private ArrayList<Booking> allBookings;
    //may add wallet attribute to handle the price payment

    public User (String userID, String userRole, String userPassword){
        this.userID = userID;
        this.userRole = UserRole.getUserRoleByChar(userRole);
        this.userPassword = userPassword;
        this.allBookings = new ArrayList<>();
    }

    public String getUserID() {
        return this.userID;
    }

    public String getUserPasword(){
        return this.userPassword;
    }
    
	public ArrayList<Booking> getAllBookings() {
		return allBookings;
	}
    
	public String toString() {
		//String save to txt file
		return userRole.toString(userID, userPassword);
	}
    
	public static User getUserByID (ArrayList<User> allUsers, String userID){
        for (User u: allUsers){
            if(u.userID.equals(userID)){return u;}
        }
        return null;
    }

	public String showActionMenu(){
        String action = userRole.showActionMenu();
        return action;
		
	}
	
	public void makeBooking() {
		userRole.makeBooking();
	}
	
	public void viewBooking(){
		userRole.viewBooking();
    }

	public void cancelBooking() {
		userRole.cancelBooking();
	}
	
	public void addBooking(Booking booking) {
		allBookings.add(booking);
		Collections.sort(allBookings);
	}

	/*
	public void removeBooking(Booking booking) {
		allBookings.remove(booking);
	}
	*/
	
	public void makeUserBooking() {
		SportsCenter sportsCenter = SportsCenter.getInstance();
    	Scanner scanner = new Scanner(System.in);
		System.out.println("The followings are all the room type available:");
		sportsCenter.printAllRoomType();
		
		System.out.println("Please input the Room Type ID you would like to book:");
		String roomTypeID = scanner.nextLine();
		RoomType roomType = sportsCenter.getRoomTypeByID(roomTypeID);
		while (roomType == null) {
			System.out.println("Room Type ID not found, please input again:");
			roomTypeID = scanner.nextLine();
			roomType = sportsCenter.getRoomTypeByID(roomTypeID);
		}
		
		System.out.println("Please input the Date and Time you would like to book (format: yyMMdd HH-HH (e.g.241001 15-20)):");
		//TODO: handle wrong input format, date and time
		String dateAndTime = scanner.nextLine();
		String[] splittedDateAndTime = dateAndTime.split(" ");
		String date = splittedDateAndTime[0];
		String time = splittedDateAndTime[1];
		String[] splittedTime = time.split("-");
		int startTime = Integer.parseInt(splittedTime[0]);
		int endTime = Integer.parseInt(splittedTime[1]);
		
		//TODO: checkAvailability
		Room room = sportsCenter.checkAvailability(roomType, date, startTime, endTime);
		
		if (room != null) {
			//TODO: handle endTime-startTime (e.g. 23-00)
			int bookingPrice = roomType.getPrice()*(endTime-startTime);
			System.out.printf("Room available (Price: $%d), are you confirmed to book and pay? (Y/N):\n", bookingPrice);
			String action = scanner.nextLine();
			switch(action) {
				case "Y":
					System.out.println("Payment collected. Booking Success.");
					int nextBookingID = sportsCenter.getNextBookingID();
					Booking booking = new Booking(room, this.userID, date, startTime, endTime, bookingPrice, "N", String.valueOf(nextBookingID));
					this.addBooking(booking);
					room.addBooking(booking);
					sportsCenter.addBooking(booking);
					break;
					
				case "N":
					System.out.println("Booking Cancelled.");
					break;
					
				default:
					//TODO: handle wrong input
					break;
			}
			
		} else {
			System.out.println("Sorry, the room is not available at the time you want. Would you like to book another time or room? (Y/N):");
			String action = scanner.nextLine();
			switch(action) {
                case "Y":
                    makeBooking();
                    break;
                    
                case "N":
                    break;
                    
                default:
                	//TODO: handle wrong input
                	break;
			}
		}
		
	}

	public void viewUserBooking() {
		if (allBookings.size()>0) {
			System.out.println("The followings are all the booking:");
			for (Booking b: allBookings) {
				if (!b.getIsCancelled()){
					System.out.println(b.viewUserBookingString());
				}
			}
		} else {
			System.out.println("No booking records.");
		}
	}

	public void cancelUserBooking() {
		SportsCenter sportsCenter = SportsCenter.getInstance();
    	Scanner scanner = new Scanner(System.in);
    	this.viewUserBooking();
		System.out.println("Please input the Booking ID you would like to cancel:");
    	String bookingID = scanner.nextLine();
    	Booking booking = sportsCenter.getBookingByID(bookingID);
    	while (booking == null) {
			System.out.println("Booking ID not found, please input again:");
			bookingID = scanner.nextLine();
			booking = sportsCenter.getBookingByID(bookingID);
		}
    	
    	int refund = booking.getPricePaid()/2;
    	System.out.printf("Refund for cancelled booking: $%d, are you confirmed to cancel booking? (Y/N):\n", refund);
    	String action = scanner.nextLine();
    	switch(action) {
    		case "Y":
    			booking.cancelBooking();
    			System.out.println("Booking cancelled.");
    			break;
    			
    		case "N":
    			break;
    			
    		default:
    			//TODO: handle wrong input
    	}
    	
    	Room room = sportsCenter.getRoomByID(booking.getRoom().getRoomID());
    	
    	/*
    	this.removeBooking(booking);
    	room.removeBooking(booking);
    	*/
    	sportsCenter.removeBooking(booking);
    	
		
	}

	

 
}