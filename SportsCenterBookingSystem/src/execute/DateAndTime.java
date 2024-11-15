package execute;

import java.time.DateTimeException;
import java.time.LocalDate;

public class DateAndTime {
	
	public static boolean isDateAndTimeValid(String DateAndTime) {
		String[] splittedDateAndTime = DateAndTime.split(" ");
		if(splittedDateAndTime.length!=2){return false;}
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
		try{
			int year = Integer.parseInt(date)/10000;
			int month = (Integer.parseInt(date)/100)%100;
			int day = Integer.parseInt(date)%100;
			
			if (month>12) {
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
		catch (NumberFormatException e){return false;}
		
	}
	
	public static boolean isTimeValid(String time) {
		String[] splittedTime = time.split("-");
		if(splittedTime.length!=2){return false;}
		try{
			int startTime = Integer.parseInt(splittedTime[0]);
			int endTime = Integer.parseInt(splittedTime[1]);

			if(startTime>23) {
				return false;
				
			}
			if(endTime>23) {
				return false;
			}
			return true;
		}
		catch (NumberFormatException e){return false;}
		}
	
	public static int calculateHours(int startTime, int endTime) {
		if (endTime<=startTime) {
			return (endTime+24)-startTime;
		}
		return endTime-startTime;
	}
	
	private static boolean isLeapYear(int year) {
		if (year%4==0) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isValidYearMonth(int year, int month) {
        try {

            LocalDate.of(year, month, 1);
            return true;
        } catch (DateTimeException e) {

            return false;
        }
    }
	
	
}
