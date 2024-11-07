package execute;

import java.util.Scanner;

public class Main {

	private static User currentUser = null;
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SportsCenter sportsCenter = SportsCenter.getInstance();
		System.out.println("Welcome to the Sports Centre Booking System!");
        
		boolean isExit = false;
		
		String action;
        
        while (!isExit) {
        	
        	try {
        		
        		if(currentUser==null) {
        			System.out.println("Please input your action ([r] for Register, [l] for login, [e] for exit system) :");
        			action = scanner.nextLine();
        			
        			switch(action) {
	        			case "r":
	        				(new CmdRegisterAccount()).execute(scanner);
	        				break;
	        				
	        			case "l":
	        				(new CmdLogin()).execute(scanner);
	        				break;
	        				
	        			case "e":
	        				isExit = true;
	        				System.out.println("System exit.");
	        				break;
	        				
	        			default:
	        				throw new ExInvalidCommand();
        			}
        			
        		}
        		else {
        			action = currentUser.showActionMenu(scanner);
        			
        	        switch (action){
	        	        case "m":
	        	        	(new CmdMakeBooking()).execute(scanner);
	        	            break;
	                
	        	        case "v":
	        	        	(new CmdViewBooking()).execute(scanner);
	        	            break;
	        	
	        	        case "c":
	        	            (new CmdCancelBooking()).execute(scanner);
	        	            break;
	        	            
	        	        case "l":
	        	        	(new CmdLogout()).execute(scanner);
	        	            break;
	        	            
	        	        case "d":
	        	        	(new CmdMarkClosingDate()).execute(scanner);
	        	        	break;
	        	        	
	        	        case "a":
	        	        	(new CmdAddNewRoom()).execute(scanner);
	        	        	break;
	        	        
	        	        case "p":
	        	        	(new CmdModifyRoomTypePrice()).execute(scanner);
	        	        	break;
	        	            
	        			default:
	        				throw new ExInvalidCommand();
        	        }
        	        
        		}
        	
        	}
        	catch(ExInvalidCommand e) {System.out.println("Invalid command!");}

        }
        
        scanner.close();
        
	}
	
	public static User getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(User user) {
		currentUser = user;
	}

}
