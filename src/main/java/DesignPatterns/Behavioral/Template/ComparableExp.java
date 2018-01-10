package DesignPatterns.Behavioral.Template;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExp {

    public static void main(String args[]) {
        WithoutComparable s = new WithoutComparable("saravana", "12345", 29);
        WithoutComparable p= new WithoutComparable("Prabha", "23456", 25);
        WithoutComparable n= new WithoutComparable("Nithika", "34567", 3);

        List<WithoutComparable> people = new ArrayList<>();
        people.add(s);
        people.add(p);
        people.add(n);

        //Collections.sort(people);
        //if you uncomment the above method your will get an error, is going to complain because the array list of people or the person objects are not a comparable instance that I can call sort on.
        // So the sort is looking for a template method of the comparable interface to sort them on.

        WithComparable saravana = new WithComparable("saravana", "12345", 29);
        WithComparable prabha = new WithComparable("Prabha", "23456", 25);
        WithComparable nithika = new WithComparable("Nithika", "34567", 3);

        List<WithComparable> people1 = new ArrayList<>();
        people1.add(saravana);
        people1.add(prabha);
        people1.add(nithika);


        System.out.println("Not sorted");
        printContents(people1);

        Collections.sort(people1);// Becase Now the class (withComparable) implemetns the Comparable interface

        System.out.println("\nSorted by age");
        printContents(people1);
    }

    private static void printContents(List<WithComparable> people) {
        for (WithComparable person : people) {
            System.out.println(person.getName());
        }
    }


}

class WithoutComparable {

    private int age;
    private String name;
    private String phoneNumber;

    public WithoutComparable() { }

    public WithoutComparable(String name, String phoneNumber, int age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }
}

class WithComparable implements Comparable<WithComparable> {

    private int age;
    private String name;
    private String phoneNumber;

    public WithComparable() { }

    public WithComparable(String name, String phoneNumber, int age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //This is hte Template method. It wants us to implement this compareto method that's part of the template method pattern of that interface.
    //So we've implemented this interface, telling us that we have to provide this functionality to pass into that sort method.
    //This method is what's implementing our algorithm or our sorting functionality for that larger sorting method from that collections class
    @Override
    public int compareTo(WithComparable obj) {

        if(this.age > obj.age) {
            return 1;
        }

        if(this.age < obj.age) {
            return -1;
        }

        return 0;
    }
}


