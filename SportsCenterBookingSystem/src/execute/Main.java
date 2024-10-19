package execute;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import execute.BookingsForDay;

public class Main {
	public static void main(String[] args) {
	//TODO: suggestion: move register&login to another function, so can be called again after user login out
		//move where? accountController?
		SportsCenter sportsCenter = SportsCenter.getInstance();
		System.out.println("Welcome to the Sports Centre Booking System!");
        AccountController.userRegisterLogin(sportsCenter);
       
	}

}
