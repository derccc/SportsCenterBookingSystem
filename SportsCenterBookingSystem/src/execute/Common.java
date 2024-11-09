package execute;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Common {
	
	
	public static String getValidInput(Scanner scanner, String[] validCommands, String promptMessage) {
        String input;
        while (true) {
            System.out.println(promptMessage);
            input = scanner.nextLine().trim();
            // Check if the input matches any of the valid commands
            for (String validCommand : validCommands) {
                if (input.equalsIgnoreCase(validCommand)) {
                    return input;
                }
            }
            System.out.println("Invalid command, please input again.");
        }
    }
	
	public static String formatDate(String orginalDate) {
		int year= Integer.parseInt("20"+orginalDate.substring(0, 2));
		int month = Integer.parseInt(orginalDate.substring(2, 4));
		int day = Integer.parseInt(orginalDate.substring(4, 6));
		
		LocalDate localdate = LocalDate.of(year, month, day);
		
		return localdate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy",Locale.ENGLISH));
		
	}
}
