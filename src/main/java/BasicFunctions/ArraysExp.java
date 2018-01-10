package BasicFunctions;
import java.util.Random;


public class ArraysExp {

	public static void main(String args[])
	{
		arrrayWithRandomNoGen();

		adding2DArray();

		arrayCopyDemo();

		mutlipleArrayHandling();

	}

	private static void arrrayWithRandomNoGen() {
		Random dice = new Random();
		//one type of initialization. it will store values like
		// Lorry[0] =<value>,Lorry[1]=<value>...........Lorry[5]=<value>
		int Lorry[] = new int[6];

		for(int count=0; count<Lorry.length; count++){
			Lorry[count] = 1+dice.nextInt(6);
			System.out.println("Lorry ["+count+"] is: " +Lorry[count] );

		}
		System.out.println("\n");
		System.out.println("In another way of printing the array");
		System.out.println(" Index\tvalue");
		for (int index=0; index<Lorry.length;index++){
			System.out.println(index +"\t"+Lorry[index] );
		}
	}

	private static void adding2DArray() {
		int a[][] = {{1,2,3},{1,2,3}};
		int b[][] = {{4,5,6},{4,5,6}};

		int add[][] = new int[a.length][a[0].length];

		for(int row=0;row<a.length;row++){
			for(int col=0;col<a[row].length;col++){
				add[row][col] = a[row][col] + b[row][col];
				System.out.print(add[row][col]+" ");
			}
			System.out.println();//next row
		}
	}

	private static void arrayCopyDemo() {
		char[] copyFrom = {'s','a','r','a','v','a','n',
				'a','k','u','m','a','r'};
		char[] copyTo = new char[8];

		System.arraycopy(copyFrom,0,copyTo,0,8);
		System.out.println(new String(copyTo));

		System.out.println("\n");
		// In java, array is an object. For array object, an proxy class is
		// created whose name can be obtained by getClass().getName() method on the object.
		Class c = copyFrom.getClass();
		System.out.println(c.getName());
	}

	private static void mutlipleArrayHandling() {
		int firstArray[][] = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
		String secondArray[][] = {{"1", "", ""}, {"", "2", ""}, {"", "", "3"}};
		int[] varArgsExample = {1,2,3,4,5,6,7,8,9,10};

		System.out.println("This is the first array in integer format");
		multiArrayInt(firstArray); //passing array through method
		System.out.println("This is my second array in String format");
		multiArrayString(secondArray);
		System.out.println("Passing Array via variable lenght args");
		// Variable length args (<type>...)
		// when you want to pass the n no of not knowing args into the methods it will use.
		// neverless, it will be passed as Array only things.
		passingArrayMethod(varArgsExample);
	}

	public static void multiArrayInt(int x[][]){
		for(int row=0;row<x.length; row++){
			for(int col=0;col<x[row].length;col ++){
				System.out.print(x[row][col]+"\t");
			}
			System.out.println("\t");
		}
	}

	public static void multiArrayString(String x[][]){
		for(int row=0;row<x.length; row++){
			for(int col=0;col<x[row].length;col ++){
				System.out.print(x[row][col]+"\t");
			}
			System.out.println("\t");
		}
	}

	public static void passingArrayMethod(int...NotKNowingArgs){
		int total = 0;
		for(int x : NotKNowingArgs)
			total += x;

		System.out.println("The average of first array:\t"+total/NotKNowingArgs.length );
	}

}
