package CoreJava.JavaUtil.collections.List;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExp {
    String name;
    int rollNo;
    int age;

    ArrayListExp(int age, String name, int rollNo) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;

    }

    public static void main(String args[]) {

        ArrayList<String> al = getArrayList1("Saravana", "Prabha", "Nithika");
        ArrayList<String> al2 = getArrayList1("Saravana", "Nikil", "Nethra");

        //Calling normal ArrayList
        //NormalArrayListExp(al);

        //USer defined class object in ARray List
        // UserDefinedClassInArrayList();

        //Example of Retainall method.
        al.retainAll(al2);//is used to delete all the elements of invoking collection except the specified collection.
        for (String s : al)
            System.out.println(s);

    }

    private static ArrayList<String> getArrayList1(String... names) {
        ArrayList<String> al = new ArrayList<String>();//Creating Arraylist
        for (String s : names)
            al.add(s);
        return al;
    }

    public static void NormalArrayListExp(ArrayList<String> al) {

        Iterator itr = al.iterator();//getting Iterator from arraylist to traverse elements
        while (itr.hasNext())
            System.out.println(itr.next());
        System.out.println("\n");
        for (String s : al)
            System.out.println(s);
    }


    public static void UserDefinedClassInArrayList() {
        //Creating user-defined class objects
        ArrayListExp s1 = new ArrayListExp(101, "Sonoo", 23);
        ArrayListExp s2 = new ArrayListExp(102, "Ravi", 21);
        ArrayListExp s3 = new ArrayListExp(103, "Hanumat", 25);

        ArrayList<ArrayListExp> classAl = new ArrayList<ArrayListExp>();
        classAl.add(s1);    //adding Student class object
        classAl.add(s2);
        classAl.add(s3);

        Iterator itr = classAl.iterator();
        while (itr.hasNext()) {
            ArrayListExp s = (ArrayListExp) itr.next();
            System.out.println(s.name + " " + s.rollNo + " " + s.age);
        }
    }
}

