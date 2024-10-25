package execute;

public class NormalUser implements UserRole {

    @Override
    public void viewBooking() {
        
    }

    @Override
    public boolean makeBooking() {
        return false;
        
    }

    @Override
    public boolean cancelBooking(String bookingID) {
        return false;
        
    }
    
}