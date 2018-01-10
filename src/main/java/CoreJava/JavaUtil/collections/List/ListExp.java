package CoreJava.JavaUtil.collections.List;/*
package CoreJava.JavaUtil.collections.List;

import CoreJava.JavaUtil.collections.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListExp implements Iterable<Product> {

    private static List<Product> products = new ArrayList<>();

    public static void main(String args){

        //add
        products.add(new Product("android", 30));
        products.add(new Product("iphone", 25));
        products.add(new Product("nokia", 10));

        //Sorting before java 7
        //Collections.sort(products,Product.BY_PRIZE);
        //In Java 8
        products.sort(Product.BY_PRIZE);

        //SubList(Act as VIEW, if any chnge made in subList, the same will reflect in main list as well.
        int splitPoint = findTheSplitPoint();
        List<Product> productWithLessPrize = products.subList(0,splitPoint);
        List<Product> productWithHighPrize = products.subList(splitPoint,products.size());




    }
    private static int findTheSplitPoint() {
        for(int i=0; i<products.size(); i++) {
            if(products.get(i).getPrize() >20)
                return i;
        }
        return -1;
    }


    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }

}

*/
