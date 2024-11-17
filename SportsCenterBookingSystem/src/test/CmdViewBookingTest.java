package test;

import execute.SportsCenter;
import execute.User;
import execute.UserSessionManager;
import execute.Booking;
import execute.Room;
import execute.RoomType;
import execute.CmdViewBooking;
import execute.Main;

import java.io.StringReader;
import java.util.Scanner;

import org.junit.Test;
import static org.junit.Assert.*;

public class CmdViewBookingTest {

	 @Test
	    public void testViewBooking_allUserBooking() {
	        SportsCenter sportsCenter = SportsCenter.getInstance();
	        User user = new User("001", "A", "123456");
	        sportsCenter.addUser(user);
	        UserSessionManager.getInstance().setCurrentUser(user); 
	        String input = "a\nq\n"; 
	        StringReader stringReader = new StringReader(input);
	        Scanner scanner = new Scanner(stringReader);
	        CmdViewBooking command = new CmdViewBooking();
	        command.execute(scanner);
	    }
	 @Test
	    public void testViewBooking_specificUserBooking() {
	        SportsCenter sportsCenter = SportsCenter.getInstance();
	        User user = new User("001", "A", "123456");
	        sportsCenter.addUser(user);
	        UserSessionManager.getInstance().setCurrentUser(user); 
	        String input = "u\na\n001\nq\n"; 
	        StringReader stringReader = new StringReader(input);
	        Scanner scanner = new Scanner(stringReader);
	        CmdViewBooking command = new CmdViewBooking();
	        command.execute(scanner);
	    }
	 @Test
	    public void testViewBooking_roomBooking() {
	        SportsCenter sportsCenter = SportsCenter.getInstance();
	        User user = new User("001", "A", "123456");
	        sportsCenter.addUser(user);
	        UserSessionManager.getInstance().setCurrentUser(user); 
	        String input = "r\na\n1\nq\n"; 
	        StringReader stringReader = new StringReader(input);
	        Scanner scanner = new Scanner(stringReader);
	        CmdViewBooking command = new CmdViewBooking();
	        command.execute(scanner);
	    }

	 @Test
	    public void testViewBooking_previousMonth() {
	        SportsCenter sportsCenter = SportsCenter.getInstance();
	        User user = new User("001", "A", "123456");
	        sportsCenter.addUser(user);
	        UserSessionManager.getInstance().setCurrentUser(user); 
	        String input = "a\np\nq\n"; 
	        StringReader stringReader = new StringReader(input);
	        Scanner scanner = new Scanner(stringReader);
	        CmdViewBooking command = new CmdViewBooking();
	        command.execute(scanner);
	    }
	 @Test
	    public void testViewBooking_nextMonth() {
	        SportsCenter sportsCenter = SportsCenter.getInstance();
	        User user = new User("001", "A", "123456");
	        sportsCenter.addUser(user);
	        UserSessionManager.getInstance().setCurrentUser(user); 
	        String input = "a\nn\nq\n"; 
	        StringReader stringReader = new StringReader(input);
	        Scanner scanner = new Scanner(stringReader);
	        CmdViewBooking command = new CmdViewBooking();
	        command.execute(scanner);
	    }
	 @Test
	    public void testViewBooking_specificDate() {
	        SportsCenter sportsCenter = SportsCenter.getInstance();
	        User user = new User("001", "A", "123456");
	        sportsCenter.addUser(user);
	        UserSessionManager.getInstance().setCurrentUser(user); 
	        String input = "a\nf\ns\n2024 13\n2024 1\n1\nq\n"; 
	        StringReader stringReader = new StringReader(input);
	        Scanner scanner = new Scanner(stringReader);
	        CmdViewBooking command = new CmdViewBooking();
	        command.execute(scanner);
	    }
	 @Test
	    public void testViewBooking_jumpToday() {
	        SportsCenter sportsCenter = SportsCenter.getInstance();
	        User user = new User("001", "A", "123456");
	        sportsCenter.addUser(user);
	        UserSessionManager.getInstance().setCurrentUser(user); 
	        String input = "a\nt\nq\n"; 
	        StringReader stringReader = new StringReader(input);
	        Scanner scanner = new Scanner(stringReader);
	        CmdViewBooking command = new CmdViewBooking();
	        command.execute(scanner);
	    }
   
}