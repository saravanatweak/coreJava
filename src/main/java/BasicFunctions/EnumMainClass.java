package BasicFunctions;

import java.util.EnumSet; // will help you out to get the range of constants like from to concept

public class EnumMainClass {
	//todo: try to practise  more pgms on the same
	//Enum otherwise known as constants
	public static void main(String[] args) {

		for(EnumExamples love : EnumExamples.values())
			System.out.printf("%s\t%s\t%s\t\n",love,love.getMonth(),love.getDate());
		//Here we are printing love as one arqs as basically its an object of enum class variables

		System.out.println("****** Now We About to print range of Constants!!! *****");
		
		for(EnumExamples love: EnumSet.range(EnumExamples.prabha, EnumExamples.nithika) )
			System.out.printf("%s\t%s\t%s\t\n", love,love.getDate(), love.getMonth());
	}
	
/*	EnumExamples.values() : Anytime you make enum class or method, java automatically makes the build in array
							  by taking its constants  like < EnumClassName.Values()>
							  you cant change those values as its a static constants  
*/
}

enum EnumExamples {
	saravana("May", "12"),// these are essence objects
	prabha("Oct","19"),
	kalai("Aug","31"),
	nikil("Nov" ,"28"),
	nithika("Feb","13"),
	padmashri("Dontknow","14");

	//Declaring two variables to represent args
	private final String month;
	private final String date;

	EnumExamples(String birthMonth, String birthDate){
		month = birthMonth;
		date = birthDate;
	}

	public String getMonth() {
		return month;
	}

	public String getDate() {
		return date;
	}

}
