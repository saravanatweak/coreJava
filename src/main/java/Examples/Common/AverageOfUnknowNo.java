package Examples.Common;

public class AverageOfUnknowNo {

	public static void main(String[] args) {
	
		System.out.println(average(1,2,3,4,5));
		System.out.println("\n");
		System.out.println(average(1,2,3,4,5,6,7,8,9,10));

	}
	
	public static int average(int...numbers)
	{
		int total =0;
		for(int x:numbers)
			total=total+x;
		return total/numbers.length;
	}

	
}
