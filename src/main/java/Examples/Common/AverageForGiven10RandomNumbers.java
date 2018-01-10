package Examples.Common;

import java.util.Scanner;

public class AverageForGiven10RandomNumbers {

	private static Scanner input;
	
	public static void main(String args[])
	{
		input = new Scanner(System.in);
		
		int  counter=0, number;
		double average,total=0.0;
		
		System.out.println("Provide 10 numbers for getting average:");
		while(counter <10 )
		{
			number = input.nextInt();
			total = total + number;
			counter ++;
		}
		
		average = total/10;
		
		System.out.println("THe average of given 10 numbers is "+average);
	}
}
