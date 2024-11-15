package test;

import execute.CmdLogin;
import execute.Main;
import execute.SportsCenter;
import execute.User;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CmdLoginTest {

    private CmdLogin cmdLogin;
    private SportsCenter sportsCenter;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @Test
    public void testLoginSuccess() {
        // Arrange
        cmdLogin = new CmdLogin();
        sportsCenter = SportsCenter.getInstance();
        User user = new User("001", "A", "123456");
        sportsCenter.addUser(user);
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        String inputString = "001\n123456\n";
        Scanner scanner = new Scanner(inputString);

        cmdLogin.execute(scanner);
        String output = outContent.toString();
        assertTrue("Should contain success message", output.contains("Please input your Password:"));
        assertEquals("The current user should be set", user, Main.getCurrentUser());

        System.setOut(originalOut);
        scanner.close();
    }

    @Test
    public void testLoginFailure_InvalidUserID() {
        cmdLogin = new CmdLogin();
        sportsCenter = SportsCenter.getInstance();
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        String inputString = "999\n123456\n001\n123456\n";
        Scanner scanner = new Scanner(inputString);
        cmdLogin.execute(scanner);
        String output = outContent.toString();
        assertTrue("Should prompt for user ID again", output.contains("User ID not found, please input again:"));
      
        System.setOut(originalOut);

        scanner.close();
    }

    @Test
    public void testLoginFailure_WrongPassword() {
        // Arrange
        cmdLogin = new CmdLogin();
        sportsCenter = SportsCenter.getInstance();
        User user = new User("001", "A", "123456");
        sportsCenter.addUser(user);
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        String inputString = "001\nwrongPassword\n001\n123456\n";
        Scanner scanner = new Scanner(inputString);
        cmdLogin.execute(scanner);

        String output = outContent.toString();
        assertTrue("Should prompt for password again", output.contains("Wrong password, please input again:"));
       
        System.setOut(originalOut);
        scanner.close();
    }
}