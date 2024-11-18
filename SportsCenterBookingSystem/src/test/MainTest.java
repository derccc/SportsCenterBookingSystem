package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import execute.Admin;
import execute.Booking;
import execute.CmdAddNewRoom;
import execute.Main;
import execute.NormalUser;
import execute.Room;
import execute.RoomType;
import execute.SportsCenter;
import execute.User;
import execute.UserSessionManager;

public class MainTest {
	
	
	@Test
	public void testRegist() {
		Random random = new Random();
        int randomUserId = 1 + random.nextInt(999); 
        String randomUserIdStr = Integer.toString(randomUserId); 
        String input = "r\ninvalid\nA\n001\n" + randomUserIdStr + "\n123456\n123457\n123456\nl\ne\n";

	    Scanner testScanner = new Scanner(input); 
	    Main.scanner = testScanner; 
        
        Main.main(new String[]{});

        Main.scanner.close();

        testScanner.close();
	}
//	@Test
//	public void testOtherFunction() {
//	    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//	    PrintStream originalOut = System.out;
//	    
//	    Scanner testScanner = new Scanner("invalid\nl\n23543\n001\n12345678\n123456\nj\nm\n9876\n002\n9\n1\n241001 15-25\n20241003 15-20\n241001 15-20\nN"
//		+ "\nv\na\np\nn\ns\n2024 13\n2024 1\nt\nq\nv\nr\n1234\n1\nq\nv\nr\n1234\n1\nq\nc\n001\n7\n6\nN\nc\n001\n7\n1\nN\nd\ninvalid\n2410011\n241011\na"
//		+ "\nt\ninvalid\nvolleyball 40\np\n1\n20\nN\nl\ne"
//		+ ""
//		
//		 
//		+ "");
//	    Main.scanner = testScanner; 
//
//	    Main.main(new String[]{});
//	    Main.scanner.close();
//	}	
//	@Test
//	public void testUserFunction() {
//	    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//	    PrintStream originalOut = System.out;
//
//	    Scanner testScanner = new Scanner("l\n1234\n002\nded\n123456\nb\nm\nb\n3\n241001 15-20\nN\nm\n3\n241002 15-20\nY\nv\nq\nc\n44\n1\nN\nc\n1\nY\nl\ne"
//	    		 
//	    		+ ""); 
//	    Main.scanner = testScanner; 
//
//	    Main.main(new String[]{});
//	    Main.scanner.close();
//	}	
	
}