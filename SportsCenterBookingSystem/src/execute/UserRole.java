package execute;

import java.util.ArrayList;

public interface UserRole {
	
	public static UserRole getUserRoleByChar(String userRole) {
        switch(userRole){
            case "A":
                return new Admin();
            case "N":
                return new NormalUser();
        }
        return null;
    }
	
    public void viewBooking(ArrayList<Booking> allBookings);
    public boolean makeBooking();
    public boolean cancelBooking(User user);
    public String showActionMenu();
    public String toString(String userID, String userPassword);

}
