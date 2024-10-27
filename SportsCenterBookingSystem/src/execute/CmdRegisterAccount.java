package execute;

import java.util.Scanner;

public class CmdRegisterAccount implements Command {

	@Override
	public void execute() {
		SportsCenter sportsCenter = SportsCenter.getInstance();
		Scanner scanner = new Scanner(System.in);
		String userID;
		String userRole;
		String userPassword;
		String userPassword2;
		User user;
		
		do {
    		System.out.println("Please input your Role ([A] for Admin, [N] for Normal User):");
    		userRole = scanner.nextLine();
    	} while (!userRole.equals("A") && !userRole.equals("N"));
	
	    System.out.println("Please input your User ID:");
	    userID = scanner.nextLine();
	
	    //check if id already exist
	    while (sportsCenter.userIdExist(userID)){
	        System.out.println();
	        System.out.println("This ID is not available.");
	        System.out.println("Please input your User ID:");
	        userID = scanner.nextLine();
	    }
	
	    System.out.println("Please input your Password:");
	    userPassword = scanner.nextLine();
	    do {
	        System.out.println("Please input your Password again:");
	        userPassword2 = scanner.nextLine();
	    } while (!userPassword2.equals(userPassword));
	    
	    user = new User(userID, userRole, userPassword);
	    sportsCenter.addUser(user);
	    user.toString();
		System.out.println("Registration Success.");
		Main.setCurrentUser(user);
		
	}

}
