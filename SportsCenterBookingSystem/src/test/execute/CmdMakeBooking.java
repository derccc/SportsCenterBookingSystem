package execute;

import java.util.Scanner;

public class CmdMakeBooking implements Command{

	@Override
	public void execute(Scanner scanner) {
		User currentUser = UserSessionManager.getInstance().getCurrentUser();

		currentUser.makeBooking(scanner);
		
	}

}
