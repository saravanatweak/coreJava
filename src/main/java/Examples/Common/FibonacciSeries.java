package Examples.Common;

import java.util.HashMap;
import java.util.Map;

/***
 * In fibonacci series, next number is the sum of previous two numbers for example 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 etc. 
 * The first two numbers of fibonacci series are 0 and 1. 
 */

public class FibonacciSeries {
	public static void main(String args[]) {
        //Non Recursion 
        fibonacci(6);
        fibonacci(7);
        //Recursion 
        fibonacciSeries(8);
        fibonacciSeries(9);
        //Memoization using map
        System.out.println(improvedFibo(8));
        System.out.println(improvedFibo(9));
    }

    /*
     * Printing Fibonacci series of a given number using for loop
     */
    public static void fibonacci(int number) {
        int number1 = 0;
        int number2 = 1;

        System.out.printf("%nFibonacci series of %d numbers are : ", number);
        System.out.printf("%s ", number1);


        for (int i = 2; i <= number; i++) {
            int fibonacci = number1 + number2;
            System.out.printf("%s ", fibonacci);
            number2 = number1;
            number1 = fibonacci;
        }
    }

    public static void fibonacciSeries(int number) {
        System.out.printf("\nFibonacci series in Java of number %s using recursion %n", number);
        for (int i = 0; i <= number; i++) {
            System.out.printf("%s ", getFibonacci(i));
        }
    }
    /*
     * Fibonacci series in Java of a given number Recursion.
     */
    public static int getFibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return getFibonacci(n - 1) + getFibonacci(n - 2); // tail recursion
    }

    /* * Java Program to calculate Fibonacci numbers with memorization 
     * * This is quite fast as compared to previous Fibonacci function 
     * * especially for calculating factorial of large numbers. */ 
	public static int improvedFibo(int number)
	{ 
		Map<Integer, Integer > cache = new HashMap<>();
		Integer fibonacci = cache.get(number); 
		if(fibonacci != null)
			return fibonacci; //fibonacci number from cache 
		//fibonacci number not in cache, calculating it 
		fibonacci = getFibonacci(number); //Calling the recursion method
		//putting fibonacci number in cache for future request 
		cache.put(number, fibonacci); 
		return fibonacci; 
	}
		
	}

    


