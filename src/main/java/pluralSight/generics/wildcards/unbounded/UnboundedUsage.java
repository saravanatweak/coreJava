package pluralSight.generics.wildcards.unbounded;


import pluralSight.generics.wildcards.bounded.Person;

import java.util.ArrayList;
import java.util.List;

public class UnboundedUsage {
    public static void main(String[] args) throws ClassNotFoundException {
        List<Object> objects = new ArrayList<>();
        objects.add(new Object());
        objects.add(new Person("Don Draper", 89));
        System.out.println(objects);

        /** if you add List<?> It's not really safe to add in the object and it's not really safe to add in the person.why
         * when you do List<?></?>, synthetically it thinks ? extends Object>. It works in fact you can call getter methods
         * <B> But Here we're trying to mutate the array list. We're trying to put values in and we know that
         * if we want to put things in, we need use only super keyword, like <? super Object>, extends is getting used
         * only getting out the values from the list</B>
         * Now, what that means is there's no actual object that you can ever put in this List. The only value
         * that it is safe to pass in is null because that is the only value that can be coerced into any type that we know of.
         * */
        // Its only safe to add null to a List<?>
        List<?> wildcards = new ArrayList<>();
        wildcards.add(null);
        System.out.println(wildcards);

    }

}
