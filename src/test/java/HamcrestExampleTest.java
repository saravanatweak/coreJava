import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class HamcrestExampleTest
{

    @Test
    public void mapShouldContainValue()
    {
        Map<String, Integer> values = getValues();

        //beofre hamcrest
        //assertTrue(values.containsKey("B")); // test will fail bcz
        /*test is failing here because we're checking it's got a capital B and our map only contains a lowercase b, so that's a bit of a problem. What we actually want to do is have a way of checking the map has really good diagnostics, and Hamcrest gives us that*/

        //AFter hamcrest
        assertThat(values, hasKey("B"));
        //takes an actual value, left-hand side first, and then a matcher.

        /*o/p : u will get thie below error
        java.lang.AssertionError:
        Expected: map containing ["B"->ANYTHING]
        but: map was [<A=1>, <b=2>]

            so from the result you can change the values according to the map values if you want. can be passed

          */
    }

    private Map<String, Integer> getValues()
    {
        final HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("b", 2);
        return map;
    }

    @Test
    public void listOrderingIsIrrelevant()
    {
        List<Integer> numbers = getNumbers();

        //Before hamcrest
        //Now what we've got is we've got a sequence of numbers, 1, 2, 3, 5, 4, and the test wants to check that the number 5 is in the list.
        //. So given they're mostly in order, it's tried to get the index of 4 out and realized it's 4 when it should be 5.
        //assertEquals(5, (int) numbers.get(4)); // so it will fail

        //aftr hamcrset
        assertThat(numbers, hasItem(5));
    }

    private List<Integer> getNumbers()
    {
        return Arrays.asList(1, 2, 3, 5, 4);
    }

    //Otuput:

    //very fist both the methods will fail
}