package execute;

import java.util.Scanner;

public class CmdRegisterAccount implements Command {

	@Override
	public void execute() {
		SportsCenter sportsCenter = SportsCenter.getInstance();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please input your Role ([A] for Admin, [N] for Normal User):");
		String userRole = scanner.nextLine();
		while (!userRole.equals("A") && !userRole.equals("N")){
			System.out.println("Invalid user role, please input again:");
			userRole = scanner.nextLine();
		}
	
	    System.out.println("Please input your User ID:");
	    String userID = scanner.nextLine();
	    User user = sportsCenter.getUserByID(userID);
	    while (user != null) {
			System.out.println("This User ID is not available, please input again:");
			userID = scanner.nextLine();
			user = sportsCenter.getUserByID(userID);
		};
	
	    System.out.println("Please input your Password:");
	    String userPassword = scanner.nextLine();
	    System.out.println("Please input your Password again:");
        String userPassword2 = scanner.nextLine();
	    while (!userPassword.equals(userPassword2)){
	    	System.out.println("Passwords do not match, please input again:");
	    	userPassword2 = scanner.nextLine();
	    }
	    
	    user = new User(userID, userRole, userPassword);
	    sportsCenter.addUser(user);
		System.out.println("Registration Success.");
		Main.setCurrentUser(user);
		
	}

}
