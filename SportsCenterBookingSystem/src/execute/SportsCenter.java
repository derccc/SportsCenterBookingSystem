package execute;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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


	private void loadRoomType (String path) {
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

			System.out.println("Finished loading room types.");  //delete after finish coding?

			scanner.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot find file at path: "+path);
		}
		
	}

  private void loadRoom (String path) {
		try{

			File file = new File(path);
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()){
				String data = scanner.nextLine();
				String[] splittedData = data.split(" ");
				//format: roomID roomTypeID
				
				//find roomType by id (pass back to class RoomType)
				RoomType roomType = getRoomTypeByID(splittedData[1]);

				Room room = null;
				if(roomType != null){
					room = new Room(splittedData[0], roomType);
				}
				else{
					System.out.println("Cannot find room type: "+splittedData[1]);
				}
				

				allRooms.add(room);

			}

			System.out.println("Finished loading rooms."); //delete after finish coding?

			scanner.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot find file at path: "+path);
		};
		
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
            System.out.println("Finished loading users.");  //delete after finish coding?
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file at path: "+path);
        }
		
	}


	private void loadBooking (String path) {
		try{

			File file = new File(path);
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()){
				String data = scanner.nextLine();
				String[] splittedData = data.split(" ");
				//format: RoomID UserID YYMMDD StartingTime EndingTime
				
				//find room by id (pass back to class RoomType)
				Room room = getRoomByID(splittedData[0]);
				User user = getUserByID(splittedData[1]);

				//TODO: invalid date time exception
				Booking booking = new Booking(splittedData[0], splittedData[1], splittedData[2], Integer.parseInt(splittedData[3]), Integer.parseInt(splittedData[4]), splittedData[5]);
				
				//seems have error in this function so commented
				
				if(room != null){
					room.addBooking(booking);
				} else{
					System.out.println("Cannot find room: "+splittedData[0]);
				}
				
				if (user != null) {
					user.addBooking(booking);
				} else {
					System.out.println("Cannot find user: " + splittedData[1]);
				}
				
				allBookings.add(booking);

			}

			System.out.println("Finished loading bookings.");//delete after finish coding?

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

	public void printAllRoomType (){
		for(RoomType r: allRoomTypes){
			System.out.println(r);
		}
	}
	
	//maybe this function is can combine with getUserByUserID?
	public boolean userIdExist(String id){
		User u = User.getUserByID(allUsers,id);
		if(u!=null){return true;}
		else{return false;}
	}


	public void addUser(User user){
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
		//TODO: remove booking from txt file
	}

	public String checkAvailability(String roomTypeID, String date, int startTime, int endTime) {
		//TODO: if room available, return roomID, else return null
		for (Room r: allRooms) {
            if (r.getRoomType().getTypeID().equals(roomTypeID)) {
				ArrayList<Booking> bookings = r.getAllBookings();
				ArrayList<Booking> bookingsOfSpecificDate = Booking.getBoookingsOfSpecificDate(bookings, date);
				for (Booking b: bookingsOfSpecificDate) {
					//TODO: check if booking time overlap
				}
				
            }
		}
		return null;
	}

	public int getNextBookingID() {
		return allBookings.size() + 1;
	}

	
}
