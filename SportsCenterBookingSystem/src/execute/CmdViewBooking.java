package execute;

public class CmdViewBooking implements Command{

	@Override
	public void execute() {
		User currentUser = Main.getCurrentUser();
		currentUser.viewBooking();
	}

}
