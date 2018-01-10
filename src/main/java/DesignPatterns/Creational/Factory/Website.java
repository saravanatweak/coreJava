package DesignPatterns.Creational.Factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saravanakumar_K05 on 11/20/2017.
 */
public abstract class Website {
    protected List<Page> pages = new ArrayList<>();

    public Website() {
        this.createWebsite();
    }

    public List<Page> getPages() {
        return pages;
    }

    //this is the crux of the factory method pattern here.
    /*So our factory is going to call the new no-args constructor for Blog (and it could have arguments too, it doesn't have to be a no arguments),
    which is then overridden from Website that calls our constructor Wesite() that interns calls this.createWebsite,
    and this is where our factory method is coming the case. It's called a factory method. */
    public abstract void createWebsite();
    /*Our method is what's concerned about our instantiation of createWebsite, which in our blog or our shop then goes through and actually builds what our application's going to do here. */
}

/*you can see how we're putting pages in here that are specific to the blog, And you can see how the base class doesn't have anything to do with the creation, but rather the concrete implementation does, so the Blog class, which is implementing that factory method, is what's concerned about creating the implementation that we're looking at. */
class Blog extends Website {

    @Override
    public void createWebsite() {
        pages.add(new PostPage());
        pages.add(new AboutPage());
        pages.add(new CommentPage());
        pages.add(new ContactPage());
    }
}

/*you see how the content here is different for the website, for the shop website versus the blog website, and the concrete implementation is what's concerned with how that gets implemented, but we're still going to return the website interface or contracts. */
class Shop extends Website {

    @Override
    public void createWebsite() {
        pages.add(new CartPage());
        pages.add(new ItemPage());
        pages.add(new SearchPage());
    }

}








