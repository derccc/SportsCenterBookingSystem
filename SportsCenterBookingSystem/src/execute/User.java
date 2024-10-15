package execute;

import java.util.ArrayList;

public class User {
    private String userID;
    private String userRole;
    private String userPassword;

    public User(String userID, String userRole, String userPassword){
        this.userID = userID;
        this.userRole = userRole;
        this.userPassword = userPassword;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getUserRole(){
        return this.userRole;
    }

    public String getUserPasword(){
        return this.userPassword;
    }

    public void viewBooking(){

        SportsCenter sportsCenter = SportsCenter.getInstance();
        ArrayList<Booking> allBookings = sportsCenter.getAllBookings();

        switch(this.userRole){
            case "A":
                for (Booking b: allBookings){
                    System.out.println(b.toString());
                }
                break;

            case "N":
                for (Booking b: allBookings){
                    if (b.getUserID().equals(this.getUserID())){
                        System.out.println(b.toString());
                    }
                }
                break;
        }
        
    }

    public String toString(){
		//UserID UserRole UserPassword
		return userID+" "+userRole+" "+userPassword;
	}

    public static User getUserByUserID (ArrayList<User> allUsers, String id){
        for (User u: allUsers){
            if(u.userID.equals(id)){return u;}
        }

        return null;
    }

 
}