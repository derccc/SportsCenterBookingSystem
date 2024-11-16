package test;

import execute.CmdCancelBooking;
import execute.Main;
import execute.SportsCenter;
import execute.User;
import execute.UserSessionManager;
import execute.Room;
import execute.RoomType;
import execute.Booking;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CmdCancelBookingTest {

    @Test
    public void testExecuteCancelBooking() {
        // Arrange
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        SportsCenter sportsCenter = SportsCenter.getInstance();
        User user = new User("001", "A", "123456");
        sportsCenter.addUser(user);
        Room room = new Room("101", new RoomType("B", "bedminton", 800));
        sportsCenter.addRoom(room);
        Booking booking = new Booking(room, "001", "20230101", 10, 12, 100, "N", "001");
        sportsCenter.addBooking(booking);
        UserSessionManager session = UserSessionManager.getInstance();
        session.setCurrentUser(user);
        String inputString = "001\n";
        Scanner scanner = new Scanner(inputString);

        CmdCancelBooking cmdCancelBooking = new CmdCancelBooking();
        cmdCancelBooking.execute(scanner);

        String output = outContent.toString();
    }

    @Test
    public void testExecuteCancelBooking_BookingDoesNotExist() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        SportsCenter sportsCenter = SportsCenter.getInstance();
        User user = new User("001", "A", "123456");
        sportsCenter.addUser(user);
        UserSessionManager session = UserSessionManager.getInstance();
        session.setCurrentUser(user);
        String inputString = "999\n001\n";
        Scanner scanner = new Scanner(inputString);
        CmdCancelBooking cmdCancelBooking = new CmdCancelBooking();

        // Act
        cmdCancelBooking.execute(scanner);

        // Assert
        String output = outContent.toString();
    }
}