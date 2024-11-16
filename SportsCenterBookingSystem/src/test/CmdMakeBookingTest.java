package test;

import execute.CmdMakeBooking;
import execute.Main;
import execute.SportsCenter;
import execute.User;
import execute.Room;
import execute.RoomType;
import execute.Booking;
import execute.Common;
import execute.DateAndTime;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CmdMakeBookingTest {

    @Test
    public void testExecuteMakeBooking_Success() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        SportsCenter sportsCenter = SportsCenter.getInstance();
        User user = new User("001", "A", "123456");
        sportsCenter.addUser(user);
        RoomType roomType = new RoomType("001", "Badminton", 40);
        sportsCenter.addRoomType(roomType);
        Room room = new Room("101", roomType);
        sportsCenter.addRoom(room);

        Main.setCurrentUser(user);

        String inputString = "001\n241001 15-20\n";  
        Scanner scanner = new Scanner(inputString);

        CmdMakeBooking cmdMakeBooking = new CmdMakeBooking();

        // Act
        cmdMakeBooking.execute(scanner);

        // Assert
        String output = outContent.toString();
        assertTrue("Should contain a message indicating the booking was successful.", output.contains("Booking Success."));

        System.setOut(originalOut);
        scanner.close();
    }

    @Test
    public void testExecuteMakeBooking_RoomTypeNotFound() {
        // Arrange
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        SportsCenter sportsCenter = SportsCenter.getInstance();
        User user = new User("001", "A", "123456");
        sportsCenter.addUser(user);
        Main.setCurrentUser(user);

        String inputString = "999\n001\n241001 15-20\n";
        Scanner scanner = new Scanner(inputString);
        CmdMakeBooking cmdMakeBooking = new CmdMakeBooking();
        cmdMakeBooking.execute(scanner);

        String output = outContent.toString();
        assertTrue("Should contain a message indicating the room type ID was not found.", output.contains("Room Type ID not found, please input again:"));

        System.setOut(originalOut);
        scanner.close();
    }

    
}