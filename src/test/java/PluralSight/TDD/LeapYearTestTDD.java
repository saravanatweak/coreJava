package PluralSight.TDD;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
///import static org.junit.Assert.*;

/**tests whether a year, like an input year, is a leap year or not.
 * a year is leap year if its divisable by 4
 * but if they're divisible by 100, they aren't leap years,
 * except if the years are divisible by 400
 * */
public class LeapYearTestTDD {

    @Test
    public void leapYearsAreDivisibleByFour(){
        assertTrue(LeapYearOrNot.isLeapYear(2016));
    }

   //smthing not leap year
    @Test
    public void normalYearIsNotDivisibleByFour() {
        assertFalse(LeapYearOrNot.isLeapYear(3));
    }

    //2nd condtion
    @Test
    public void yearsDivisibleBy100AreNotLeapYears(){
        assertFalse(LeapYearOrNot.isLeapYear(1900));
    }

    @Test
    public void yearsDivisibleBy400AreLeapYears (){
        assertTrue(LeapYearOrNot.isLeapYear(2000));
    }

}


/**tests whether a year, like an input year, is a leap year or not.
 * a year is leap year if its divisable by 4
 * but if they're divisible by 100, they aren't leap years,
 * except if the years are divisible by 400
 * */
class LeapYearOrNot {


    //it's divisible by 4 and it's not divisible by 100, unless it's divisible by 400.
    public static boolean isLeapYear(final int year) {
        return isDivisable(year, 4) && (!isDivisable(year, 100) || isDivisable(year, 400));
    }

    private static boolean isDivisable( final int year, final int denominator) {
        return year %denominator == 0;
    }

    //Because of year and denomintor will bot chaned we can make it as final
}

