package execute;

import java.util.Scanner;

public class CmdMarkClosingDate implements Command{

	@Override
	public void execute() {
		SportsCenter sportsCenter = SportsCenter.getInstance();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please input the Date you would like to mark closing (format: yyMMdd (e.g.241001)):");
		String date = scanner.nextLine();
		sportsCenter.addClosingDate(date);
		//TODO: handle those already booked bookings on closingDate
		
	}

}
