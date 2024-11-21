package execute;

import java.util.Scanner;

public class CmdCancelBooking implements Command{

	@Override
	public void execute(Scanner scanner) {
		User currentUser = UserSessionManager.getInstance().getCurrentUser();
		currentUser.cancelBooking(scanner);
	}

}
