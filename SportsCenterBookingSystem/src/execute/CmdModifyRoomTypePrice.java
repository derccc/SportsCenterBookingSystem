package execute;

import java.util.Scanner;

public class CmdModifyRoomTypePrice implements Command{

	@Override
	public void execute() {
		SportsCenter sportsCenter = SportsCenter.getInstance();
		Scanner scanner = new Scanner(System.in);
		
		sportsCenter.printAllRoomType();
		
	}

}
