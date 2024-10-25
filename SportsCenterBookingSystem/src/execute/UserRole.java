package execute;

import java.util.ArrayList;

public interface UserRole {
	
	static UserRole getUserRoleByChar(String userRole) {
        switch(userRole){
            case "A":
                return new Admin();
            case "N":
                return new NormalUser();
        }
        return null;
    }
	
    void viewBooking(ArrayList<Booking> allBookings);
    boolean makeBooking();
    boolean cancelBooking(String bookingID);
    String showActionMenu();
	
}
