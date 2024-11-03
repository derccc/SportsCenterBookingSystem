package execute;

import java.util.Scanner;

public class CmdModifyRoomTypePrice implements Command{

	@Override
	public void execute() {
		SportsCenter sportsCenter = SportsCenter.getInstance();
		Scanner scanner = new Scanner(System.in);
		
		int roomTypeCount = sportsCenter.printAllRoomType();
		
		if (roomTypeCount>0) {
			
			System.out.println("Please input the Room Type ID you would like to modify price for:");
			String roomTypeID = scanner.nextLine();
			RoomType roomType = sportsCenter.getRoomTypeByID(roomTypeID);
			while (roomType == null) {
				System.out.println("Room Type ID not found, please input again:");
				roomTypeID = scanner.nextLine();
				roomType = sportsCenter.getRoomTypeByID(roomTypeID);
			}
			
			//TODO: need validate price input
			System.out.println("Please input the new Price you would like to modify to:");
			int price = scanner.nextInt();
			while (price<0) {
				System.out.println("Invalid price, please input again:");
				price = scanner.nextInt();
			}
			//TODO: ask confirm?
			roomType.modifyPrice(price);
			
		}
		
		
		
	}

}
