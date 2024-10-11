package execute;

import java.util.ArrayList;

public class NormalUser extends User {

    public NormalUser(String userID, String userPassword) {
        super(userID, userPassword);
    }

    @Override
    public String getRole() {
        return "NormalUser";
    }

    @Override
    public void viewBooking() {
        SportsCenter sportsCentre = SportsCenter.getInstance();
        ArrayList<Booking> allBookings = sportsCentre.getAllBookings();
        for (Booking b: allBookings){
            if (b.getUserID().equals(this.getUserID())){
                System.out.println(b.toString());
            }
        }
    }

    
    

}
