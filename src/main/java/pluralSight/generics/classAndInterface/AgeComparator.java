package pluralSight.generics.classAndInterface;

import java.util.Comparator;

/**
 * Created by SaravanaWork on 05-11-2017.
 */
public class AgeComparator implements Comparator<Person>{
    @Override
    public int compare(Person left, Person right) {
        return Integer.compare(left.getAge(), right.getAge());
}}
