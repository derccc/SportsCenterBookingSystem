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
	
	public boolean makeBooking();
    public void viewBooking(ArrayList<Booking> allBookings);
    public boolean cancelBooking();
    public String showActionMenu();
    public String toString(String userID, String userPassword);

}
