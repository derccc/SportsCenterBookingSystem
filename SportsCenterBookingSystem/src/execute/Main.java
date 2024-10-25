package execute;

import java.util.Scanner;

public class Main {

	private static User currentUser = null;

	public static void main(String[] args) {
	//TODO: suggestion: move register&login to another function, so can be called again after user login out
		//move where? accountController?
		SportsCenter sportsCenter = SportsCenter.getInstance();
		System.out.println("Welcome to the Sports Centre Booking System!");
		//AccountController.userRegisterLogin(sportsCenter);
        
        
    	Scanner scanner = new Scanner(System.in);
		String action;
        
        //register & login
		
		
		boolean isQuit = true;
        
        while (isQuit) { //not quit
        	
        	try {
        	
        		if(currentUser==null) {
        			System.out.println("Please input your action ([r] for Register, [l] for login, [q] for quit system) :");
        			action = scanner.nextLine();

        			switch(action) {
        			case "r":
        				(new CmdRegisterAccount()).execute();
        				break;
        			case "l":
        				(new CmdLogin()).execute();
        				break;
        			case "q":
        				isQuit = false;
        				break;
        			default:
        				throw new ExInvalidCommand();
        			}

        		}
        		else {
        			
        			action = currentUser.showActionMenu();
        			
        	        switch (action){
        	        case "m":
        	        	(new CmdMakeBooking()).execute();
        	            break;
                
        	        case "v":
        	        	(new CmdViewBooking()).execute();
        	            break;
        	
        	        case "c":
        	            (new CmdCancelBooking()).execute();
        	            break;
        	            
        	        case "l":
        	        	(new CmdLogout()).execute();
        	            break;
        			default:
        				throw new ExInvalidCommand();
        	    
        	        }
        			
        			
        			

        		}
        	
        	}
        	catch(ExInvalidCommand e) {System.out.println("Invalid command!");}
        	
        	
        	

        }
        
        
        scanner.close();
        
        
        
        //booking actions
        
        
        
        
        
        
       
	}

	public static void setCurrentUser(User user) {
		currentUser = user;
	}

}
