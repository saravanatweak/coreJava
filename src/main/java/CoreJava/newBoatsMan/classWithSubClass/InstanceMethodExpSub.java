package CoreJava.newBoatsMan.classWithSubClass;

public class InstanceMethodExpSub {

	private String jobName;
	
	public void setName(String name){
		jobName = name; 
	}
	
	public String getName(){
		return jobName;
	}
	
	public void asking(){
		System.out.printf("My fist job name was %s", getName());
	}
}
