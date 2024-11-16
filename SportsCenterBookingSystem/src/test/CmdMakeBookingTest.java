
package test;

import execute.CmdMakeBooking;
import execute.Main;
import execute.SportsCenter;
import execute.User;
import execute.UserSessionManager;
import execute.Room;
import execute.RoomType;
import execute.Booking;
import execute.CmdCancelBooking;
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
    	   	User user = new User("001", "A", "123456");
	        UserSessionManager.getInstance().setCurrentUser(user);
	        String inputString = "001\n1\n241001 15-20\nN";
	        Scanner scanner = new Scanner(inputString);

	        CmdMakeBooking CmdMakeBooking = new CmdMakeBooking();
	        CmdMakeBooking.execute(scanner);
    }
    @Test
    public void testExecuteMakeBooking_InvalidRoom() {
    	   	User user = new User("001", "A", "123456");
	        UserSessionManager.getInstance().setCurrentUser(user);
	        String inputString = "001\n6\n1\n241001 15-20\nN";
	        Scanner scanner = new Scanner(inputString);

	        CmdMakeBooking CmdMakeBooking = new CmdMakeBooking();
	        CmdMakeBooking.execute(scanner);
    }
    @Test
    public void testExecuteMakeBooking_InvalidDate() {
    	   	User user = new User("001", "A", "123456");
	        UserSessionManager.getInstance().setCurrentUser(user);
	        String inputString = "001\n1\nn241003 15-20\n241001 15-20\nN";
	        Scanner scanner = new Scanner(inputString);

	        CmdMakeBooking CmdMakeBooking = new CmdMakeBooking();
	        CmdMakeBooking.execute(scanner);
    }




}