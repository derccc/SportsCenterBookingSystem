package execute;

import java.util.Scanner;

public class CmdModifyRoomTypePrice implements Command{

	@Override
	public void execute(Scanner scanner) {
		SportsCenter sportsCenter = SportsCenter.getInstance();
		//Scanner scanner = new Scanner(System.in);
		
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
			String price = scanner.nextLine();
			int intPrice = Integer.parseInt(price);
			while (intPrice<0) {
				System.out.println("Invalid price, please input again:");
				price = scanner.nextLine();
				intPrice = Integer.parseInt(price);
			}
			if (roomType.getPrice()==intPrice) {
				System.out.println("The price is same as the original.");
			} else {
				System.out.printf("The price is changed to $%d/hr, are you confirmed to modify? (Y/N):\n", intPrice);
				String action = scanner.nextLine();
				while (!action.equals("Y") && !action.equals("N")) {
	        		System.out.println("Invalid command, please input again:");
	        		action = scanner.nextLine();
	        	}
				switch (action) {
					case "Y":
						roomType.setPrice(intPrice);
						break;
						
					case "N":
						break;
				}
			}
			
			
		}
		
		
		
	}

}
