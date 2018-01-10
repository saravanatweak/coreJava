package CoreJava.newBoatsMan.classWithSubClass;

import java.util.Scanner;

public class InstanceMethodExpMain {
	
	private static Scanner input;
	public static void  main(String args[])
	{
		InstanceMethodExpSub subClass = new InstanceMethodExpSub();
		
		System.out.println("Enter your first jobName: ");
		
		input = new Scanner(System.in);
		String name = input.nextLine();
		
		subClass.setName(name);
		subClass.asking();
	}
	

}
