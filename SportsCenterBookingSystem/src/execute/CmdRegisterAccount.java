package execute;

import java.util.Scanner;

public class CmdRegisterAccount implements Command {

	@Override
	public void execute(Scanner scanner) {
		SportsCenter sportsCenter = SportsCenter.getInstance();
		//Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please input your Role ([a] for admin, [n] for normal user):");
		String userRole = "";
		String[] validInput= {"a","n"};
		userRole = Common.getValidInput(scanner, validInput, Common.InputType.USERROLE);

	
	    System.out.println("Please input your User ID:");
	    String userID = Common.getValidInputLength(scanner, Common.InputType.USERID, 1);
	    User user = sportsCenter.getUserByID(userID);
	    while (user != null) {
			System.out.println("This User ID is not available, please input again:");
			userID = Common.getValidInputLength(scanner, Common.InputType.USERID, 1);
			user = sportsCenter.getUserByID(userID);
		};
	
	    System.out.println("Please input your Password:");
	    String userPassword = Common.getValidInputLength(scanner, Common.InputType.PASSWORD, 1);
	    System.out.println("Please input your Password again:");
        String userPassword2 = scanner.nextLine().trim();
	    while (!userPassword.equals(userPassword2)){
	    	System.out.println("Passwords do not match, please input again:");
	    	userPassword2 = scanner.nextLine().trim();
	    }
	    
	    user = new User(userID, userRole, userPassword);
	    sportsCenter.addUser(user);
		System.out.println("Registration Success.");
		UserSessionManager.getInstance().setCurrentUser(user);

		
	}

}
