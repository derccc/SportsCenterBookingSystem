package execute;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String userID;
    private String userPassword;

    public User(String userID, String userPassword){
        this.userID = userID;
        this.userPassword = userPassword;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getUserPasword(){
        return this.userPassword;
    }

    public void viewBooking(){

        SportsCenter sportsCenter = SportsCenter.getInstance();
        ArrayList<Booking> allBookings = sportsCenter.getAllBookings();

        for (Booking b: allBookings){
            if (b.getUserID().equals(this.getUserID())){
                System.out.println(b.toString());
            }
        }
        
    }

    public String toString(){
		//UserID UserRole UserPassword
		return userID+" "+userPassword;
	}

    public static User getUserByUserID (ArrayList<User> allUsers, String id){
        for (User u: allUsers){
            if(u.userID.equals(id)){return u;}
        }

        return null;
    }

	public String showActionMenu() throws ExInvalidCommand{
		Scanner scanner = new Scanner(System.in);
        String action;
        
        /*
        
		do {
        	System.out.println("Please input your action ([m] for make booking, [v] for view booking, [c] for cancel booking, [l] for logout):");
            action = scanner.nextLine();
        } while (!action.equals("m") && !action.equals("v") && !action.equals("c") && !action.equals("l"));
        
        
        
        scanner.close();
        return action;
        */
        
        
        System.out.println("Please input your action ([m] for make booking, [v] for view booking, [c] for cancel booking, [l] for logout):");
        action = scanner.nextLine();
        if(!action.equals("m") && !action.equals("v") && !action.equals("c") && !action.equals("l")) {throw new ExInvalidCommand();}
        
        scanner.close();
        return action;
		
	}

 
}