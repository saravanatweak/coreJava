package pluralSight.generics.classAndInterface;

import java.util.*;

public class TestClass {

    public static void main(String[] args) {

        Person saravana = new Person("Saravana", 29);
        Person prabha   = new Person("Prabha",25);
        Person nithika  = new Person("Nithika", 2);


        List<Person> personsObj = new ArrayList<>();

        personsObj.add(prabha );
        personsObj.add(saravana);
        personsObj.add(nithika);

        //Using existing available methods for sorting
        /*System.out.println(personsObj);
        Collections.sort(personsObj, new AgeComparator());

        System.out.println(personsObj);
        Collections.sort(personsObj, new ReverseAgeComparator<>(new AgeComparator()));

        System.out.println(personsObj);*/

        //Generics on methods [ using custom code for sorting]

        //without implementing generic on method
        final Person loworder = (Person) min1(personsObj, new AgeComparator());
        System.out.println(loworder);
        //With implementing generic on method
        final Person loworder1 =  min(personsObj, new AgeComparator());
        System.out.println(loworder);

        //Even you can use it for another lists as well for example
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        System.out.println(min(numbers, Integer::compare ));
    }

    private static Object min1(List listPerson, Comparator comparator) {
        Object lowEle = listPerson.get(0);
        for (int i = 1; i < listPerson.size(); i++) {
            final Object element = listPerson.get(i);
            if(comparator.compare(element, lowEle) <0)
                lowEle = element;
        }
        return lowEle;
    }

    private static <T> T min(List<T> listPerson, Comparator<T> comparator) {
        T lowEle = listPerson.get(0);
        for (int i = 1; i < listPerson.size(); i++) {
            final T element = listPerson.get(i);
            if(comparator.compare(element, lowEle) <0)
                lowEle = element;
        }
        return lowEle;
    }


}