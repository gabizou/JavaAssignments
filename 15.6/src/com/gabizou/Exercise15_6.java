
package com.gabizou;


public class Exercise15_6 {

	/**
	 * @param args'
	 * Exercise: 
	 * 
	 * Rewrite the PrintCalendar class in Listing 5.12
	 * to display a calendar for a specified month using
	 * Calendar and GregorianCalendar classes.
	 * Your program receives the month and year from
	 * the command line.
	 * For example: java Exercise15_06 1 2012
	 * shows Calendar for January of 2012
	 */

	static Calendar calendar = new Calendar();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Get month from second argument
		 * in command prompt
		 */
		int month= Integer.parseInt(args[0]);

		/* Get Year from second argument
		 * in command prompt
		 */
		int year= Integer.parseInt(args[1]);
		if (args.length > 2)
			System.out.println("Usage java Exercise15_10 month year");
		else if (args.length == 2) {
			//use user-defined month and year
			year = Integer.parseInt(args[1]);
			month = Integer.parseInt(args[0]);

			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month - 1);
		}
		else if (args.length == 1) {
			//use user-defined month for the current year
			month = Integer.parseInt(args[0]);

			calendar.set(Calendar.MONTH, month-1);
		}

		//set date to the first day in a month
		calendar.set(Calendar.DATE, 1);

		//print calendar for the month
		printMonth(year, month);
	}

	static void printMonth(int year, int month) {
		//get start day of the week for the first date in the month
		int startDay = getStartDay();

		//get number of days in the month
		int numOfDaysInMonth = calendar.daysInMonth();

		//print headings
		printMonthTitle(year, month);

		//print body
		printMonthBody(startDay, numOfDaysInMonth);
	}

	static int getStartDay() {
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	static void printMonthBody(int startDay, int numOfDaysInMonth) {
		//print padding space before the first day of the month
		int i = 0;

		for (i = 0; i < startDay-1; i++)
			System.out.print("    ");

		for (i = 1; i <= numOfDaysInMonth; i++) {
			if (i < 10)
				System.out.print("   "+i);
			else
				System.out.print("  "+i);

			if ((i + startDay - 1) % 7 == 0)
				System.out.println();
		}

		System.out.println("");
	}

	static void printMonthTitle(int year, int month) {
		System.out.println("         "+calendar.getMonthName()+", "+year);
		System.out.println("-----------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}
}
