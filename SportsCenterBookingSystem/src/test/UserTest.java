package test;

import execute.User;
import execute.UserRole;
import execute.Booking;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testUserConstructorAndGetters() {
        String userID = "001";
        String userRole = "A";
        String userPassword = "123456";
        User user = new User(userID, userRole, userPassword);
        assertEquals("User ID should match", userID, user.getUserID());
        assertEquals("User Password should match", userPassword, user.getUserPasword());
    }

    @Test
    public void testGetAllBookings_InitiallyEmpty() {
        String userID = "001";
        String userRole = "A";
        String userPassword = "123456";
        User user = new User(userID, userRole, userPassword);
        ArrayList<Booking> bookings = user.getAllBookings();
        assertTrue("Bookings list should be empty initially", bookings.isEmpty());
    }

    @Test
    public void testToString() {
        String userID = "001";
        String userRole = "A";
        String userPassword = "123456";

        User user = new User(userID, userRole, userPassword);
        String userString = user.toString();

        String expectedString = UserRole.getUserRoleByChar(userRole).toString(userID, userPassword);
        assertEquals("toString should return expected string", expectedString, userString);
    }

    @Test
    public void testGetUserByID_Found() {
        ArrayList<User> allUsers = new ArrayList<>();
        User testUser = new User("001", "A", "123456");
        allUsers.add(testUser);
        User foundUser = User.getUserByID(allUsers, "001");
        assertNotNull("User should be found", foundUser);
        assertEquals("Found user ID should match", "001", foundUser.getUserID());
    }

    @Test
    public void testGetUserByID_NotFound() {
        ArrayList<User> allUsers = new ArrayList<>();
        User testUser = new User("001", "A", "123456");
        allUsers.add(testUser);
        User foundUser = User.getUserByID(allUsers, "002");
        assertNull("User should not be found", foundUser);
    }
    
}
    
    
