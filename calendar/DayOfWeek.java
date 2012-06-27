package calendar;

public enum DayOfWeek {
	SUNDAY("Sunday", 0),
	MONDAY("Monday", 1),
	TUESDAY("Tuesday", 2),
	WEDNESDAY("Wednesday", 3),
	THURSDAY("Thursday", 4),
	FRIDAY("Friday", 5),
	SATURDAY("Saturday", 6);

	DayOfWeek(String dayString, int dayNumber) {
		this.dayString = dayString;
		this.dayNumber = dayNumber;
	}

	private String dayString;
	private int dayNumber;

	public int getDayNumber() {
		return dayNumber;
	}

	public String getDayString() {
		return dayString;
	}

	public static String getDayName(int dayNumber) {
		for(DayOfWeek dayOfWeek : values()){
			if ( dayOfWeek.getDayNumber() == dayNumber ) {
				return dayOfWeek.getDayString();
			}
		}
		throw new IllegalArgumentException("No enum is specified for number " + dayNumber);
    }
}
