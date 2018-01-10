package CoreJava.JavaUtil.collections;


import java.util.Comparator;
import java.util.Objects;

public class Product {


    public static final Comparator<? super Product> BY_PRIZE =
            //in java 8 we have comparing method like this.
            /*Comparator.comparing(Product::getPrize);*/
            //Before Java 8 we have like this
            new Comparator<Product>() {
                @Override
                public int compare(Product p1, Product p2) {
                    return Integer.compare(p1.getPrize(), p2.getPrize());
                    /* Below is the acutual function done by Comapartor method
                    if (p1.getPrize() > p2.getPrize())
                        return 1;
                    else if (p1.getPrize() < p2.getPrize())
                        return 0;
                    else
                        return -1;*/
                }
            };

    //in Java 8 onwards
    public static final Comparator<Product> BY_NAME = Comparator.comparing(Product::getName);

    private final int id;
    private final String name;
    private final  int prize;


    public Product(int id, String name, int prize) {
        this.id = id;
        this.name = name;
        this.prize = prize;
    }

    public String getName() {
        return name;
    }

    public int getPrize() {
        return prize;
    }

    public int getId() { return id; }

    public String toString() {
        return "Name: " + name + " , "
                + "Weight: " + prize;
    }

    @Override
    public boolean equals(Object obj)
    {
        /** before java 7 */
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        final Product product = (Product) obj;
        if(prize != product.prize) return  false;

        //return (name != null ? !name.equals(product.name) : product.name != null);
        /** after java 7 */
        return Objects.equals(name, product.name);

    }

    @Override
    public int hashCode() {
        // Before java 7
        int result = name != null ? name.hashCode() : 0;
        //return  result = 31 * result + prize;
        //after java 7
        return Objects.hash(name, prize);

    }
}
