package execute;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SportsCenter {
    private static SportsCenter INSTANCE;
    private ArrayList<Room> allRooms;
    private ArrayList<User> allUsers;
    private ArrayList<RoomType> allRoomTypes;
    
	private SportsCenter() {
		this.allRooms = new ArrayList<>();
		this.allUsers = new ArrayList<>();
		this.allRoomTypes = new ArrayList<>();
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
		//TODO: load from room txt 
		try {
			File file = new File("src/execute/assets/booking_data");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				String[] bookingData = data.split(" ");
				Booking booking = new Booking(bookingData[0], bookingData[1], bookingData[2], Integer.parseInt(bookingData[3]), Integer.parseInt(bookingData[4]), bookingData[5]);
				if (getRoomByID(booking.getRoomID()) == null) {  //TODO: move out of the if-condition
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
	}
	
	public Room getRoomByID(String roomID) {
		for (Room a : allRooms) {
			if (a.getRoomID().equals(roomID)) {
				return a;
			}
		}
		return null;
	}
}
