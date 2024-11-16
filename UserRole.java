package execute;

import java.util.ArrayList;
import java.util.Scanner;

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
	
	public String showActionMenu(Scanner scanner);
	public boolean makeBooking(Scanner scanner);
    public void viewBooking(Scanner scanner);
    public boolean cancelBooking(Scanner scanner);
    public String toString(String userID, String userPassword);

}
