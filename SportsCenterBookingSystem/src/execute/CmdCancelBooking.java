package execute;

public class CmdCancelBooking implements Command{

	@Override
	public void execute() {
		User currentUser = Main.getCurrentUser();
		currentUser.cancelBooking();
	}

}
