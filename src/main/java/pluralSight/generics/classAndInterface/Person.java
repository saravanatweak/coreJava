package pluralSight.generics.classAndInterface;

import java.util.Objects;

/**
 * Created by SaravanaWork on 03-11-2017.
 */
public class Person {

    private final String name;
    private final int age;


    public Person(String name, int age) {
        Objects.requireNonNull(name);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString(){
        return "[ Name is:  "+getName() +", age is: "+getAge()+" ]";
    }

}
