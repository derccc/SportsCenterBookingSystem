package execute;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import execute.BookingsForDay;

public class Main {
	public static void main(String[] args) {
		
		SportsCenter sportsCenter = SportsCenter.getInstance();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Sports Centre Booking System!");
        
        String userID;
        String userPassword;
        User user;
        do {
            System.out.println("Please input your User ID:");
            userID = scanner.nextLine();
            user = sportsCenter.getUserByUserID(userID);
        } while (user==null);
        
        do {
            System.out.println("Please input your Password:");
            userPassword = scanner.nextLine();
        } while (!user.getUserPasword().equals(userPassword));

        AccountController accountController = new AccountController(user);
        accountController.execute();
        
        scanner.close();
	}

}
