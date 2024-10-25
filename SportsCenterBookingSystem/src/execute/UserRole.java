package execute;

public interface UserRole {
    void viewBooking();
    boolean makeBooking();
    boolean cancelBooking(String bookingID);
    
    static UserRole getUserRoleByChar(String userRole) {
        switch(userRole){
            case "A":
                return new Admin();
            case "N":
                return new NormalUser();
        }
        return null;
    }
}
