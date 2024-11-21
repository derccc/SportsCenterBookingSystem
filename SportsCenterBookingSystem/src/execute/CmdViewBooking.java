package execute;

import java.util.Scanner;

public class CmdViewBooking implements Command{

	@Override
	public void execute(Scanner scanner) {
		User currentUser = UserSessionManager.getInstance().getCurrentUser();

		currentUser.viewBooking(scanner);
	}

}
