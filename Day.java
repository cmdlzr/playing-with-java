// Program calculates day of the week for a given date
import calendar.*;
import java.util.*;

public class Day {

    private static int day;
    private static int month;
    private static int year;
    private static int dayOfWeek;

    private static void verifyDay() {
        if (!((1 <= day) && (day <= 31))) {
            System.out.println("Day number is not in 1..31 range");
            System.exit(2);
        }
    }

    private static void parseDay(String dayString) {
        try {
            day = Integer.parseInt(dayString);
            verifyDay();
        }
        catch (IllegalArgumentException e) {
            System.out.println("Day entered is not an integer");
            System.exit(1);
        }
    }

    private static void parseMonth(String monthString) {
        try {
            month = Month.valueOf(monthString.toUpperCase()).getMonthNumber();
        }
        catch (IllegalArgumentException e) {
            System.out.println("Wrong month name entered.");
            System.exit(3);
        }
    }

    private static void parseYear(String yearString) {
        try {
            year = Integer.parseInt(yearString);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Year entered is not an integer");
            System.exit(4);
        }
    }

    private static void reportDayOfWeek() {
        try {
            System.out.println("It's " + DayOfWeek.getDayName(dayOfWeek));
        }
        catch (IllegalArgumentException e) {
            System.out.println("Day:: calculateDayOfWeek: day number calculated is not in 0..6 range");
        }
    }

    private static void calculateDayOfWeek() {
        final int UPPER_MONTH = 14;
        final int LOWER_MONTH = 2;
        final int DAY_OFFSET = 7000;
        final int DAY_PER_WEEk = 7;
		final int DAYS_PER_MONTH = 31;
		final int MONTH_PER_YEAR = 12;
		final int YEARS_PER_CENTURY = 100;
		final int LEAP_YEAR = 4;
		final int LEAP_YEARS = 400;
		int shiftedMonth = (int)Math.floor((UPPER_MONTH - month)/MONTH_PER_YEAR);
		int shiftedYear = year - shiftedMonth;
		int monthOffset = month + MONTH_PER_YEAR * shiftedMonth - LOWER_MONTH;
        dayOfWeek = Math.abs((int)(DAY_OFFSET + (day
											+ shiftedYear + Math.floor(shiftedYear / LEAP_YEAR)
											- Math.floor(shiftedYear / YEARS_PER_CENTURY)
											+ Math.floor(shiftedYear / LEAP_YEARS)
											+ Math.floor((DAYS_PER_MONTH * monthOffset) / MONTH_PER_YEAR)))) % DAY_PER_WEEk;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter a date: ");
		String[] dateArray = in.nextLine().split(" ");

        parseDay(dateArray[0]);
        parseMonth(dateArray[1]);
        parseYear(dateArray[2]);

        calculateDayOfWeek();
        reportDayOfWeek();
    }
}
