package execute;

import java.util.ArrayList;

public class Admin extends User {

    public Admin(String userID, String userPassword) {
        super(userID, userPassword);
    }

    @Override
    public String getRole() {
        return "Admin";
    }

    @Override
    public void viewBooking() {
        SportsCenter sportsCenter = SportsCenter.getInstance();
        ArrayList<Booking> allBookings = sportsCenter.getAllBookings();
        for (Booking b: allBookings){
            System.out.println(b.toString());
        }
    }

    

}