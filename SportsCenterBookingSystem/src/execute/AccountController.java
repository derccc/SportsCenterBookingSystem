package execute;

import java.util.Scanner;

public class AccountController {
    private User user;

    public AccountController(User user){
        this.user = user;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        String action;

        switch(user.getRole()){
            case "NormalUser":
                
                System.out.println("Please input your action ([m] for make booking, [v] for view booking, [c] for cancel booking, [q] for quit):");
                action = scanner.nextLine();
                switch (action){
                    case "m":
                        break;
                    case "v":
                        user.viewBooking();
                        break;
                    case "c":
                        break;
                    case "q":
                        break;
        
                }

                break;
                
            case "Admin":

                System.out.println("Please input your action ([m] for make booking, [v] for view booking, [c] for cancel booking, [q] for quit):");
                action = scanner.nextLine();
                switch (action){
                    case "m":
                        break;
                    case "v":
                        user.viewBooking();
                        break;
                    case "c":
                        break;
                    case "q":
                        break;
                
                }
                break;
        }
        
        
        scanner.close();
    }


}
