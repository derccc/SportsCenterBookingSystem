package execute;

public class CmdLogout implements Command{

	@Override
	public void execute() {
		Main.setCurrentUser(null);
		SportsCenter sportsCenter = SportsCenter.getInstance();
		sportsCenter.saveData();
		System.out.println("You have been logged out.");
		
	}

}
