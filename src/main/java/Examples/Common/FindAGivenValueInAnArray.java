package Examples.Common;

import java.util.Scanner;

public class FindAGivenValueInAnArray {

	private static Scanner input;
	public static void main(String[] args) {

		input = new Scanner(System.in);
	
		//finding integer value
		int[] in = {1,2,3,4,5,6,7,8,9,10};
		System.out.println("Please provide the phone number you want 1-10 ");
		int givenNo = input.nextInt();
		int pos= 0;
		
		for(int i=0; i<in.length; i++)
		{
			if(in[i] == givenNo)
				pos =i+1;
		}
		if(pos !=0 )
			System.out.println("Given number"+givenNo+" is in positon at"+ pos);
	}





}
