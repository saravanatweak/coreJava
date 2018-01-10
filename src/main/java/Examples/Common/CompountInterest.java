package Examples.Common;

import java.util.Scanner;

public class CompountInterest {
	
	private static Scanner input;
	public static void main(String args[])
	{
		input = new Scanner(System.in);
		double principle, amount=0.0, rate; 
		int year;
		
		System.out.println("Enter the principle amount: ");
		principle = input.nextDouble();
		
		System.out.println("Enter the interest which bank offers you:");
		rate = input.nextDouble()/100;
		
		System.out.println("Total no of years which you want ot keep your account:");
		year = input.nextInt();
		
		/*
		 This method does the function A = P(1+r/n)^nt where 
		 A = the future value of the investment/loan, including interest
		 P = the principal investment amount (the initial deposit or loan amount)
		 r = the annual interest rate (decimal)
		 n = the number of times that interest is compounded per year(Basically the month duration, months in a year)
		 t = the number of years the money is invested or borrowed for 
		 */
		for( int total =1; total <= year; total++)
		{
			//A = P(1+r/n)^nt
			
			amount = principle * Math.pow(1+rate/12, 12*total);
			System.out.println(total +"  year you will get   " +amount );
		}
		System.out.println("\n");
		System.out.println("And the total amount will be " + amount);
	}

}
