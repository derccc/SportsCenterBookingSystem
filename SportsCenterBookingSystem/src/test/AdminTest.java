package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import execute.Admin;
import execute.Booking;
import execute.Room;
import execute.RoomType;
import execute.SportsCenter;
import execute.User;
import execute.ViewBookingService;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class AdminTest {
	
	
	
	 @Test
	    public void testShowActionMenu_InputM() {
	        Admin admin = new Admin();
	        InputStream in = new ByteArrayInputStream("m\n".getBytes());
	        System.setIn(in); 
	        Scanner scanner = new Scanner(System.in);
	        assertEquals("m", admin.showActionMenu(scanner));
	    }

	    @Test
	    public void testShowActionMenu_InputV() {
	        Admin admin = new Admin();
	        InputStream in = new ByteArrayInputStream("v\n".getBytes());
	        System.setIn(in); 
	        Scanner scanner = new Scanner(System.in);
	        assertEquals("v", admin.showActionMenu(scanner));
	    }

	    @Test
	    public void testShowActionMenu_InputC() {
	        Admin admin = new Admin();
	        InputStream in = new ByteArrayInputStream("c\n".getBytes());
	        System.setIn(in); 
	        Scanner scanner = new Scanner(System.in);
	        assertEquals("c", admin.showActionMenu(scanner));
	    }
	    //do not know exception yet,maybe write the 4th test for exception?
	    
	    @Test
	    public void testMakeBooking_Valid() {
	    	Admin admin = new Admin();
	        SportsCenter sportsCenter = SportsCenter.getInstance();
	        User user = new User("001", "A", "123456");
	        sportsCenter.addUser(user);

	        String input = "001\n1\n201129 13-15\nY\n"; 
	        InputStream in = new ByteArrayInputStream(input.getBytes());
	        System.setIn(in); 
	        Scanner scanner = new Scanner(System.in);
	        boolean result = admin.makeBooking(scanner);

	        Assert.assertEquals(true, result);

	    }
	    
	    
	    @Test
	    public void testMakeBooking_Null() {
	    	Admin admin = new Admin();
	        SportsCenter sportsCenter = SportsCenter.getInstance();
	        User user = new User("001", "A", "123456");
	        sportsCenter.addUser(user);

	        String input = "002\n001\n1\n201129 13-15\nN\n"; 
	        InputStream in = new ByteArrayInputStream(input.getBytes());
	        System.setIn(in); 
	        Scanner scanner = new Scanner(System.in);
	        boolean result = admin.makeBooking(scanner);

	        Assert.assertEquals(false, result);
	        }
	        
	    
	    @Test
	    public void testViewBooking_AllBookings() {
	        // 设置测试环境
	        SportsCenter sportsCenter = SportsCenter.getInstance();
	        sportsCenter.addUser(new User("001", "A", "123456")); // 添加用户以确保有预订可查看
	        sportsCenter.addBooking(new Booking(new Room("101", new RoomType("001", "Badminton", 10)), "001", "20240520", 10, 12, 100, "N", "BK001"));

	        // 模拟用户输入选择查看所有预订
	        String input = "a\n";
	        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
	        System.setIn(inContent);

	        // 调用viewBooking方法
	        Admin admin = new Admin();
	        ViewBookingService viewBookingService = new ViewBookingService();
	        Scanner scanner = new Scanner(System.in);
	        admin.viewBooking(scanner);

	        // 验证输出
	        String expectedOutput = "Today is: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH)) + "\n";
	        
	    }
	    
	}
	    
	    
	    
	    
	
	    
