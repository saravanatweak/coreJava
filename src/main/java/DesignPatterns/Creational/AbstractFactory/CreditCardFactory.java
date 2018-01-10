package DesignPatterns.Creational.AbstractFactory;

/**
 * Desing:
 * This implements a factory for creating credit cards, so basically think of it as you're submitting an application for a credit card. This application's going to choose for you and create the right credit card based off of the criteria you put in.
 *basically the logic behind this is is that you're going to apply for a card, we're going to give you back the card you qualify for, and then we're going to validate that you can actually have the card that you say you have access to.
 */
//AbstractFactory
public abstract class CreditCardFactory {
//now we have our AbstractFactory, which is our CreditCardFactory, that determines which factory should be chosen.
    public static CreditCardFactory getCreditCardFactory(int creditScore) {

        if (creditScore > 650) {
            return new AmexFactory();
        } else {
            return new VisaFactory();
        }
    }
    /*Now the way an AbstractFactory works is there are also some interfaces that we're going to pass through to our concrete classes and concrete factories down below*/

    public abstract CreditCard getCreditCard(CardType cardType);

    public abstract Validator getValidator(CardType cardType);

    /**FLOW:
     * If we go through our AbstractFactory, which is our CreditCardFactory, it just determines which factory to use. Again, it's not telling us how to create the card. It's not telling us what should be returned based off that. It just says hey, this is the factory you need based off the parameters you gave me. And there are no variables stored here. There are no values stored here. It's just a collection of multiple factories here.
     * Notice our AmexFactory knows nothing of our VisaFactory, but they both tie in the common interface of our CreditCardFactory, and then we have a CreditCard and a Validator. Again, that common interface that's going to get passed back throughout all of our factories. Our CreditCard is actually an abstract class, not an interface, but just to mix it up I created a Validator interface that is in fact an interface. So to show you how both of those tie together from our CreditCardFactory, we have our common interface of the CreditCardFactory, as well as our common interface of our CreditCard and our Validator that gets returned. Then we go into our ConcreteFactory, and from the ConcreteFactory we actually go ahead and create our instance and handle our validation. */

    /*OUTPUT :
    * This is what we're trying to do with the pattern, showing that the creation logic is not known by the client. In fact, it's not even known by the AbstractFactory. It just knows to defer that to the right factory, and then it handles it from there. So our individual factories know about their creation logic, and they've got grouping of similar features, so they both have validators, they both have credit cards. */
}

class VisaFactory extends CreditCardFactory { //concrete factorie or factory methods

    @Override
    public CreditCard getCreditCard(CardType cardType) {
        switch (cardType) {
            case GOLD:
                return new VisaGoldCreditCard();//Here
            case PLATINUM:
                return new VisaBlackCreditCard();

        }

        return null;
    }

    /*I'm just using the default no-args constructor in the factory below because I really don't care about that implementation of this detail. I'm more concerned about the AbstractFactory.*/


    @Override
    public Validator getValidator(CardType cardType) {
        return new VisaValidator();
    }

}

class AmexFactory extends CreditCardFactory {
/*now we have our factory in place that's going to go ahead and defer to this instance to create what is being returned. So whatever the credit card is, whatever the creation of that credit card is, our parent class has no knowledge of what's going on here or how those were created though. So our AbstractFactory, it barely even knows which factory we've chosen let alone what type of credit card's going to get returned. It doesn't know if it's a platinum versus a gold card or whatever other cards we have implemented there. It also doesn't know how those objects were created down there. */
    @Override
    public CreditCard getCreditCard(CardType cardType) {
/*Note :Now this is one of the things people don't like about the AbstractFactory, so we're going to say switch. I'm going to do cardType*/
        switch (cardType) {
            case GOLD:
                return new AmexGoldCreditCard();//here, we are calling the no-args constructor here. If we wanted to do the template method pattern, we could do a template method, a factory template method that would go ahead and call the appropriate instance down below. We can also choose some things based off a constructor.Go ahead and look at the factory pattern though. We don't need to belabor it in this example

            case PLATINUM:
                return new AmexPlatinumCreditCard();

            default:
                break;
        }

        return null;
    }

    @Override
    public Validator getValidator(CardType cardType) {

        switch (cardType) {
            case GOLD:
                return new AmexGoldValidator();

            case PLATINUM:
                return new AmexPlatinumValidator();

        }

        return null;
    }
}


enum CardType {
    GOLD, PLATINUM;
}

