package Examples.Common;

import java.util.Random;

public class RandomNumberGenerator {

	public static void main(String[] args) {
		Random dice = new Random();
		for(int count=1; count<=10; count ++)
			System.out.println(1+ dice.nextInt(6));// as index is starting from zero

		//finding minimum number from given array
		/*for(int i=1;i<arr.length;i++)
			if(min>arr[i])
			s	min=arr[i];*/
	}

}
