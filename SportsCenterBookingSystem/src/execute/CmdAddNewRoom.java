package execute;

import java.util.Scanner;

public class CmdAddNewRoom implements Command{

	@Override
	public void execute() {
		SportsCenter sportsCenter = SportsCenter.getInstance();
    	Scanner scanner = new Scanner(System.in);
    	
    	int roomTypeCount = sportsCenter.printAllRoomType();
    	
    	if (roomTypeCount==0) {
    		//TODO: add new roomType
    		System.out.println();
    	}
    	
    	System.out.println("Please input the Room Type ID you would like to add room to:");
    	String roomTypeID = scanner.nextLine();
    	
    	
    	
	}

}
