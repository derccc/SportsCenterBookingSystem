package execute;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import execute.BookingsForDay;

public class Main {
	public static void main(String[] args) {
	//TODO: suggestion: move register&login to another function, so can be called again after user login out
		SportsCenter sportsCentre = SportsCenter.getInstance();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Sports Centre Booking System!");
        
        String action;
        System.out.println("Please input your action ([r] for Register, [l] for login) :");
        action = scanner.nextLine();

        String userID;
        String userRole;
        String userPassword;
        String userPassword2;
        User user;
        AccountController accountController;

        switch (action){

            case "r":
            	//TODO: check if id already exist 
                System.out.println("Please input your Role ([A] for Admin, [N] for Normal User):");
                userRole = scanner.nextLine();
                System.out.println("Please input your User ID:");
                userID = scanner.nextLine();
                System.out.println("Please input your Password:");
                userPassword = scanner.nextLine();
                do {
                    System.out.println("Please input your Password again:");
                    userPassword2 = scanner.nextLine();
                } while (!userPassword2.equals(userPassword));
                
                user = new User(userID, userRole, userPassword);
		
                //TODO: sportsCenter.userRegistration(user) //remember to add user to txt;
                System.out.println("Registration Success.");
                
                accountController = new AccountController(user);
                accountController.execute();

                break;


            case "l":
                do {
                    System.out.println("Please input your User ID:");
                    userID = scanner.nextLine();
                    user = sportsCentre.getUserByUserID(userID);
                } while (user==null);
                do {
                    System.out.println("Please input your Password:");
                    userPassword = scanner.nextLine();
                } while (!user.getUserPasword().equals(userPassword));

                accountController = new AccountController(user);
                accountController.execute();
                
                break;

        }

        scanner.close();
	}

}
