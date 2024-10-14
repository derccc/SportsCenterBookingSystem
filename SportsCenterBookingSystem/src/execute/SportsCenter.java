package execute;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SportsCenter {
	private ArrayList<Room> allRooms;
    private ArrayList<User> allUsers;
    private ArrayList<Booking> allBookings;
    private ArrayList<RoomType> allRoomTypes;
    private static SportsCenter INSTANCE;
    
    
	private SportsCenter() {
		this.allRooms = new ArrayList<>();
		this.allUsers = new ArrayList<>();
        this.allBookings = new ArrayList<>();
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
		// load room type, room, booking

		String roomTypePath = "SportsCenterBookingSystem\\src\\execute\\assets\\room_type.txt";
		String roomPath = "SportsCenterBookingSystem\\src\\execute\\assets\\room_data.txt";
		String bookingPath = "SportsCenterBookingSystem\\src\\execute\\assets\\booking_data";
		String userPath = "SportsCenterBookingSystem\\src\\execute\\assets\\user_data";
		
		loadRoomType(roomTypePath);
		loadRoom(roomPath);
		loadBooking(bookingPath);
		loadUser(userPath);
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

			System.out.println("Finished loading room types.");

			scanner.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot find file at path: "+path);
		}
		
	}

  private void loadRoom (String path) {
		try{

			File file = new File(path);
		// Load all rooms from file
		// Read from file
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()){
				String data = scanner.nextLine();
				String[] splittedData = data.split(" ");
				//format: roomID roomTypeID
				
				//find roomType by id (pass back to class RoomType)
				RoomType roomType= getRoomTypeById(splittedData[1]);

				Room room = null;
				if(roomType != null){
					room = new Room(splittedData[0],roomType);
				}
				else{
					System.out.println("Cannot find room type: "+splittedData[1]);
				}
				

				allRooms.add(room);

			}

			System.out.println("Finished loading rooms.");

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


	private void loadBooking (String path) {
		try{

			File file = new File(path);
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()){
				String data = scanner.nextLine();
				String[] splittedData = data.split(" ");
				//format: AreaID UserID YYMMDD StartingTime EndingTime
				
				//find room by id (pass back to class RoomType)
				Room room= getRoomById(splittedData[0]);

				//TODO: invalid date time exception
				Booking booking = new Booking(splittedData[0], splittedData[1], splittedData[2], Integer.parseInt(splittedData[3]), Integer.parseInt(splittedData[4]), splittedData[5]);

				
				if(room != null){
					room.addBooking(booking);
				}
				else{
					System.out.println("Cannot find room: "+splittedData[0]);
				}
				

			}

			System.out.println("Finished loading bookings.");

			scanner.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot find file at path: "+path);
		}
		
	}


	public Room getRoomById(String roomID) {
		return Room.getRoomById(allRooms,roomID);
	}

	public RoomType getRoomTypeById(String roomTypeID) {
		return RoomType.getRoomTypeById(allRoomTypes,roomTypeID);
	}
	
	public User getUserByUserID(String userID){ //TODO: call static function in User instead of check it here
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
