package execute;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SportsCenter {
	private ArrayList<Room> allRooms;
    private ArrayList<User> allUsers;
    private ArrayList<Booking> allBookings;
    private static SportsCenter INSTANCE;
    
    
	private SportsCenter() {
		this.allRooms = new ArrayList<>();
		this.allUsers = new ArrayList<>();
        this.allBookings = new ArrayList<>();
	}
    
    public static SportsCenter getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SportsCenter();
            INSTANCE.init();
        }
        return INSTANCE;
    }
    
	public void init() {
		// Load all rooms from file
		// Read from file
		
		try {
			
			File file = new File("src/execute/assets/booking_data");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				String[] bookingData = data.split(" ");
				Booking booking = new Booking(bookingData[0], bookingData[1], bookingData[2], Integer.parseInt(bookingData[3]), Integer.parseInt(bookingData[4]), bookingData[5]);
				if (getRoomByID(booking.getRoomID()) == null) {
					Room area = new Room(booking.getRoomID());
					area.addBooking(booking);
					allRooms.add(area);
				} else {
					getRoomByID(booking.getRoomID()).addBooking(booking);
				}
				
			}
			scanner.close();
		
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		
		try {
            File file = new File("./assets/User.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String data = scanner.nextLine();
                String[] splittedData = data.split(" ");
                User user = new User(splittedData[0], splittedData[1], splittedData[2]);
                allUsers.add(user);
                
                
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("User File Not Found.");
            e.printStackTrace();
        }
		/*

        try {
            File file = new File("src/execute/assets/booking_data");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String data = scanner.nextLine();
                String[] splittedData = data.split(" ");
                Booking booking = new Booking(splittedData[0], splittedData[1], splittedData[2], Integer.parseInt(splittedData[3]), Integer.parseInt(splittedData[4]), splittedData[5]);
                allBookings.add(booking);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Booking File Not Found.");
            e.printStackTrace();
        }
        */
	}
	
	public Room getRoomByID(String roomID) {
		for (Room a : allRooms) {
			if (a.getRoomID().equals(roomID)) {
				return a;
			}
		}
		return null;
	}
	
	public User getUserByUserID(String userID){
        for (User u: allUsers){
            if (u.getUserID().equals(userID)){
                return u;
            }
        }
        return null;
    }

    public ArrayList<Booking> getAllBookings() {
        return this.allBookings;
    }
	
}
