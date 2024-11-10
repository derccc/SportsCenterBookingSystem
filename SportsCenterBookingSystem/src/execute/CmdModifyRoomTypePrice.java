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
			String roomTypeID = scanner.nextLine().trim();
			RoomType roomType = sportsCenter.getRoomTypeByID(roomTypeID);
			while (roomType == null) {
				System.out.println("Room Type ID not found, please input again:");
				roomTypeID = scanner.nextLine().trim();
				roomType = sportsCenter.getRoomTypeByID(roomTypeID);
			}
			

			System.out.println("The current price: "+ roomType.getPrice());
			System.out.println("Please input the new Price you would like to modify to:");
	
			int intPrice = Common.getValidPositiveNumber(scanner, Common.InputType.PRICE);


			if (roomType.getPrice()==intPrice) {
				System.out.println("The price is same as the original.");
			} else {
				System.out.printf("The price is changed to $%d/hr, are you confirmed to modify? (Y/N):\n", intPrice);
			

				String[] validCommand= {"Y","N"};
				String action = Common.getValidInput(scanner, validCommand, Common.InputType.COMMAND);

				switch (action) {
					case "y":
						roomType.setPrice(intPrice);
						break;
						
					case "n":
						break;
				}
			}
			
			
		}
		
		
		
	}

}
