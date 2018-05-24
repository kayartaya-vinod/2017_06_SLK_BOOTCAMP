package slk.programs;

public class P02_PrintCalendar {

	static boolean isLeap(int year) {
		return year % 400 == 0 || year % 100 != 0 && year % 4 == 0;
	}

	static int maxDays(int year) {
		return isLeap(year) ? 366 : 365;
	}

	static int maxDays(int month, int year) {
		switch (month) {
		case 2:
			return isLeap(year) ? 29 : 28;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		default:
			return 31;
		}
	}

	/**
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return number of days between 1/1/1900 and day/month/year
	 */
	static int julianDate(int day, int month, int year) {
		int jd = 0;

		// 1. sum of number of days in the years 1900..2016
		for (int y = 1900; y < year; y++) {
			jd += maxDays(y);
		}

		// 2. sum of number of days in the months 1..6 2017
		for (int m = 1; m < month; m++) {
			jd += maxDays(m, year);
		}
		
		// 3. number of days in the current month 
		jd += day;
		
		return jd;
	}

	/**
	 * Should print the calendar for the given month-year in Unix calendar
	 * format
	 * 
	 * @param month
	 * @param year
	 */
	static void printCalendar(int month, int year) {
		int offset = julianDate(1, month, year) % 7;

		System.out.printf("Calendar for %d, %d\n", month, year);
		System.out.printf("Su Mo Tu We Th Fr Sa\n");
		for (int i = 0; i < offset; i++) {
			System.out.printf("   ");
		}
		int max = maxDays(month, year);

		for (int i = 1; i <= max; i++) {
			System.out.printf("%-3s", i);
			if ((i + offset) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		printCalendar(7, 2017);
		printCalendar(1, 1974);
		printCalendar(2, 2017);
		printCalendar(2, 2012);
	}

}
