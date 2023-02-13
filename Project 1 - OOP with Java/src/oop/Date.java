package oop;

import java.util.Calendar;
/**
 * Date object used in the Profile object
 * Contains the day, month, year, and methods regarding dates
 * @author Marlon Vergara
 * @author Luis Castellanos
 */
public class Date implements Comparable<Date> {
    /** year in Date object */
    private int year;

    /** month in Date object */
    private int month;

    /** day in Date object */
    private int day;

    /** Constructor for Date if no parameters are given. */
    public Date() {
        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DATE);
    }

    /**
     * Constructor for Date if parameters are given.
     * @param date the date in String form which is to be converted to a Date object.
     */
    public Date(String date) {
        int[] arrI = new int[3];
        String[] arrS = date.split("/");

        for (int i = 0; i < arrS.length; i++) {
            arrI[i] = Integer.parseInt(arrS[i]);
        }

        year = arrI[2];
        month = arrI[0] - 1; // because indexes are [0,11]
        day = arrI[1];
    }

    /**
     * Gets the year.
     * @return integer which represents the year.
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Sets the year.
     * @param yr year to set.
     */
    public void setYear(int yr) {
        this.year = yr;
    }

    /**
     * Gets the month.
     * @return integer which represents the month.
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * Gets the day.
     * @return integer which represents the day.
     */
    public int getDay() {
        return this.day;
    }

    /**
     * Checks to see if inputted year is a leap year or not.
     * @param year year to be checked if it is a leap year or not.
     * @return true if the year is a leap year, false otherwise.
     */
    private boolean isLeapYear(int year) { // checks for fail cases, otherwise return true
        if (year%Constants.QUADRENNIAL != 0) return false;
        if (year%Constants.QUADRENNIAL == 0 && year%Constants.CENTENNIAL == 0 && year%Constants.QUATERCENTENNIAL != 0) return false;
        return true;
    }

    /**
     * Checks to see if the date is valid or not.
     * @return true if date is a valid date, false otherwise.
     */
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

    /**
     * Overriding the toString method to the following form: month/day/year.
     * @return string reading "month/day/year".
     */
    @Override
    public String toString() {
        int trueMonth = month + 1;
        return trueMonth + "/" + day + "/" + year;
    }

    /**
     * Overriding the equals(Object o) method to see if two Date objects are equal.
     * @param obj Date object that we are comparing to the current Date object to see if equal or not.
     * @return true if both objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Date)) return false;
        Date d = (Date) obj;
        return d.month == this.month && d.year == this.year && d.day == this.day;
    }

    /**
     * Overriding the compareTo(Date o) method to compare this object and another.
     * @param obj the object to be compared.
     * @return -1 if this Date is before the inputted object, 1 if this Date is after the inputted object, 0 if the two Dates are the same
     */
    @Override
    public int compareTo(Date obj) {
        // if date is before
        if (obj.year < this.year) return 1;
        else if (obj.year > this.year) return -1;
        else if (obj.month < this.month) return 1;
        else if (obj.month > this.month) return -1;
        else if (obj.day < this.day) return 1;
        else if (obj.day > this.day) return -1;
        return 0;
    }

    /**
     * Testbed main method.
     * Tests to see if the isValid() method works.
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        Date bad1 = new Date("2/29/2003");
        System.out.println("bad1.isValid() = " + bad1.isValid());
        Date bad2 = new Date("4/31/2003");
        System.out.println("bad2.isValid() = " + bad2.isValid());
        Date bad3 = new Date("13/31/2003");
        System.out.println("bad3.isValid() = " + bad3.isValid());
        Date bad4 = new Date("3/32/2003");
        System.out.println("bad4.isValid() = " + bad4.isValid());
        Date bad5 = new Date("-1/31/2003");
        System.out.println("bad5.isValid() = " + bad5.isValid());

        Date good1 = new Date("9/2/2022");
        System.out.println("good1.isValid() = " + good1.isValid());
        Date good2 = new Date("12/20/2004");
        System.out.println("good2.isValid() = " + good2.isValid());
    }
}
