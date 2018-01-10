package DesignPatterns.Creational.AbstractFactory;

/**
 * Created by Saravanakumar_K05 on 11/21/2017.
 */
public class AbstractFactoryExp {
    public static void main(String[] args) {

        //, this is named abstract just to show you which that factory is. The only thing it knows and passes into it is saying hey, I want to get a CreditCardFactory based on the score we are passing.
        CreditCardFactory abstractFactory = CreditCardFactory.getCreditCardFactory(775);

        //now get me the credit card, based on the score you’ll get a platinum or gold credit card. So it will come back and say great, I'm going to go ahead and give you a platinum/gold credit card based off that factory,
        //so no knowledge of how that was created or what was done is passed back to the client.
        CreditCard card = abstractFactory.getCreditCard(CardType.PLATINUM);

        System.out.println(card.getClass());

        abstractFactory = CreditCardFactory.getCreditCardFactory(600);

        CreditCard card2 = abstractFactory.getCreditCard(CardType.GOLD);

        System.out.println(card2.getClass());
    }
}
