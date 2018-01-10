package CoreJava.JavaUtil.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ComparatorWithoutGeneric {
    public static void main(String args[]) {
        ArrayList al=new ArrayList();
        al.add(new StudentComparator(101,"Vijay",23));
        al.add(new StudentComparator(106,"Ajay",27));
        al.add(new StudentComparator(105,"Jai",21));

        System.out.println("Sorting by Name...");
        Collections.sort(al, new NameComparatorWithoutGeneric());


        Iterator itr=al.iterator();
        while(itr.hasNext()){
            StudentComparator st=(StudentComparator)itr.next();
            System.out.println(st.rollno+" "+st.name+" "+st.age);
        }

        System.out.println("\nSorting by age...");
        Collections.sort(al, new AgeComparatorWithoutGeneric());

        Iterator itr1=al.iterator();
        while(itr1.hasNext()){
            StudentComparator st1=(StudentComparator)itr1.next();
            System.out.println(st1.rollno+" "+st1.name+" "+st1.age);
        }
    }
}
class StudentComparator {
    int rollno;
    String name;
    int age;
    StudentComparator(int rollno,String name,int age){
        this.rollno=rollno;
        this.name=name;
        this.age=age;
    }
}
class AgeComparatorWithoutGeneric implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        StudentComparator s1 = (StudentComparator) o1;
        StudentComparator s2 = (StudentComparator) o2;

        if(s1.age == s2.age)
            return 0;
        else if(s1.age > s2.age)
            return 1;
        else
            return -1;
    }
}
class NameComparatorWithoutGeneric implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        StudentComparator s1 = (StudentComparator) o1;
        StudentComparator s2 = (StudentComparator) o2;

        return s1.name.compareTo(s2.name);
    }
}
