package Examples.Common;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ArmStrong {
/***
 * A number that is equal to the sum of cubes of its digits for example 0, 1, 153, 370, 371, 407 etc.
 * 153 = (1*1*1)+(5*5*5)+(3*3*3)  
 */
	public static void main(String[] args) {
		System.out.println("Enther the number ");
		int num = new Scanner(System.in).nextInt();
		int r,bal = 0,oldNo = num, c=0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
				
		while(num>0)  
	    {  
			r=num%10;  
			num=num/10;  
			bal=bal+(r*r*r);
			arr.add(r);
			c++;
	    }  
	    if(oldNo == bal)  
	    System.out.println("armstrong number and made up of " +arr);   
	    else  
	        System.out.println("Not armstrong number");   
	   }  
		
		
	}


