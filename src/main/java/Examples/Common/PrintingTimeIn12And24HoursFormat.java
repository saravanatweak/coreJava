package Examples.Common;

import java.util.Scanner;

public class PrintingTimeIn12And24HoursFormat
{
	private static Scanner input;
	 public static void main(String args[])
	 {
		 input = new Scanner(System.in);
		 int h, m,s, f;
		 
		 System.out.println("provide the hour : " );
		 h = input.nextInt();
		 System.out.println("provide the minute : " );
		 m = input.nextInt();
		 System.out.println("provide the Second: " );
		 s = input.nextInt();
		 System.out.println("Provide the 12 or 24 format by providing 12 or 24: " );
		 f = input.nextInt();
		 
		 int hour = (h>0 && h<24 ? h : 0);
		 int minute = (m>0 && m<60 ? m : 0);
		 int second = (s>0 && s<60 ? s : 0);
		 
		 if( f==12)
		 {
			 System.out.println("The Time in 12 hour format :");
			 System.out.format("%s:%02d:%02d %s", hour<12 ? hour : hour%12, minute, second, hour<12 ? "AM" : "PM"); 
		 }
		 else if(f==24)
		 {
			 System.out.println("The Time in 24 hour format :");
			 System.out.format("%02d:%02d:%02d", hour, minute, second);
		 }
		 else
		 {
			System.out.println("The Given hour" + h +"\n or minute "+ m +"\n or Second"+ s +"\n or format"+ f +" is Wrong. Ple check"); 
		 }
		
		 
		 
	 }
}
