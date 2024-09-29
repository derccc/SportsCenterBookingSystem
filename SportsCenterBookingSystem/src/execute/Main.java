package execute;

import java.util.ArrayList;
import java.util.Scanner;

import execute.BookingOfDay;

public class Main {
	public static void main(String[] args) {
		ArrayList<BookingOfDay> allBookings = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);
		String action = "";
		
		System.out.println("Please input your action");
		System.out.println("[m] for make booking, [c] for change booking, [r] for remove booking, [v] for view booking, [q] for quit");
		action = scanner.nextLine();
		
		switch (action) {
			case "m":
                System.out.println("Make booking");
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
