package execute;

public class ExBookingFailed extends Exception {
	
	private FailReason reason;
	
	
	public enum FailReason{
		NOROOMTYPE("no room types loaded in the system"),
		CLOSEDATE("the selected date is closing day"),
		NOTPAID("the booking fee is no paid"),
		NOTAVAIL("no room is available for the selected date and time");
		
		private String description;

		FailReason(String string) {
			description = string;
		}
		
		public String getDesc() {return description;}
	}
	
	public ExBookingFailed (FailReason reason) {
		this.reason = reason;
	}
	


	public void printMessage() {
		System.out.printf("Make booking failed. Reason: %s.\n", reason.getDesc());
	}
	

}
