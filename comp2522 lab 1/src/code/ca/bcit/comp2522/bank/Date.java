package ca.bcit.comp2522.bank;

/**
 * Correlates and validates the date given as int to the intended date.
 * @author Umanga Bagai
 * @version 1.0
 */

public class Date
{
    private final int year;
    private final int month;
    private final int day;
    private final int CURRENT_YEAR;

    private int dayOfTheWeek;
    private int numOf12;
    private final int monthsInYear = 12;
    private final int year2100 = 2000;
    private final int year2000 = 2000;
    private final int year1900 = 1900;
    private final int year1800 = 1800;
    private final int year1700 = 1700;
    final int twelve = 12;
    final int four = 4;
    private int step1;
    private int step2;
    private int monthCode;
    private final int numOfDaysInWeek = 7;
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
    private int getDay()
    {
        return day;
    }
    private int getMonth()
    {
        return month;
    }
    private int getYear()
    {
        return year;
    }
    private String getYYYYMMDD()
    {
        String YYYYMMDD;

        return null;
    }
    private int getDayOfTheWeek(final int year, final int month, final int day)
    {
        switch (month)
        {
            case 1, 10 -> monthCode = 1;
            case 2, 3 -> monthCode = 4;
            case 4, 7 -> monthCode = 0;
            case 5 -> monthCode = 2;
            case 6 -> monthCode = 5;
            case 8 -> monthCode = 3;
            case 9, 12 -> monthCode = 6;
            case 11 -> monthCode = 4;
        }

        if ( (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 )
        {
            if (month == 1 || month == 2)
            {
                dayOfTheWeek+=6;
            }
        }

        if (year >= year1700 && year <= year1900)
        {
            dayOfTheWeek += 2;
        }
        if (year >= year2000 && year <= year2100)
        {
            dayOfTheWeek += 2;
        }

        if(year <= year2000 && year1800 <= year)
        {

            numOf12 = (year - year1900)/monthsInYear;
            step1 = dayOfTheWeek - twelve*numOf12;
            step2 = step1/four;
            dayOfTheWeek = (step1 + step2 + numOf12 + day);


            dayOfTheWeek += monthCode;
            dayOfTheWeek %=numOfDaysInWeek;

            return dayOfTheWeek;
        }
    }


    private void validateYear(final int year)
    {

    }
    private void validateMonth(final int year)
    {

    }
    private void validateDay(final int year)
    {

    }
}

