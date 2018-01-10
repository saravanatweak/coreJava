package Examples.Common;


public class Factorial {

	public static void main(String[] args) {
		int n = 60, n1=60;
		int result=1, result1 =1;
	//In While
		while(n1 >0 )
		{
			result1 *= n1;
			n1--;
		}
		System.out.println(result1);
	//In For loop	
		for(int i=1; i<=n; i++)
		{
			result *= i;
			
		}
		System.out.println(result);
	// In recursion mode
		System.out.println(factorial(n));
		
	}
	
	//Recursion method
	 public static int factorial(int n) {
	       if (n == 0) {
	           return 1;
	       } else {
	           return n * factorial(n - 1);
	       }
	   }

}
