package CoreJava.JavaUtil.Date;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class GettingDateThroughDiffApis {
    public static void main(String args[]) {

        //using util.Date
        Date date  = new Date();
        System.out.println(date+"\n");

        //Using System.currentTimeMillis()
        Date date1 = new Date(System.currentTimeMillis());
        System.out.println(date1+"\n");

        //USing java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        System.out.println(sqlDate+"\n");

        //Using java.utl.Date
        Date date4 = java.util.Calendar.getInstance().getTime();
        System.out.println(date4+"\n");

        //Using Locale to get the date
        printDate(Locale.UK);
        printDate(Locale.US);
        printDate(Locale.FRANCE);

    }

    static void printDate(Locale locale){
        DateFormat dateFormatter=DateFormat.getDateInstance(DateFormat.DEFAULT,locale);
        DateFormat timeFormatter=DateFormat.getDateInstance(DateFormat.DEFAULT,locale);
        Date currentDate=new Date();
        String date=dateFormatter.format(currentDate);
        String time = timeFormatter.format(currentDate);
        System.out.println("date is "+ date+" and time is "+time +" for locale in " +locale);
    }
}

