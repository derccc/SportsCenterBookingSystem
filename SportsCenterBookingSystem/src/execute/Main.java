package execute;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import execute.BookingOfDay;

public class Main {
	public static void main(String[] args) {
		ArrayList<BookingOfDay> allBookings = new ArrayList<>();
		allBookings = getBookingsFromFile();
		
		Scanner scanner = new Scanner(System.in);
		String action = "";
		
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

	public static ArrayList<BookingOfDay> getBookingsFromFile() {
		ArrayList<BookingOfDay> bookings = new ArrayList<>();
		// Read from file
		try {
			File file = new File("./assets/booking_data.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				String[] bookingData = data.split(" ");
				String date = bookingData[2];
				
				//????
				BookingOfDay bookingOfDay = new BookingOfDay(date);
				
				
				
				String bookingID = bookingData[5];
				int startTime = Integer.parseInt(bookingData[3]);
				int endTime = Integer.parseInt(bookingData[4]);
				Booking booking = new Booking(bookingID, startTime, endTime);
				bookingOfDay.addBooking(booking);
			}
			scanner.close();
		
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return bookings;
	}
}
