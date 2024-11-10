package execute;

public class UserSessionManager {
    private static UserSessionManager instance;
    private User currentUser;

    private UserSessionManager() {}

    public static UserSessionManager getInstance() {
        if (instance == null) {
            instance = new UserSessionManager();
        }
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
}
