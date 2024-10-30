package execute;

import java.util.ArrayList;

public class User {
	private String userID;
	private UserRole userRole;
    private String userPassword;
    private ArrayList<Booking> allBookings;

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
		return userRole.toString(userID, userPassword);
	}
    
	public static User getUserByID (ArrayList<User> allUsers, String id){
        for (User u: allUsers){
            if(u.userID.equals(id)){return u;}
        }

        return null;
    }

	public String showActionMenu(){
        String action = userRole.showActionMenu();
        return action;
		
	}
	
	public void viewBooking(){
		userRole.viewBooking();
    }

	public void makeBooking() {
		userRole.makeBooking();
	}

	public void cancelBooking() {
		userRole.cancelBooking();
	}
	
	public void addBooking(Booking booking) {
		allBookings.add(booking);
	}

	public void removeBookingByID(String bookingID) {
		for (Booking b : allBookings) {
			if (b.getBookingID().equals(bookingID)) {
				allBookings.remove(b);
				break;
			}
		}
	}

 
}