package CoreJava.JavaUtil.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExp {
    //Note: M (capital M) represents month and m (small m) represents minute in java.
    public static void main(String args[]) throws Exception {
        Date date = new Date();
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");

        //Date to String
        String strDate1= formatter1.format(date); //formatting means converting date to string
        System.out.println(strDate1);

        //String to Date
        try {
            Date date1 = formatter1.parse("31/03/2015"); // parsing means converting string to date.
            System.out.println("Date is: "+date1);
        } catch (ParseException e) {e.printStackTrace();}

        //Extra ways to get the different date formats
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = formatter.format(date);
        System.out.println("Date Format with MM/dd/yyyy : "+strDate);

        formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        strDate = formatter.format(date);
        System.out.println("Date Format with dd-M-yyyy hh:mm:ss : "+strDate);

        formatter = new SimpleDateFormat("dd MMMM yyyy");
        strDate = formatter.format(date);
        System.out.println("Date Format with dd MMMM yyyy : "+strDate);

        formatter = new SimpleDateFormat("dd MMMM yyyy zzzz");
        strDate = formatter.format(date);
        System.out.println("Date Format with dd MMMM yyyy zzzz : "+strDate);

        formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        strDate = formatter.format(date);
        System.out.println("Date Format with E, dd MMM yyyy HH:mm:ss z : "+strDate);
    }
}
