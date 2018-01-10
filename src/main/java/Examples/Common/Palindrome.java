package Examples.Common;

import java.util.Scanner;
/***
 * A palindrome number is a number that is same after reverse. 
 * For example 545, 151, 34543, 343, 171, 48984 are the palindrome numbers.
 */
public class Palindrome {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//Palindrome for number
		//System.out.println("Enter a number to check");
		//palindromeNumber(input.nextInt());

		//Palindrome for String using String buffer
		//System.out.println("Palindrome for String using String buffer: ");
		//palindromeStringBuffer(input.nextLine());
		
		//Palindrome for String by not using buffer
		//System.out.println("Palindrome for String by not using buffer : ");
		//palindromeString(input.nextLine());

		System.out.println("Most Efficient way to find palindrome : ");
		palindromeEfficentWay(input.nextLine());
		
	}

	private static void palindromeNumber(int number) {
		int r, oldNo, newNo = 0; 
		oldNo  = number;
		while(number >0)
		{
			r = number%10 ;
			newNo= (newNo*10) +r;
			number = number/10;
		}
		
		if(newNo == oldNo)
			System.out.println("Given number "+oldNo+" is Palindrome number" );
		else 
			System.out.println("Given number "+oldNo+" is NOT a Palindrome number" );
	}
	
	private static void palindromeString(String str)
	{
		String oldStr = str;
		String output = "";
		
		for(int s=str.length()-1; s>=0; s--)
			output += str.charAt(s);
		
		if(oldStr.equals(output))
			System.out.println("Given String "+oldStr+"is Palindrome only");
		else
			System.out.println("Given String "+oldStr+"is Not Palindrome ");
}
	

	private static void palindromeStringBuffer(String str) {
		StringBuffer oldStr = new StringBuffer(str);
		StringBuffer newStr = new StringBuffer(str);
		newStr.reverse();
		
		if(oldStr.equals(newStr))
			System.out.println("Given String "+oldStr+" is Palindrome only");
		else
			System.out.println("Given String "+oldStr+" is Not Palindrome ");
	}

	private static void palindromeEfficentWay(String str) {
		int n = str.length();
		boolean isPalindrome = true;
		int m =n/2;
		if(n%2 ==0 ) {
			isPalindrome = isPalindromeRecursion(m-1, m,  str);
		}
		else {
			isPalindrome = isPalindromeRecursion(m-1, m+1, str);
		}

		if(isPalindrome)
			System.out.println("Given Word "+str+" is Palindrome only");
		else
			System.out.println("better luck next time!!!");
	}

	private static boolean isPalindromeRecursion(int n1, int n2, String word) {
		if(word.charAt(n1) != word.charAt(n2)) {
			isPalindromeRecursion(n1+1, n2-1, word);
			return false;
		} else
			return true;

	}
}
