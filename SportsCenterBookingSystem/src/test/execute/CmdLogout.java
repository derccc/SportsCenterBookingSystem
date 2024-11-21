package execute;

import java.util.Scanner;

public class CmdLogout implements Command{

	@Override
	public void execute(Scanner scanner) {
		UserSessionManager.getInstance().setCurrentUser(null);

		SportsCenter sportsCenter = SportsCenter.getInstance();
		sportsCenter.saveData();
		System.out.println("You have been logged out.");
		
	}

}
