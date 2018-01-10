package Examples.Common;

import java.util.Scanner;

public class AverageOfGivenLimit {
	
	private static Scanner input;
	public static void main(String args[])
	{
		input = new Scanner(System.in);
		int from, to , fromIntial, counter=0;
		double average, result = 0;
		
		System.out.println("Enter the starting staage of number : ");
		from = input.nextInt();
		fromIntial = from;
		
		System.out.println("Enter the stopping limit of number : ");
		to = input.nextInt();
		
		while( from <=to)
		{
			result = result+from;
			from++;
			counter++;
		}
		
		average = result/counter;
		
		System.out.println("The averge of numbers from "+ fromIntial+" to "+to+" is: "+average );
	}
}
		
