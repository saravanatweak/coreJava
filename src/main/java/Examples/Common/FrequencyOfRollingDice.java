package Examples.Common;
import java.util.Random;

public class FrequencyOfRollingDice {

	// In other way it can be called as:
	// Array Elements as Counters
	public static void main(String args[]){
		Random dice = new Random();
		int freq[] = new int[7];

		for(int roll=1;roll<1000;roll++){
			++freq[1+dice.nextInt(6)];
			//This is the way you can assign and access the array element
			//when needs to assign different values for a same array of index
			//Every time the array index value will get change based on the dice no
		}
		System.out.println("Dice no\t frequency");

		for(int diceno=1;diceno<freq.length; diceno++){
			System.out.println(diceno+"\t"+freq[diceno]);
		}

	}

}
