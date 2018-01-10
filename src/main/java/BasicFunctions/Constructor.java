package BasicFunctions;

public class Constructor {// used to set the values during object creation or initialization
	
	public static void main(String args[])
	{
		/** A constructor is a special method that is used to initialize a newly created object. 
		 * It is called soon after the memory is allocated for the object. 
		 * Constructors are used to initialize the objects to the user-defined or default values at the time of object creation.
		 */
		/** Normally the variable get initialized by default value while creating the object of that class 	*/

		//Normal Object Initialization o/w called default constructor
		new WithoutConstructor().saying(); // no constructor is defined in this class. so, supposed to say no name got initialized
		
		/** Example of passing variable while creating object i:e, passing through constructor 	*/
		//With Constructor initialization o/w called parametrized constructor"
		 new WithConstructor("Nithya").sayingFirstGF();

		/** Below is the example of passing variables while creating object i:e, passing through constructor along with two different variables */
		//With Constructor initialization with multiple parameters
		ConstructorWithGetAndSet obj = new ConstructorWithGetAndSet();
		ConstructorWithGetAndSet obj2 = new ConstructorWithGetAndSet(12);
		ConstructorWithGetAndSet obj3 = new ConstructorWithGetAndSet(15,13);
		ConstructorWithGetAndSet obj4 = new ConstructorWithGetAndSet(15,13,12);

		System.out.println("Printing constructor in 24 hour format");
		System.out.println(obj.to24Format());
		System.out.println(obj2.to24Format());
		System.out.println(obj3.to24Format());
		System.out.println(obj4.to24Format() +"\n");

		System.out.println("printing constructor in 12 hour format");
		System.out.println(obj.to12Format());
		System.out.println(obj2.to12Format());
		System.out.println(obj3.to12Format());
		System.out.println(obj4.to12Format());

	}
}

class WithoutConstructor {

	private String girlName;
	public String getGirlName()
	{
		return girlName;
	}
	public void saying()	{
		System.out.printf("My first girl friend was %s ", getGirlName()== null ?
				"It is not variable declaration. Hence default value null is printed" : getGirlName());
	}
}
class WithConstructor {

	private String girlName;
	public WithConstructor(String name)
	{
		girlName = name;
	}
	public String getGirlName()
	{
		return girlName;
	}
	public void sayingFirstGF()
	{
		System.out.printf("My first girl friend was %s ", getGirlName());
	}
	public void sayingSecondGF()
	{
		System.out.printf("My Second girl friend was %s ", getGirlName());
	}public void sayingThirdGF()
	{
		System.out.printf("My Thrird girl friend is %s ", getGirlName());
	}
}

class ConstructorWithGetAndSet {

	private int hour ;
	private int minute;
	private int second;

	public ConstructorWithGetAndSet()
	{
		this(0,0,0); //overloaded constructor, it will invoke again another constructor which have 3 args as input
	}
	public ConstructorWithGetAndSet(int h){
		this(h,0,0);
	}
	public ConstructorWithGetAndSet(int h, int m){
		this(h,m,0);
	}
	public ConstructorWithGetAndSet(int h, int m, int s){
		setTime(h,m,s);
	}

	public void setTime(int h, int m, int s){
		setHour(h);
		setMinute(m);
		setSecond(s);
	}

	public void setHour(int h){ hour = ((h>0 && h<24) ? h:0); 	}
	public void setMinute(int m){ minute =((m>0 && m<60) ? m:0); 	}
	public void setSecond(int s){ second =((s>0 && s<60) ? s:0); 	}
	public int getHour()	{		return  hour; }
	public int getMinute() { return minute; }
	public int getSecond() { return second; };

	public String to24Format(){
		return String.format("%02d:%02d:%02d", getHour(),getMinute(),getSecond() );
	}
	public String to12Format(){
		return String.format("%s:%02d:%02d %s", ((getHour() <=12 ? getHour() : getHour()%12 )), getMinute(), getSecond(), getHour()<12 ? "AM":"PM");
	}
}

