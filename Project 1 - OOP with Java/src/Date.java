import java.util.Calendar;
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;
    // is this changing or adding constant variables??????? refer to isLeapYear()
    public Date() {
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DATE);
    }
    public Date(String date) {
        int[] arrI = new int[3]; // [MONTH, DATE, YEAR] as an integer array
        String[] arrS = date.split("/"); // [MONTH, DATE, YEAR] as a string array

        for (int i = 0; i < arrS.length; i++) { // loop through the array of strings
            arrI[i] = Integer.parseInt(arrS[i]); // convert to integer for each index
        }

        year = arrI[2];
        month = arrI[0] - 1; // because indexes are [0,11]
        day = arrI[1];
    }
    public int getYear() { return this.year; }
    public int getMonth() { return this.month; }
    public int getDay() { return this.day; }
    private boolean isLeapYear(int y) { // checks for fail cases, otherwise return true
        if (y%Constants.QUADRENNIAL != 0) return false;
        if (y%Constants.QUADRENNIAL == 0 && y%Constants.CENTENNIAL == 0 && y%Constants.QUATERCENTENNIAL != 0) return false;
        return true;
    }
    public boolean isValid() {
        // if leap year and february 28+
        if (isLeapYear(this.year) && this.month == Calendar.FEBRUARY && this.day > Constants.FEB_LEAP_DAYS) return false;
        if (isLeapYear(this.year) && this.month == Calendar.FEBRUARY && this.day < 0) return false;
        // normal february conditions
        if (!isLeapYear(this.year) && this.month == Calendar.FEBRUARY && this.day > Constants.FEB_DAYS) return false;
        if (!isLeapYear(this.year) && this.month == Calendar.FEBRUARY && this.day < 0) return false;

        // false if month < 0 or month > 11
        if (this.month < Calendar.JANUARY || this.month > Calendar.DECEMBER) {
            return false;
        }
        boolean month1 = this.month == Calendar.JANUARY || this.month == Calendar.MARCH ||
                this.month == Calendar.MAY || this.month == Calendar.JULY ||
                this.month == Calendar.AUGUST || this.month == Calendar.OCTOBER ||
                this.month == Calendar.DECEMBER;
        boolean month2 = this.month == Calendar.APRIL || this.month == Calendar.JUNE ||
                this.month == Calendar.SEPTEMBER || this.month == Calendar.NOVEMBER;
        boolean cond1 = month1 && this.day > Constants.LONG_MONTHS;
        boolean cond2 = month1 && this.day < 0;
        boolean cond3 = month2 && this.day > Constants.SHORT_MONTHS;
        boolean cond4 = month2 && this.day < 0;
        if (cond1 || cond2 || cond3 || cond4) {
            return false;
        }
        return true;
    }
    @Override // override this one because same method signature
    public String toString() {
        return month + "/" + day + "/" + year;
    }
    // you do not override these two because it is being overloaded (different parameters)
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Date)) return false;
        Date d = (Date) o;
        return d.month == this.month && d.year == this.year && d.day == this.day;
    }
    @Override
    public int compareTo(Date o) {
        // if date is before
        if (o.year < this.year) return -1;
        else if (o.year > this.year) return 1;
        else if (o.month < this.month) return -1;
        else if (o.month > this.month) return 1;
        else if (o.day < this.day) return -1;
        else if (o.day > this.day) return 1;
        return 0;
    }
}
