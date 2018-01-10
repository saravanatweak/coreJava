package Examples.Common;

import java.util.Scanner;

public class AverageOfNumbers{

	public static void main(String[] args) {
	
		//average of numbers
		System.out.println(average(1,2,3,4,5));
		//average of numbers with given limit;
		System.out.println(avgForAny10RandomGivenNos(new Scanner(System.in)));
		//average of numbers with from and to limit.
		System.out.println(avgOfNumsWithFromAndTo(new Scanner(System.in)));

	}
	
	public static int average(int...numbers)
	{
		int total =0;
		for(int x:numbers)
			total=total+x;
		return total/numbers.length;
	}
	
	public static double avgForAny10RandomGivenNos(Scanner input) {
		int  counter=0, number;
		double total=0.0;
		
		System.out.println("Provide 10 numbers for getting average:");
		while(counter <10 )
		{
			number = input.nextInt();
			total = total + number;
			counter ++;
		}
		return total/10;
	}
	
	public static double avgOfNumsWithFromAndTo(Scanner input)
	{
		int from, to , counter=0;
		double result =0.0;
		
		System.out.println("Enter the starting staage of number : ");
		from = input.nextInt();
		
		System.out.println("Enter the stopping limit of number : ");
		to = input.nextInt();
		
		while( from <=to)
		{
			result = result+from;
			from++;
			counter++;
		}
		
		return result/counter;
	}
}
