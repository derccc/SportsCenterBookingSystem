package execute;

public class CmdMakeBooking implements Command{

	@Override
	public void execute() {
		User currentUser = Main.getCurrentUser();
		currentUser.makeBooking();
		
	}

}
