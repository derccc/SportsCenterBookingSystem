package test;

import execute.CmdMarkClosingDate;
import execute.Common;
import execute.SportsCenter;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CmdMarkClosingDateTest {

    @Test
    public void testExecuteMarkClosingDate() {
        // Arrange
        CmdMarkClosingDate cmdMarkClosingDate = new CmdMarkClosingDate();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Mocking the input for marking a closing date
        String inputString = "241001\nY\n";
        Scanner scanner = new Scanner(inputString);

        // Act
        cmdMarkClosingDate.execute(scanner);

        // Assert
        String output = outContent.toString();
        assertTrue("Should contain confirmation message", output.contains("The date you would like to mark as closing date is 241001, are you confirmed to mark? (Y/N):"));

        // Restore standard output
        System.setOut(originalOut);

        // Close the scanner
        scanner.close();
    }

    @Test
    public void testExecuteAlreadyMarkedClosingDate() {
        // Arrange
        CmdMarkClosingDate cmdMarkClosingDate = new CmdMarkClosingDate();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Add a closing date first
        SportsCenter sportsCenter = SportsCenter.getInstance();
        sportsCenter.addClosingDate("241001");

        // Mocking the input for marking an already marked closing date
        String inputString = "241001\n";
        Scanner scanner = new Scanner(inputString);

        // Act
        cmdMarkClosingDate.execute(scanner);

        // Assert
        String output = outContent.toString();
        assertTrue("Should contain already marked message", output.contains("The date was already marked as closing date."));

        // Restore standard output
        System.setOut(originalOut);

        // Close the scanner
        scanner.close();
    }
}