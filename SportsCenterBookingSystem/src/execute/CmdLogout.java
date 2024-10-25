package execute;

public class CmdLogout implements Command{

	@Override
	public void execute() {
		Main.setCurrentUser(null);
		System.out.println("You have been logged out.");
		
	}

}
