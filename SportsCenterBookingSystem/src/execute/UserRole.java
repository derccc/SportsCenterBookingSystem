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
	
	public String showActionMenu();
	public boolean makeBooking();
    public void viewBooking();
    public boolean cancelBooking();
    public String toString(String userID, String userPassword);

}
