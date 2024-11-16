package execute;

import java.util.Scanner;

public class CmdCancelBooking implements Command{

	@Override
	public void execute(Scanner scanner) {
		User currentUser = Main.getCurrentUser();
		currentUser.cancelBooking(scanner);
	}

}
