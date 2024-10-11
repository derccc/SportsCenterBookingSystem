package execute;

public abstract class User {
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

    public abstract String getRole();

    public abstract void viewBooking();

    
}