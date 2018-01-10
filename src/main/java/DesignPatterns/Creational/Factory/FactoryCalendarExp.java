package DesignPatterns.Creational.Factory;

import java.util.Calendar;

/**
 * Created by Saravanakumar_K05 on 11/20/2017.
 */
public class FactoryCalendarExp {
    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance(); //try Calendar.getInstance and ctrl+space bar
    /*  Calendar.getInstance() // itself will provide different types of Calendar instances.
        that's what makes this different than some of the other design patterns because it is parameterized
        So instead of like the singleton where I'm going to just get whatever object it says is available for me, I can get different types of calendars based just simply off of time zone or locale, so that's a nicer feature of the Calendar API and really that's a feature of the factory method over singletons or some of the other creational design patterns that are out there.
    */


        System.out.println(cal);//will print GregorianCalendar
         //so the Gregorian calendar is the actual concrete implementation that's being called underneath this factory instance.
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));


        //Creating factory pattrn approach in Website generator.

        //One of the drawbacks to the factory pattern is that it takes a lot of moving pieces to really demonstrate what we're trying to do with it
    }
}
