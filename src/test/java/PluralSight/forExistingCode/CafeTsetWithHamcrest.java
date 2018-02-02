package PluralSight.forExistingCode;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;

public class CafeTsetWithHamcrest {


    public static final int ESPRESSO_BEANS = CoffeeType.Espresso.getRequiredBeans();
    public static final int NO_MILK = 0;
    public static final int NO_BEANS = 0;

    private Cafe cafe;

    //Using ths we can remove the Cafe object creatino all the time for all the methods
    @Before
    public void before() {
        cafe = new Cafe();
    }

    @Test
    public void canBrewEspresso(){

        //Given clause
        withBeans();

        //Wehn Clause
        CoffeeBean coffee = cafe.brew(CoffeeType.Espresso);

        //Then clause
        assertEquals("Wrong no of beans", ESPRESSO_BEANS, coffee.getType());//
        //What we want to do is be able to replicate that kind of good quality diagnostic without having to rewrite the message and the assertEquals every time, and Hamcrest allows us to do that with compositional matchers. So a compositional matcher is a matcher that will take another matcher as a parameter.
        //so the above line can be changed into// try to test by cahnging cafe.brew method return new CoffeeBean(coffeeType, 0, requiredMilk);
        //assertThat(coffee, hasProperty("Beans", equalTo(ESPRESSO_BEANS)));
        assertEquals("Wrong amt of milk", NO_MILK, coffee.getMilk());
        assertEquals("Wrong coffee type" , NO_BEANS, coffee.getBeans());
    }


    @Test
    public void brewingEspressoConsumesBeans() {
        //Given clause
        withBeans();

        //Wehn Clause
        CoffeeBean coffee = cafe.brew(CoffeeType.Espresso);

        //Then
        assertEquals(0, cafe.getBeansInStock());
        //if you change to 0 to 1 you will get an error rather than failure, see the Junint doc for more detail

    }
    /*Above is error case */


    /*Below one is for failure case*/
    //how are we going to test the idea that if we're brewing a latte that it requires milk?
    /* So in this case, conceptually we're going to try and brew a latte, and we're not going to have enough milk in stock in our cafe, and so the brewing operation is going to fail, and it's going to fail exceptionally*/
    //if you run with @Test only it will through IlegalStage exception. thats waht excepted behaviour
    //So in order to show and pass the test case, we using like @Test(expected = IllegalStateException.class)
    @Test(expected = IllegalStateException.class) // So here this part will act as Then Clause
    public void lattesRequireMilk() {
        // given
        withBeans();

        // when
        cafe.brew(CoffeeType.Latte);
    }

    @Test
    public void canBrewLatte() {
        // given
        withBeans();
        cafe.restockMilk(227);

        // when
        CoffeeBean coffee = cafe.brew(CoffeeType.Latte);

        // then
        //assertTrue(CoffeeType.Latte == coffee.getType());
        //the above code will fail if the coffee.brew method returns like return  new CoffeeBean(null, requiredBeans, requiredMilk);
        //As becasue assertTrue can't handle the null values so it should be covnerted into

        assertEquals("Coffee type is worng",CoffeeType.Latte, coffee.getType());
        //So you will get an better view of an error rather only seeing the test case failure.
    }


    private void withBeans() {
        //Cafe cafe = new Cafe(); // Because this was added into @Before method hence it can be removed from here
        //cafe.restockBeans(); // can be coverted to use an Efficient way like
        cafe.restockBeans(ESPRESSO_BEANS);

        //return cafe;
    }
}