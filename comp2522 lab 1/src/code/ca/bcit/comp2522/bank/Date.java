package ca.bcit.comp2522.bank;

/**
 * Correlates and validates the date given as int to the intended date.
 * @author Umanga Bagai
 * @version 1.0
 */

public class Date {
    /**
     * Constructor for the Date class.
     * @param year represents the given year.
     * @param month represents the given month.
     * @param day repreesnts the given day.
     */
    private final int year;
    private final int month;
    private final int day;
    private final int CURRENT_YEAR;
    public Date(final int year, final int month, final int day)
    {
        validateYear(year);
        validateMonth(month);
        validateDay(day);

        this.year = year;
        this.month = month;
        this.day = day;

    }

    /**
     * Returns the equilivant day. from the date.
     */
    private int getDay() {
        return day;
    }
    private int getMonth() {
        return month;
    }
    private int getYear() {
        return year;
    }
    private String getYYYYMMDD() {
        String YYYYMMDD;

        return null;
    }
    private void getDayOfTheWeek() {

    }


    private void validateYear(final int year) {

    }
    private void validateMonth(final int year) {

    }
    private void validateDay(final int year) {

    }
}

