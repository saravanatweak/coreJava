package BasicFunctions;

public class FinalMain {
	
	public static void main(String args[]){
		
		FinalVar finalObj = new FinalVar(5);
		
		for(int i=1;i<=5;i++){
			finalObj.add();
			System.out.println(i+ " time value is " +finalObj);
		}
		
		//So once the final value got initialized,it never gonna change through out its life. 
		//What if if i try to change it ? just uncomment the below line and see yourself.
		//finalObj.NUMBERS = 2;
	}
		
}

class FinalVar {

	private int sum;
	private final int NUMBERS;

	FinalVar ( int x){
		NUMBERS = x;
	}

	public void add(){
		sum += NUMBERS;
	}

	public String toString(){
		return String.format("%s", sum);
	}

}