package DesignPatterns.Behavioral.Template;

//what we're doing with our order template and the individual order cases that we have.
public class TemplatePatternExp {

    public static void main(String[] args) {
        System.out.println("Web Order:");

        OrderTemplate webOrder = new WebOrder();
        webOrder.processOrder();

        //Run as 2nd time
        //the beauty of this is we can add a whole other order type and we don't have to change our order template at all. The algorithm stays the same
        System.out.println("\nStore Order:");

        OrderTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder();

        /** OITPUT:
         * when we run it, we get all of our output for a web order and all of our output for a store order, completely different set of business rules or different implementation for each order, but the same algorithm or the same rules applies. It's just handled differently. A great pattern, a great way to reuse this in frameworks. You'll see it all the time with JDBC code and like Spring JDBC template, or other tools like that that you're mapping in data layers. It's a very powerful way to guarantee things get done in a certain order of operations. */
    }

}
abstract class OrderTemplate {

    public boolean isGift;
    public abstract void doCheckout();
    public abstract void doPayment();
    public abstract void doReceipt();
    public abstract void doDelivery();

    public final void wrapGift() {
        System.out.println("Gift wrapped.");
    }

    //shouldn't be over written by subclasses.
    public final void processOrder() {
        doCheckout();
        doPayment();
        if(isGift) {
            wrapGift();
        }
        else {
            doReceipt();
        }

        doDelivery();
    }

}

class WebOrder extends OrderTemplate {
    // after adding ORderTemplate method it will automaticall implements teh required methods into the class.
    //This is tempmpalte patter basic principle

    @Override
    public void doCheckout() {
        System.out.println("Get items from cart,");
        System.out.println("Set gift preferences,");
        System.out.println("Set delivery address,");
        System.out.println("Set billing address.");
    }

    @Override
    public void doPayment() {
        System.out.println("Process payment without Card present");
    }

    @Override
    public void doDelivery() {
        System.out.println("Ship the item to address");
    }

    @Override
    public void doReceipt() {
        System.out.println("Email receipt");
    }

}

class StoreOrder extends OrderTemplate {

    @Override
    public void doCheckout() {
        System.out.println("Ring up items from cart.");
    }

    @Override
    public void doPayment() {
        System.out.println("Process payment with Card present");
    }

    @Override
    public void doDelivery() {
        System.out.println("Bag items at counter");
    }

    @Override
    public void doReceipt() {
        System.out.println("Print receipt");
    }
}



