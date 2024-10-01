package execute;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import execute.BookingsForDay;

public class Main {
	public static void main(String[] args) {

		ArrayList<Area> allAreas = getBookingsFromFile();
		
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

	public static ArrayList<Area> getBookingsFromFile() {
		ArrayList<Area> areas = new ArrayList<>();
		// Read from file
		try {
			File file = new File("src/execute/assets/booking_data");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				String[] bookingData = data.split(" ");
				Booking booking = new Booking(bookingData[0], bookingData[1], bookingData[2], Integer.parseInt(bookingData[3]), Integer.parseInt(bookingData[4]), bookingData[5]);
				if (getAreaByID(booking.getAreaID(), areas) == null) {
					Area area = new Area(booking.getAreaID());
					area.addBooking(booking);
					areas.add(area);
				} else {
					getAreaByID(booking.getAreaID(), areas).addBooking(booking);
				}
				
			}
			scanner.close();
		
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return areas;
	}
	
	public static Area getAreaByID(String areaID, ArrayList<Area> allAreas) {
		for (Area a : allAreas) {
			if (a.getAreaID().equals(areaID)) {
				return a;
			}
		}
		return null;
	}
}
