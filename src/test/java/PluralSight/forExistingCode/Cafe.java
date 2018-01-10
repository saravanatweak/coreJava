package PluralSight.forExistingCode;

/**
 * Created by Saravanakumar_K05 on 11/22/2017.
 */
public final class Cafe {

    private int beansInStock = 0;
    private int milkInStock = 0;

    public CoffeeBean brew(CoffeeType coffeeType) {
        return brew(coffeeType, 1);
    }

    public CoffeeBean brew(CoffeeType coffeeType, int strength) {
        requirePositive(strength);

        int requiredBeans = coffeeType.getRequiredBeans() * strength;
        int requiredMilk = coffeeType.getRequiredMilk() * strength;
        if (requiredBeans > beansInStock || requiredMilk > milkInStock) {
            throw new IllegalStateException();
        }

        beansInStock -= requiredBeans;
        milkInStock -= requiredMilk;
        //return new CoffeeBean(coffeeType, requiredBeans, requiredMilk);
        return  new CoffeeBean(null, requiredBeans, requiredMilk);
    }

    public void restockBeans(int weightInGrams) {
        requirePositive(weightInGrams);
        beansInStock += weightInGrams;
    }

    public void restockMilk(int weightInGrams) {
        requirePositive(weightInGrams);
        milkInStock += weightInGrams;
    }

    private void requirePositive(int value) {
        if (value < 1) {
            throw new IllegalArgumentException();
        }
    }

    public int getBeansInStock() {
        return beansInStock;
    }

    public int getMilkInStock() {
        return milkInStock;
    }
}

enum CoffeeType {
    Espresso(7, 0),
    Latte(7, 227),
    FilterCoffee(10, 0);

    private final int requiredBeans;
    private final int requiredMilk;

    CoffeeType(int requiredBeans, int requiredMilk) {
        this.requiredBeans = requiredBeans;
        this.requiredMilk = requiredMilk;
    }

    public int getRequiredBeans() {
        return requiredBeans;
    }

    public int getRequiredMilk() {
        return requiredMilk;
    }
}

final class CoffeeBean {

    private final CoffeeType type;
    private final int beans;
    private final int milk;

    public CoffeeBean(CoffeeType coffeeType, int beans, int milk) {
        this.type = coffeeType;
        this.beans = beans;
        this.milk = milk;
    }

    public CoffeeType getType() {
        return type;
    }

    public int getBeans() {
        return beans;
    }

    public int getMilk() {
        return milk;
    }

    @Override
    public String toString() {
        return "CoffeeBean{" +
                "type=" + type +
                ", beans=" + beans +
                ", milk=" + milk +
                '}';
    }
}

