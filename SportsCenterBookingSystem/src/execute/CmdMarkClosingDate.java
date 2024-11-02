package execute;

import java.util.Scanner;

public class CmdMarkClosingDate implements Command{

	@Override
	public void execute() {
		SportsCenter sportsCenter = SportsCenter.getInstance();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please input the Date you would like to mark closing (format: yyMMdd (e.g.241001)):");
		String date = scanner.nextLine();
		if (sportsCenter.isClosingDate(date)) {
			System.out.println("The date was already marked as closing date.");
		} else {
			System.out.printf("The date you would like to mark as closing date is %s, are you confirmed to mark? (Y/N):\n", date);
			String action = scanner.nextLine();
			switch (action) {
				case "Y":
					sportsCenter.addClosingDate(date);
					break;
					
				case "N":
					break;
					
				default:
					//TODO: handle wrong input
					break;
				}
			
		}
		
	}

}
