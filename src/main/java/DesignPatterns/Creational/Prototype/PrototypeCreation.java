package DesignPatterns.Creational.Prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Saravanakumar_K05 on 11/20/2017.
 */
public class PrototypeCreation {
    public static void main(String[] args) {
        Registry registry = new Registry();
        Movie movie = (Movie) registry.createItem("Movie");//this is basically executing our clone method for us
        movie.setTitle("Creational Patterns in Java");
        /** Note :So it gives us a way to set up some defaults that we want for each object that's going to be returned without having that heavy weight expensive create an object every time. Think if you had 10,000 objects on the page, which believe it or not is a common problem if you're implementing like a hibernate where it creates a lot of objects and returns those. It can be very object or labor intensive to return that information. */

        System.out.println(movie);
        System.out.println(movie.getRuntime());
        System.out.println(movie.getTitle());
        System.out.println(movie.getUrl());


        //Without creating new instance at each time we are adding or changing the moview name continuosly.
        //This is how prototype pattern helps us to create multiple objets without using new keyword.
        //The only time we ever call 'new' is Registry.loadItems():first line,
        /*Every time we want to get an instance of it, we get an instance back of a Movie, and we don't have to use the keyword new anymore. So it's a lot lighter weight object instantiation and a lot faster, but we're getting a unique instance each time, and that's the definition of that prototype is getting a unique instance every time we ask for this object back. */
        Movie anotherMovie = (Movie) registry.createItem("Movie");
        anotherMovie.setTitle("Gang of Four");


        System.out.println(anotherMovie);
        System.out.println(anotherMovie.getRuntime());
        System.out.println(anotherMovie.getTitle());
        System.out.println(anotherMovie.getUrl());
    }

}

/**
 * what we're going to implement here is just some basic object lookups. Think of it in terms of a company like Amazon that if they were to display an object for every item on their page it would become very expensive to create all those objects, especially if we're filling all of this type of information in. */
abstract class Item implements Cloneable {
    private String title;
    private double price;
    private String url;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //if we have nothing unique in our subobjects, this will go ahead and do the clone for us, and that's actually going to work for what we're doing right now.
        return super.clone();
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

}

class Book extends Item {

    private int numberOfPages;

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}

class Movie extends Item {

    private String runtime;

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

}

class Registry {

    private Map<String, Item> items = new HashMap<String, Item>();

    public Registry() {
        loadItems();
    }

    //Heart part of prototype going to take place
    public Item createItem (String type) {
        Item item = null;

        try {
    /*Not a big deal, but one of the shortcomings. People get a little leery when they start having to cast things like this. */
            item = (Item)(items.get(type)).clone();
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return item;
    }

    private void loadItems() {
        Movie movie = new Movie();
        movie.setTitle("Basic Movie");
        movie.setPrice(24.99);
        movie.setRuntime("2 hours");
        items.put("Movie", movie);//Instead of hardcoded object("Movie"), maybe consider also implementing this with an enum

        Book book = new Book();
        book.setNumberOfPages(335);
        book.setPrice(19.99);
        book.setTitle("Basic Book");
        items.put("Book", book); //Instead of hardcoded object("Book"), maybe consider also implementing this with an enum
        /*Now what this does is when we go through and we want to get an instance of it, we say give us back an instance of a Movie and give us back an instance of a Book, and then we can change those values from there, and we get a unique instance every time.*/
    }
}



