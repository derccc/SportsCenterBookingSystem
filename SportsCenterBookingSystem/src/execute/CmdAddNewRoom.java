package execute;

import java.util.Scanner;

public class CmdAddNewRoom implements Command{

	@Override
	public void execute(Scanner scanner) {
		SportsCenter sportsCenter = SportsCenter.getInstance();
    	//Scanner scanner = new Scanner(System.in);
    	String action;
    	
    	int roomTypeCount = sportsCenter.printAllRoomType();
    	
    	if (roomTypeCount==0) {
    		action = "t";
    		
    	} else {
    		System.out.println("Please input your action ([t] for add room type, [r] for add room to existing room type):");
        	action = scanner.nextLine();
    		while (!action.equals("t") && !action.equals("r")) {
        		System.out.println("Invalid command, please input again:");
        		action = scanner.nextLine();
        	}
    	}
    	
		switch(action) {
            case "t":
            	//TODO: may need state only one word name is allowed?
            	System.out.println("Please input the new Room Type Name and its Price (format: badminton 40):");
            	String roomTypeNameAndPrice = scanner.nextLine();
            	String[] splittedRoomTypeNameAndPrice = roomTypeNameAndPrice.split(" ");
            	String roomTypeName = splittedRoomTypeNameAndPrice[0];
            	int roomTypePrice = Integer.parseInt(splittedRoomTypeNameAndPrice[1]);
            	int nextRoomTypeID = sportsCenter.getNextRoomTypeID();
            	
            	System.out.println("New room type added and 1 new room assigned to the new room type.");
            	RoomType roomType = new RoomType(String.valueOf(nextRoomTypeID), roomTypeName, roomTypePrice);
            	sportsCenter.addRoomType(roomType);
            	int nextRoomID = sportsCenter.getNextRoomID();
            	Room room = new Room(String.valueOf(nextRoomID), roomType);
            	sportsCenter.addRoom(room);
            	
            	break;
            	
            case "r":
            	System.out.println("Please input the Room Type ID you would like to add room to:");
            	String roomTypeID = scanner.nextLine();
            	roomType = sportsCenter.getRoomTypeByID(roomTypeID);
    			while (roomType == null) {
    				System.out.println("Room Type ID not found, please input again:");
    				roomTypeID = scanner.nextLine();
    				roomType = sportsCenter.getRoomTypeByID(roomTypeID);
    			}
            	nextRoomID = sportsCenter.getNextRoomID();
            	
            	System.out.println("1 new room assigned to the room type.");
            	room = new Room(String.valueOf(nextRoomID), roomType);
    			sportsCenter.addRoom(room);
    			
                break;
		}
	}

}
