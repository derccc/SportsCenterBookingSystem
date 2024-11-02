package execute;

public class DateAndTime {
	
	public static boolean isDateAndTimeValid(String DateAndTime) {
		String[] splittedDateAndTime = DateAndTime.split(" ");
		String date = splittedDateAndTime[0];
		String time = splittedDateAndTime[1];
		if (!isDateValid(date)) {
			return false;
		}
		if (!isTimeValid(time)) {
			return false;
		}
		return true;
	}
	
	public static boolean isDateValid(String date) {
		int year = Integer.parseInt(date)/10000;
		int month = (Integer.parseInt(date)/100)%100;
		int day = Integer.parseInt(date)%100;
		
		if (year<0 || month<0 || month>12 || day<0) {
			return false;
		}
		switch(month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				return day<=31;
			case 4: case 6: case 9: case 11:
				return day<=30;
			case 2:
				if (isLeapYear(year)) {
					return day<=29;
				} else {
					return day<=28;
				}
		}
		return false;
	}
	
	public static boolean isTimeValid(String time) {
		String[] splittedTime = time.split("-");
		int startTime = Integer.parseInt(splittedTime[0]);
		int endTime = Integer.parseInt(splittedTime[1]);
		
		if (startTime<0 || startTime>23 || endTime<0 || endTime>23) {
			return false;
		}
		return true;
	}
	
	public static int calculateHours(int startTime, int endTime) {
		if (endTime<=startTime) {
			return (endTime+24)-startTime;
		}
		return endTime-startTime;
	}
	
	private static boolean isLeapYear(int year) {
		if (year%400==0) {
			return true;
		}
		else if (year%100==0) {
			return false;
		}
		else if (year%4==0) {
			return true;
		}
		else {
			return false;
		}
	}
}
