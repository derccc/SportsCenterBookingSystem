package execute;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import execute.BookingsForDay;

public class Main {
	public static void main(String[] args) {
		
		SportsCenter sportsCenter = SportsCenter.getInstance();
		
		Scanner scanner = new Scanner(System.in);
		String action = "";
		
		System.out.println("Welcome to the booking system");
		System.out.println("Please input your user ID:");
		String userID = scanner.nextLine();
		
		System.out.println("Please input your action");
		System.out.println("[m] for make booking, [c] for change booking, [r] for remove booking, [v] for view booking, [q] for quit");
		action = scanner.nextLine();
		
		switch (action) {
			case "m":
                System.out.println("Please input the date of booking (yyyymmdd):");
                String date = scanner.nextLine();
                System.out.println("Please input the starting time of booking (hh):");
                int startTime = scanner.nextInt();
                System.out.println("Please input the ending time of booking (hh):");
                int endTime = scanner.nextInt();
                
                
                break;
            case "c":
				System.out.println("Change booking");
				break;
			case "r":
				System.out.println("Remove booking");
				break;
			case "v":
				System.out.println("View booking");
				break;
			case "q":
				System.out.println("Quit");
				break;
		}
	}

}
