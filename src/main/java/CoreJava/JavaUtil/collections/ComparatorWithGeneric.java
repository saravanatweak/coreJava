package CoreJava.JavaUtil.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
//TODO:Add missing Student class 
public class ComparatorWithGeneric {
    /*
    public static void main(String args[]) {
        ArrayList al=new ArrayList();
        al.add(new Student(101,"Vijay",23));
        al.add(new Student(106,"Ajay",27));
        al.add(new Student(105,"Jai",21));

        System.out.println("Sorting by Name...");
        Collections.sort(al, new NameComparatorWithGeneric());


        Iterator itr=al.iterator();
        while(itr.hasNext()){
            Student st=(Student)itr.next();
            System.out.println(st.rollno+" "+st.name+" "+st.age);
        }

        System.out.println("\nSorting by age...");
        Collections.sort(al, new AgeComparatorWithGeneric());

        Iterator itr1=al.iterator();
        while(itr1.hasNext()){
            Student st1=(Student)itr1.next();
            System.out.println(st1.rollno+" "+st1.name+" "+st1.age);
        }
    }
}

class AgeComparatorWithGeneric implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {

        if(s1.age == s2.age)
            return 0;
        else if(s1.age > s2.age)
            return 1;
        else
            return -1;
    }
}
class NameComparatorWithGeneric implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
    */
}

