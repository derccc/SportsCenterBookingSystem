package execute;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SportsCenter {
	private ArrayList<RoomType> allRoomTypes;
	private ArrayList<Room> allRooms;
    private ArrayList<User> allUsers;
    private ArrayList<Booking> allBookings;
    private static SportsCenter INSTANCE;
    
	private SportsCenter() {
		this.allRoomTypes = new ArrayList<>();
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
		String roomTypePath = "src/execute/assets/room_type.txt";
		String roomPath = "src/execute/assets/room_data.txt";
		String userPath = "src/execute/assets/user_data.txt";
		String bookingPath = "src/execute/assets/booking_data.txt";
		
		loadRoomType(roomTypePath);
		loadRoom(roomPath);
		loadUser(userPath);
		loadBooking(bookingPath);
		
	}

	//TODO: handle wrong data input (wrong data type/missing info etc)? use exception?
	//check array size 
	//check numeric for int attribute
	//exception for can't find room/room type

	private void loadRoomType(String path) {
		try{
			File file = new File(path);
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()){
				String data = scanner.nextLine();
				String[] splittedData = data.split(" ");
				//format: TypeID Type Price
				RoomType roomType = new RoomType(splittedData[0], splittedData[1], Integer.parseInt(splittedData[2]));
				allRoomTypes.add(roomType);
			}
			
			System.out.println("Finished loading room types.");
			scanner.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot find file at path: "+path);
		}
		
	}

	private void loadRoom(String path) {
		try{
			File file = new File(path);
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()){
				String data = scanner.nextLine();
				String[] splittedData = data.split(" ");
				//format: roomID roomTypeID
				
				//find roomType by id (pass back to class RoomType)
				RoomType roomType = getRoomTypeByID(splittedData[1]);
				if(roomType != null){
					Room room = new Room(splittedData[0], roomType);
					allRooms.add(room);
				} else{
					System.out.println("Cannot find room type: "+splittedData[1]);
				}
			}

			System.out.println("Finished loading rooms.");
			scanner.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot find file at path: "+path);
		}
		
    }
  
  	private void loadUser(String path) {
		try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()){
                String data = scanner.nextLine();
                String[] splittedData = data.split(" ");
                //format: userID, userRole, userPassword
                User user = new User(splittedData[0], splittedData[1], splittedData[2]);
                allUsers.add(user);
            }
            
            System.out.println("Finished loading users.");
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file at path: "+path);
        }
		
	}

	private void loadBooking(String path) {
		try{
			File file = new File(path);
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()){
				String data = scanner.nextLine();
				String[] splittedData = data.split(" ");
				//format: RoomID UserID YYMMDD StartingTime EndingTime BookingID
				
				//find room by id (pass back to class RoomType)
				Room room = getRoomByID(splittedData[0]);
				User user = getUserByID(splittedData[1]);

				//TODO: invalid date time exception
				if (room != null && user != null) {
					Booking booking = new Booking(splittedData[0], splittedData[1], splittedData[2], Integer.parseInt(splittedData[3]), Integer.parseInt(splittedData[4]), Integer.parseInt(splittedData[5]), splittedData[6], splittedData[7]);
					room.addBooking(booking);
					user.addBooking(booking);
					allBookings.add(booking);
					
				} else if (room == null) {
					System.out.println("Cannot find room: "+splittedData[0]);
					
				} else if (user == null) {
					System.out.println("Cannot find user: "+splittedData[1]);
				}
			}

			System.out.println("Finished loading bookings.");
			scanner.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot find file at path: "+path);
		}
		
	}

	public RoomType getRoomTypeByID(String roomTypeID) {
		return RoomType.getRoomTypeByID(allRoomTypes, roomTypeID);
	}

	public Room getRoomByID(String roomID) {
		return Room.getRoomByID(allRooms, roomID);
	}

	public User getUserByID(String userID){ 
        return User.getUserByID(allUsers, userID);
    }
	
	public Booking getBookingByID(String bookingID) {
		return Booking.getBookingByID(allBookings, bookingID);
	}

	public void addUser(User user){
		allUsers.add(user);
		String userPath = "src/execute/assets/user_data.txt";
		try {
			File file = new File(userPath);
			FileWriter fileWriter = new FileWriter(file, true);
			fileWriter.write(user.toString() + "\n");
			fileWriter.close();
			
		} catch (IOException e) {
			System.out.println("IO error");
		}
	}
	
	public void addBooking(Booking booking) {
		allBookings.add(booking);
		String bookingPath = "src/execute/assets/booking_data.txt";
		try {
			File file = new File(bookingPath);
			FileWriter fileWriter = new FileWriter(file, true);
			fileWriter.write(booking.toString() + "\n");
			fileWriter.close();

		} catch (IOException e) {
			System.out.println("IO error");
		}
	}
	
	public void removeBooking(Booking booking) {
		//allBookings.remove(booking);
		//TODO: change N to Y in booking.txt
		String bookingPath = "src/execute/assets/booking_data.txt";
		
	}

	public Room checkAvailability(RoomType roomType, String date, int startTime, int endTime) {
		
		//TODO: if room available, return room, else return null
		ArrayList<Booking> bookingForDay = Booking.getBoookingsOfSpecificDate(allBookings, date);
		
		if (bookingForDay.isEmpty()) {
			for (Room r:allRooms){
                if(r.getRoomType().getType().equals(roomType.getType())){
                    return r;
                }
            }
		}
		
		
		Map<String, ArrayList<Booking>> bookingOfRoomsForDay = new HashMap<String, ArrayList<Booking>>();
		for (Booking b: bookingForDay) {
			String roomID = b.getRoomID();
			if(Room.getRoomByID(allRooms, roomID).getRoomType().getType().equals(roomType.getType())) {
				if (bookingOfRoomsForDay.containsKey(roomID)) {
					bookingOfRoomsForDay.get(roomID).add(b);
				} else {
					ArrayList<Booking> bookingList = new ArrayList<>();
					bookingList.add(b);
					bookingOfRoomsForDay.put(roomID, bookingList);	
				}
			};
			
		}
		
	    Room bestRoom = null;
	    int minIdleTime = Integer.MAX_VALUE;

	    for (Map.Entry<String, ArrayList<Booking>> entry : bookingOfRoomsForDay.entrySet()) {
	        String roomID = entry.getKey();
	        ArrayList<Booking> bookings = entry.getValue();

	        if (!isOverlapping(bookings, startTime, endTime)) {
	            int idleTime = calculateIdleTime(bookings, startTime, endTime);

	            if (idleTime < minIdleTime) {
	                minIdleTime = idleTime;
	                bestRoom = Room.getRoomByID(allRooms, roomID);
	            }
	        }
	    }
	    

	    return bestRoom;
	}
	
	public boolean isOverlapping(ArrayList<Booking> bookings, int startTime, int endTime) {
	    for (Booking booking : bookings) {
	        if (startTime < booking.getEndTime() && endTime > booking.getStartTime()) {
	            return true;
	        }
	    }
	    return false;
	}

	public int calculateIdleTime(ArrayList<Booking> bookings, int startTime, int endTime) {
	    int idleTime = 0;
	    bookings.sort(Comparator.comparingInt(Booking::getStartTime));

	    int previousEndTime = 0;
	    for (Booking booking : bookings) {
	        idleTime += booking.getStartTime() - previousEndTime;
	        previousEndTime = booking.getEndTime();
	    }

	    idleTime += startTime - previousEndTime;
	    idleTime += 24 * 60 - endTime;

	    return idleTime;
	}

	
	public int getNextBookingID() {
		return allBookings.size() + 1;
	}
	
	public void printAllRoomType (){
		for(RoomType r: allRoomTypes){
			System.out.println(r.printAllRoomTypeString());
		}
	}

	
}
