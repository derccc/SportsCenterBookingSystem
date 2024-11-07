package execute;

import java.util.Scanner;

public class CmdLogin implements Command{

	@Override
	public void execute(Scanner scanner) {
		SportsCenter sportsCenter = SportsCenter.getInstance();
		//Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please input your User ID:");
    	String userID = scanner.nextLine();
    	User user = sportsCenter.getUserByID(userID);
    	
		while (user == null) {
			System.out.println("User ID not found, please input again:");
			userID = scanner.nextLine();
			user = sportsCenter.getUserByID(userID);
		};
		
		System.out.println("Please input your Password:");
        String userPassword = scanner.nextLine();
		while (!user.getUserPasword().equals(userPassword)) {
			System.out.println("Wrong password, please input again:");
			userPassword = scanner.nextLine();
		};
		
		Main.setCurrentUser(user);
		
		
	}

}
