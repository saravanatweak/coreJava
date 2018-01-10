package CoreJava.JavaLang;


public class ToString {
    public static void main(String args[]){
        System.out.println("Without ToSring method");
        ToStringSubClassWithoutToString withoutToString = new ToStringSubClassWithoutToString(2015,02,13);
        System.out.println(withoutToString + "\n");

        System.out.println("with ToString method");
        ToStringSubClass withToString = new ToStringSubClass(2015,02,13);
        System.out.println(withToString +"\n");

        System.out.println("Passing Obect as String ");
        ObjectAsString objectString = new ObjectAsString("Nithikashree", withToString);
        System.out.println(objectString);

        String s1 ="Saravana";
        String s2 = s1.intern();

    }

}

class ToStringSubClassWithoutToString {

    private int year;
    private int month;
    private int date;

    public ToStringSubClassWithoutToString(int y, int m, int d){
        year=y;
        month=m;
        date=d;

        System.out.printf("Constructor with format %s\n", this);
        // Here, "this" keyword is just a reference to an object we just build whenever we call this class
    }
}

class ToStringSubClass {

    private int year;
    private int month;
    private int date;

    public ToStringSubClass(int y, int m, int d){
        year=y;
        month=m;
        date=d;

        System.out.printf("Constructor with format %s\n", this);
        // Here, "this" keyword is just a reference to an object we just build whenever we call this class
    }

    public String toString(){
        return String.format("%d-%d-%d", date, month, year);
    }
    // Anytime you use "this" keyword its represents to current object. applies that needs a String
}

class ObjectAsString { // Otherwise the class is called as "Composition".'

	private String name;
	private ToStringSubClass theBirthDay;

	public ObjectAsString(String theName, ToStringSubClass birthDay)
	{
		name = theName;
		theBirthDay = birthDay;
	}

	public String toString(){
		return String.format("Name is: %s\nThe birth Date is:  %s", name, theBirthDay);
	}
	// General: Anytime if you want to use one object of a class as String,then the corresponding class
    // toString(java inbuild method, you can modify) will invoke and help you out to get it done.
}

