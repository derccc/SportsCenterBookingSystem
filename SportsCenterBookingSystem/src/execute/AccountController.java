package execute;

import java.util.Scanner;

public class AccountController {
	private User user;

    public AccountController(User user){
        this.user = user;
    }

    public void execute() {
        SportsCenter sportsCenter = SportsCenter.getInstance();

        Scanner scanner = new Scanner(System.in);
        String action;

        switch(user.getUserRole()){
            
            case "A":

                System.out.println("Please input your action ([v] for view booking, [c] for cancel booking, [l] for logout):");
                action = scanner.nextLine();
                switch (action){
                    case "v":
                        user.viewBooking();
                        this.execute();
                        break;

                    case "c":
                        break;

                    case "l":
                        break;
                
                }
                break;

            case "N":
                
                System.out.println("Please input your action ([m] for make booking, [v] for view booking, [c] for cancel booking, [l] for quit):");
                action = scanner.nextLine();
                switch (action){
                    case "m":
                        //sportsCenter.showRoomTypes();
                        System.out.println("Please input your preferred timeslot (format: badminton 2024-08-10 1000-1200):");
                        
                        break;

                    case "v":
                        user.viewBooking();
                        this.execute();
                        break;

                    case "c":
                        break;

                    case "l":
                        break;
        
                }

                break;
        }
        
        
        scanner.close();
    }

}
