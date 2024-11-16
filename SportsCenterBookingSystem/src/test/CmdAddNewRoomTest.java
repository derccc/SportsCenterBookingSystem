package test;

import execute.Booking;
import execute.CmdAddNewRoom;
import execute.CmdLogout;
import execute.Main;
import execute.Room;
import execute.SportsCenter;
import execute.User;
import execute.RoomType;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CmdAddNewRoomTest {


	@Test
    public void testExecuteNoRoomTypes() {
        // Arrange
        SportsCenter sportsCenter = SportsCenter.getInstance();
        CmdAddNewRoom cmdAddNewRoom = new CmdAddNewRoom();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Mocking the input for adding a new room type
        String inputString = "badminton 40\n";
        Scanner scanner = new Scanner(inputString);

        // Act
        cmdAddNewRoom.execute(scanner);

        // Assert
        String output = outContent.toString();
        assertTrue("Should contain message about adding a new room type", output.contains("New room type added and 1 new room assigned to the new room type."));

        // Restore standard output
        System.setOut(originalOut);

        // Close the scanner
        scanner.close();
    }
		@Test
	    public void testExecuteAddRoomType() {
	        // Arrange
	        CmdAddNewRoom cmdAddNewRoom = new CmdAddNewRoom();
	        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	        PrintStream originalOut = System.out;
	        System.setOut(new PrintStream(outContent));

	        // Mocking the input for adding a new room type
	        String inputString = "t\nbadminton 40\n";
	        Scanner scanner = new Scanner(inputString);

	        // Act
	        cmdAddNewRoom.execute(scanner);

	        // Assert
	        String output = outContent.toString();
	        assertTrue("Should contain message about adding a new room type", output.contains("New room type added and 1 new room assigned to the new room type."));

	        // Restore standard output
	        System.setOut(originalOut);

	        // Close the scanner
	        scanner.close();
	    }

	    @Test
	    public void testExecuteAddRoomToExistingRoomType() {
	        // Arrange
	        CmdAddNewRoom cmdAddNewRoom = new CmdAddNewRoom();
	        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	        PrintStream originalOut = System.out;
	        System.setOut(new PrintStream(outContent));

	        // Add a room type first
	        RoomType roomType = new RoomType("001", "Badminton", 40);
	        SportsCenter sportsCenter = SportsCenter.getInstance();
	        sportsCenter.addRoomType(roomType);

	        // Mocking the input for adding a room to an existing room type
	        String inputString = "r\n001\n";
	        Scanner scanner = new Scanner(inputString);

	        // Act
	        cmdAddNewRoom.execute(scanner);

	        // Assert
	        String output = outContent.toString();
	        assertTrue("Should contain message about adding a new room to an existing room type", output.contains("1 new room assigned to the room type."));

	        // Restore standard output
	        System.setOut(originalOut);

	        // Close the scanner
	        scanner.close();
	    }

	    @Test
	    public void testExecuteInvalidRoomTypeID() {
	        // Arrange
	        CmdAddNewRoom cmdAddNewRoom = new CmdAddNewRoom();
	        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	        PrintStream originalOut = System.out;
	        System.setOut(new PrintStream(outContent));

	        // Mocking the input for adding a room with an invalid room type ID
	        String inputString = "r\n999\n001\n";
	        Scanner scanner = new Scanner(inputString);

	        // Act
	        cmdAddNewRoom.execute(scanner);

	        // Assert
	        String output = outContent.toString();
	        assertTrue("Should contain message about room type ID not found", output.contains("Room Type ID not found, please input again:"));

	        // Restore standard output
	        System.setOut(originalOut);

	        // Close the scanner
	        scanner.close();
	    }
	}