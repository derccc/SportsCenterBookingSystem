package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import execute.Booking;
import execute.Main;
import execute.NormalUser;
import execute.Room;
import execute.RoomType;
import execute.SportsCenter;
import execute.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class NormalUserTest {
	
	
	@Test
    public void testShowActionMenu() {
        NormalUser normalUser = new NormalUser();
        Scanner scanner = new Scanner(new ByteArrayInputStream("m\n".getBytes()));
        String action = normalUser.showActionMenu(scanner);
        assertEquals("m", action);
        scanner.close();
    }

	@Test
    public void testMakeBooking() {
        SportsCenter sportsCenter = SportsCenter.getInstance();
        sportsCenter.addUser(new User("001", "A", "123456"));
        Room room = new Room("101", new RoomType("Q", "Queen", 800));
        sportsCenter.addRoom(room);
        NormalUser normalUser = new NormalUser();
        Main.setCurrentUser(new User("001", "A", "123456"));
        String input = "Q\n20230101 10-12\nY\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        normalUser.makeBooking(new Scanner(System.in));
    }
 
	@Test
    public void tesViewBooking_valid() {
        SportsCenter sportsCenter = SportsCenter.getInstance();
        sportsCenter.addUser(new User("001", "A", "123456"));
        Room room = new Room("101", new RoomType("Q", "Queen", 800));
        sportsCenter.addRoom(room);
        NormalUser normalUser = new NormalUser();
        User user=new User("001", "A", "123456");
        Main.setCurrentUser(user);
        Booking booking = new Booking(room, "001", "20230101", 10, 12, 100, "N", "001");
        user.addBooking(booking);
        String input = "q\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        normalUser.viewBooking(new Scanner(System.in));
    }
	@Test
    public void tesViewBooking_null() {
        SportsCenter sportsCenter = SportsCenter.getInstance();
        sportsCenter.addUser(new User("001", "A", "123456"));
        Room room = new Room("101", new RoomType("Q", "Queen", 800));
        sportsCenter.addRoom(room);
        NormalUser normalUser = new NormalUser();
        User user=new User("001", "A", "123456");
        Main.setCurrentUser(user);
        Booking booking = new Booking(room, "001", "20230101", 10, 12, 100, "N", "001");
        String input = "q\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        normalUser.viewBooking(new Scanner(System.in));
    }
	
	@Test
    public void tesCancelBooking_valid() {
        SportsCenter sportsCenter = SportsCenter.getInstance();
        sportsCenter.addUser(new User("001", "A", "123456"));
        Room room = new Room("101", new RoomType("Q", "Queen", 800));
        sportsCenter.addRoom(room);
        NormalUser normalUser = new NormalUser();
        User user=new User("001", "A", "123456");
        Main.setCurrentUser(user);
        Booking booking = new Booking(room, "001", "20230101", 10, 12, 100, "N", "001");
        user.addBooking(booking);
        String input = "Y\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        normalUser.cancelBooking(new Scanner(System.in));
    }
	
	
	

	 @Test
	    public void testToString() {
	        NormalUser normalUser = new NormalUser();
	        String result = normalUser.toString("001", "123456");
	        assertEquals("001 N 123456", result);
	    }
	}