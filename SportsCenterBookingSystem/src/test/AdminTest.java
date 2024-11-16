
package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;

import execute.Admin;
import execute.Booking;
import execute.Room;
import execute.RoomType;
import execute.SportsCenter;
import execute.User;
import execute.ViewBookingService;

public class AdminTest {

	 @Test
	    public void testShowActionMenu_InputM() {
	        Admin admin = new Admin();
	        InputStream in = new ByteArrayInputStream("m\n".getBytes());
	        System.setIn(in); // 设置输入流
	        Scanner scanner = new Scanner(in); // 创建一个新的Scanner对象
	        assertEquals("m", admin.showActionMenu(scanner)); // 调用方法并断言结果
	        scanner.close(); // 关闭scanner
	    }

	    @Test
	    public void testShowActionMenu_InputV() {
	        Admin admin = new Admin();
	        InputStream in = new ByteArrayInputStream("v\n".getBytes());
	        System.setIn(in);
	        Scanner scanner = new Scanner(in);
	        assertEquals("v", admin.showActionMenu(scanner));
	        scanner.close();
	    }

	    @Test
	    public void testShowActionMenu_InputC() {
	        Admin admin = new Admin();
	        InputStream in = new ByteArrayInputStream("c\n".getBytes());
	        System.setIn(in);
	        Scanner scanner = new Scanner(in);
	        assertEquals("c", admin.showActionMenu(scanner));
	        scanner.close();
	    }

	    @Test
	    public void testShowActionMenu_InputL() {
	        Admin admin = new Admin();
	        InputStream in = new ByteArrayInputStream("l\n".getBytes());
	        System.setIn(in);
	        Scanner scanner = new Scanner(in);
	        assertEquals("l", admin.showActionMenu(scanner));
	        scanner.close();
	    }

	    @Test
	    public void testShowActionMenu_InputD() {
	        Admin admin = new Admin();
	        InputStream in = new ByteArrayInputStream("d\n".getBytes());
	        System.setIn(in);
	        Scanner scanner = new Scanner(in);
	        assertEquals("d", admin.showActionMenu(scanner));
	        scanner.close();
	    }

	    @Test
	    public void testShowActionMenu_InputA() {
	        Admin admin = new Admin();
	        InputStream in = new ByteArrayInputStream("a\n".getBytes());
	        System.setIn(in);
	        Scanner scanner = new Scanner(in);
	        assertEquals("a", admin.showActionMenu(scanner));
	        scanner.close();
	    }

	    @Test
	    public void testShowActionMenu_InputP() {
	        Admin admin = new Admin();
	        InputStream in = new ByteArrayInputStream("p\n".getBytes());
	        System.setIn(in);
	        Scanner scanner = new Scanner(in);
	        assertEquals("p", admin.showActionMenu(scanner));
	        scanner.close();
	    }
	    

	    @Test
	    public void testMakeBooking() {
	        Admin admin = new Admin();
	        SportsCenter sportsCenter = SportsCenter.getInstance();
	        User user = new User("011", "A", "123456");
	        sportsCenter.addUser(user);
	        String input = "011\n1\n241116 12-16\nY\n";
	        InputStream in = new ByteArrayInputStream(input.getBytes());
	        System.setIn(in);
	        boolean result = admin.makeBooking(new Scanner(System.in));
	        Assert.assertEquals(true, result);
	    }
	   
	    @Test
	    public void testViewBooking_AllBookings() {
	        Admin admin = new Admin();
	        SportsCenter sportsCenter = SportsCenter.getInstance();
	        User user = new User("011", "A", "123456");
	        sportsCenter.addUser(user);
	        Room room = new Room("101", new RoomType("Q", "Queen", 800));
	        sportsCenter.addRoom(room);
	        
	        int nextBookingID = sportsCenter.getNextBookingID();
	        Booking booking = new Booking(sportsCenter.getRoomByID("101"), "011", "230101", 10, 12, 100, "N", String.valueOf(nextBookingID));
	        sportsCenter.addBooking(booking);
	        user.addBooking(booking);
	        room.addBooking(booking);
	        
	        String input = "a\ns\n2023 1\nq\n";
	        InputStream in = new ByteArrayInputStream(input.getBytes());
	        System.setIn(in);
	        Scanner scanner = new Scanner(System.in);
	       
	        admin.viewBooking(scanner);
 
	    

	        scanner.close();
	    }

	    @Test
	    public void testViewBooking_SpecificUser() {
	        Admin admin = new Admin();
	        SportsCenter sportsCenter = SportsCenter.getInstance();
	        User user = new User("011", "A", "123456");
	        sportsCenter.addUser(user);
	        Room room = new Room("101", new RoomType("Q", "Queen", 800));
	        sportsCenter.addRoom(room);
	        
	        int nextBookingID = sportsCenter.getNextBookingID();
	        Booking booking = new Booking(sportsCenter.getRoomByID("101"), "011", "230101", 10, 12, 100, "N", String.valueOf(nextBookingID));
	        sportsCenter.addBooking(booking);
	        user.addBooking(booking);
	        room.addBooking(booking);
	        
	        
	        String input = "u\n011\ns\n2023 1\nq\n";
	        InputStream in = new ByteArrayInputStream(input.getBytes());
	        System.setIn(in);
	        Scanner scanner = new Scanner(System.in);

	        admin.viewBooking(scanner);

	        scanner.close();
	    }


	    @Test
	    public void testViewBooking_SpecificRoom() {
	        Admin admin = new Admin();
	        SportsCenter sportsCenter = SportsCenter.getInstance();
	        User user = new User("011", "A", "123456");
	        sportsCenter.addUser(user);
	        Room room = new Room("101", new RoomType("Q", "Queen", 800));
	        sportsCenter.addRoom(room);
	        
	        int nextBookingID = sportsCenter.getNextBookingID();
	        Booking booking = new Booking(sportsCenter.getRoomByID("101"), "011", "230101", 10, 12, 100, "N", String.valueOf(nextBookingID));
	        sportsCenter.addBooking(booking);
	        user.addBooking(booking);
	        room.addBooking(booking);
	        

	        String input = "r\n101\ns\n2023 1\nq\n";
	        InputStream in = new ByteArrayInputStream(input.getBytes());
	        System.setIn(in);
	        Scanner scanner = new Scanner(System.in);

	        admin.viewBooking(scanner);

	        scanner.close();
	    }
	
	    @Test
	    public void testCancelBooking_WithValidUserID() {
	        Admin admin = new Admin();
	        SportsCenter sportsCenter = SportsCenter.getInstance();
	        
	        User user = new User("012", "A", "123456");
	        sportsCenter.addUser(user);
	        
	        Room room = new Room("123", new RoomType("Q", "Queen", 800));
	        sportsCenter.addRoom(room);
	        
	        Booking booking = new Booking(sportsCenter.getRoomByID("123"), "012", "230112", 10, 12, 100, "N", "99");
	        sportsCenter.addBooking(booking);
	        user.addBooking(booking);
	        room.addBooking(booking);
	        
	        String input = "012\n99\nY\n";
	        InputStream in = new ByteArrayInputStream(input.getBytes());
	        System.setIn(in);
	        Scanner scanner = new Scanner(System.in);
	        boolean result = admin.cancelBooking(scanner);
	        Assert.assertFalse(result);

	        scanner.close();
	    }
	    
	  
	    
	    @Test
	    public void testToString() {
	        Admin admin = new Admin();
	        String result = admin.toString("12345", "password123");
	        String expected = "12345 A password123";
	        Assert.assertEquals(expected, result);
	    }

	}

