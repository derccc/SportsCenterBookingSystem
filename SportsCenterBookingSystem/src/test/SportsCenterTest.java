package test;

import execute.SportsCenter;
import execute.User;
import execute.Booking;
import execute.Room;
import execute.RoomType;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class SportsCenterTest {

    @Test
    public void testGetInstance_Singleton() {
        SportsCenter instance1 = SportsCenter.getInstance();
        SportsCenter instance2 = SportsCenter.getInstance();
        assertNotNull("The instance of SportsCenter should not be null", instance1);
        assertSame("The instances should be the same (singleton pattern)", instance1, instance2);
    }

    @Test
    public void testGetInstance_InitCalled() {
        SportsCenter sportsCenter = SportsCenter.getInstance();
        ArrayList<Booking> bookings = sportsCenter.getAllBookings();
        assertNotNull("The bookings list should not be null after init", bookings);
        
    }
    
    @Test
    public void testSportsCenterOperations() {
        SportsCenter sportsCenter = SportsCenter.getInstance();
        String roomTypeID = "001";
        String roomTypeName = "Badminton";
        int roomTypePrice = 800;
        RoomType roomType = new RoomType(roomTypeID, roomTypeName, roomTypePrice);
        sportsCenter.addRoomType(roomType);
        String roomID = "101";
        Room room = new Room(roomID, roomType);
        sportsCenter.addRoom(room);
        String userID = "001";
        String userRole = "A";
        String userPassword = "123456";
        User user = new User(userID, userRole, userPassword);
        sportsCenter.addUser(user);
        String closingDate = "20231212";
        sportsCenter.addClosingDate(closingDate);
        String bookingID = "booking1";
        Booking booking = new Booking(room, userID, "20231201", 10, 12, 100, "N", bookingID);
        sportsCenter.addBooking(booking);

        RoomType retrievedRoomType = sportsCenter.getRoomTypeByID(roomTypeID);
        assertNotNull("RoomType should be found", retrievedRoomType);
        assertEquals("RoomType ID should match", roomTypeID, retrievedRoomType.getTypeID());

        Room retrievedRoom = sportsCenter.getRoomByID(roomID);
        assertNotNull("Room should be found", retrievedRoom);
        assertEquals("Room ID should match", roomID, retrievedRoom.getRoomID());

        User retrievedUser = sportsCenter.getUserByID(userID);
        assertNotNull("User should be found", retrievedUser);
        assertEquals("User ID should match", userID, retrievedUser.getUserID());

        Booking retrievedBooking = sportsCenter.getBookingByID(bookingID);
        assertNotNull("Booking should be found", retrievedBooking);
        assertEquals("Booking ID should match", bookingID, retrievedBooking.getBookingID());

        boolean isClosing = sportsCenter.isClosingDate(closingDate);
        assertTrue("The date should be a closing date", isClosing);

        boolean isNotClosing = sportsCenter.isClosingDate("20231213");
        assertFalse("The date should not be a closing date", isNotClosing);

        boolean isNullClosing = sportsCenter.isClosingDate(null);
        assertFalse("Null date should not be a closing date", isNullClosing);

        boolean isInvalidFormatClosing = sportsCenter.isClosingDate("202312");
        assertFalse("Invalid format date should not be a closing date", isInvalidFormatClosing);
    }
    
    @Test
    public void testAddClosingDate_AffectsBookings() {
    	SportsCenter sportsCenter = SportsCenter.getInstance();
        String roomTypeID = "001";
        String roomTypeName = "Badminton";
        int roomTypePrice = 800;
        RoomType roomType = new RoomType(roomTypeID, roomTypeName, roomTypePrice);
        sportsCenter.addRoomType(roomType);

        String roomID = "101";
        Room room = new Room(roomID, roomType);
        sportsCenter.addRoom(room);

        String userID = "001";
        String userRole = "A";
        String userPassword = "123456";
        User user = new User(userID, userRole, userPassword);
        sportsCenter.addUser(user);

        String closingDate = "20231212";
        String bookingID1 = "booking1";
        Booking booking1 = new Booking(room, userID, closingDate, 10, 12, 100, "N", bookingID1);
        sportsCenter.addBooking(booking1);

        String bookingID2 = "booking2";
        Booking booking2 = new Booking(room, userID, "20231209", 10, 12, 100, "N", bookingID2);
        sportsCenter.addBooking(booking2);
        sportsCenter.addClosingDate(closingDate);
        Booking retrievedBooking1 = sportsCenter.getBookingByID(bookingID1);
    }

    @Test
    public void testAddClosingDate_NoBookingsAffected() {
    	SportsCenter sportsCenter = SportsCenter.getInstance();
        String closingDate = "20231212";
        sportsCenter.addClosingDate(closingDate);
    }

    @Test
    public void testAddClosingDate_MultipleBookingsAffected() {
    	SportsCenter sportsCenter = SportsCenter.getInstance();
        String roomTypeID = "001";
        String roomTypeName = "Badminton";
        int roomTypePrice = 800;
        RoomType roomType = new RoomType(roomTypeID, roomTypeName, roomTypePrice);
       
		sportsCenter.addRoomType(roomType);
        String roomID = "101";
        Room room = new Room(roomID, roomType);
        sportsCenter.addRoom(room);
        String userID = "001";
        String userRole = "A";
        String userPassword = "123456";
        User user = new User(userID, userRole, userPassword);
        sportsCenter.addUser(user);
        String closingDate = "20231212";
        for (int i = 1; i <= 3; i++) {
            String bookingID = "booking" + i;
            Booking booking = new Booking(room, userID, closingDate, 10 + i, 12 + i, 100, "N", bookingID);
            sportsCenter.addBooking(booking);
        }
        sportsCenter.addClosingDate(closingDate);
    }
    
    @Test
    public void testCheckAvailability() {
    	SportsCenter sportsCenter = SportsCenter.getInstance();
        RoomType roomType = new RoomType("001", "Badminton", 800);
        sportsCenter.addRoomType(roomType);

        Room room1 = new Room("101", roomType);
        Room room2 = new Room("102", roomType);
        sportsCenter.addRoom(room1);
        sportsCenter.addRoom(room2);

        Booking booking1 = new Booking(room1, "001", "20231201", 10, 12, 100, "N", "001");
        Booking booking2 = new Booking(room2, "001", "20231201", 14, 16, 100, "N", "002");
        sportsCenter.addBooking(booking1);
        sportsCenter.addBooking(booking2);

        Room availableRoom = sportsCenter.checkAvailability(roomType, "20231201", 13, 15);

    }

    @Test
    public void testIsOverlapping() {
    	SportsCenter sportsCenter = SportsCenter.getInstance();
        ArrayList<Booking> bookings = new ArrayList<>();
        Booking booking1 = new Booking(null, "001", "20231201", 10, 12, 100, "N", "001");
        Booking booking2 = new Booking(null, "001", "20231201", 12, 14, 100, "N", "002");
        bookings.add(booking1);
        bookings.add(booking2);

        // Act & Assert
        assertTrue("Bookings should overlap", sportsCenter.isOverlapping(bookings, 11, 13));
        assertFalse("Bookings should not overlap", sportsCenter.isOverlapping(bookings, 8, 9));
    }

    @Test
    public void testCalculateIdleTime() {
    	SportsCenter sportsCenter = SportsCenter.getInstance();
        ArrayList<Booking> bookings = new ArrayList<>();
        Booking booking1 = new Booking(null, "001", "20231201", 10, 12, 100, "N", "001");
        Booking booking2 = new Booking(null, "001", "20231201", 14, 16, 100, "N", "002");
        bookings.add(booking1);
        bookings.add(booking2);
        int idleTime = sportsCenter.calculateIdleTime(bookings, 13, 15);

    }

    @Test
    public void testGetNextIDs() {
        // Arrange
        SportsCenter sportsCenter = SportsCenter.getInstance();
        sportsCenter.init(); // Initialize with test data

        // Act & Assert
        assertEquals("Next RoomTypeID should be 1", 1, sportsCenter.getNextRoomTypeID());
        assertEquals("Next RoomID should be 1", 1, sportsCenter.getNextRoomID());
        assertEquals("Next BookingID should be 1", 1, sportsCenter.getNextBookingID());
    }
    @Test
    public void testPrintAllRoomType() {
        SportsCenter sportsCenter = SportsCenter.getInstance();
        sportsCenter.init(); 
        sportsCenter.printAllRoomType();
    }
    
    
    @Test
    public void testPrintAllRoomType_MultipleRoomTypes() {
        SportsCenter sportsCenter = SportsCenter.getInstance();
        sportsCenter.init(); 
        RoomType roomType1 = new RoomType("001", "Badminton", 800);
        RoomType roomType2 = new RoomType("002", "Tennis", 1000);
        sportsCenter.addRoomType(roomType1);
        sportsCenter.addRoomType(roomType2);
        sportsCenter.printAllRoomType();
    }

    @Test
    public void testPrintAllRoomType_NoRoomTypes() {
        // Arrange
        SportsCenter sportsCenter = SportsCenter.getInstance();
        sportsCenter.printAllRoomType();
    }

    
    
    

 
   
    @Test
    public void testPrintAllRoomType_WhenNotEmpty() {
    	SportsCenter sportsCenter = SportsCenter.getInstance();
        RoomType roomType1 = new RoomType("001", "Badminton", 800);
        RoomType roomType2 = new RoomType("002", "Tennis", 1000);
        sportsCenter.addRoomType(roomType1);
        sportsCenter.addRoomType(roomType2);
        sportsCenter.printAllRoomType();
    }

    @Test
    public void testPrintAllRoomType_WhenEmpty() {
    	SportsCenter sportsCenter = SportsCenter.getInstance();
        sportsCenter.printAllRoomType();
    }

    @Test
    public void testPrintAllClosingDate_WhenNotEmpty() {
    	SportsCenter sportsCenter = SportsCenter.getInstance();
        sportsCenter.addClosingDate("20231212");
        sportsCenter.addClosingDate("20231213");
        sportsCenter.printAllClosingDate();
    }

    @Test
    public void testPrintAllClosingDate_WhenEmpty() {
    	SportsCenter sportsCenter = SportsCenter.getInstance();
        sportsCenter.printAllClosingDate();
    }
}

    
    
    
    
    
    
    
    
    
    
    
