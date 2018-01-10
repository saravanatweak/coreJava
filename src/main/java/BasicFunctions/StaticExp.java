package BasicFunctions;

public class StaticExp {

	public static void main(String[] args) {
		StaticVariable obj1 = new StaticVariable("Saravana", "kumar");
		StaticVariable obj2 = new StaticVariable("Nesha", "Prabha");
		
		/*From the above example you could see whenever the second obj get created the static member variable is
		 * incremented and it holds the value of 2 but for obj1 name is still same but its static variable 
		 * value is now assigned into 2. if you want believe that please see the below code
		 */
				
		System.out.println("2nd obj name is: "+ obj2.getNames() + " member variable value is "+ obj2.getMembers());
		//here is the truth
		System.out.println("1st obj name is: "+ obj1.getNames() + " But Member variable is "+obj1.getMembers());
		
		// And the beautiful part is without creating objects we can access the static variables from the class. How?\
		 //Because Static means this variable(Static variable) shares among all the objects. Hence on obj init required :D
		
		System.out.println(StaticVariable.getMembers());
								
	}
}

class StaticVariable {

	private String first;
	private String second;
	private static int members = 0;//static: Every object of this class shares the same variable. If this one changes(variable) it will change all the objects.
	// 		 E.g: for obj1.member = 1, for obj2.member=2 and BUT now for obj1.member=2 and so on.

	StaticVariable (String fn, String sn){
		first = fn;
		second = sn;
		members ++;

		System.out.printf("Contructor for %s%s, and he/she is positon at: %d \n", first, second, members);
		System.out.println("static varibale(member)value is: " +members);
		System.out.println();
	}

	//for 2nd part main class
	public static int getMembers(){
		return members;
	}
	public String getNames(){
		return first+second;
	}

}
