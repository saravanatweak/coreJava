package DesignPatterns.Creational.Factory;

public class WebsiteFactory {

    public static void main(String[] args) {

        Website site = WebsiteFactory.getWebsites("blog");
        System.out.println(site.getPages());

        site = WebsiteFactory.getWebsites("shop");
        System.out.println(site.getPages());



        //instead of passing a hardcoded literals we can use Enums to pass the same
        //again its not mandatory to have enums in factory, since patterns are an architectural type principle, hence it would be good to have enums for literals values
        System.out.println("Using enums");
        site = WebsiteFactory.getWebsites(WebsiteType.BLOG);
        System.out.println(site.getPages());

        site = WebsiteFactory.getWebsites(WebsiteType.SHOP);
        System.out.println(site.getPages());
    }

    /*this is where the factory method really steps into play here because we have those concrete implementations. We want those to be concerned with how they're created, not this base class, but we don't want people to be able to access those concrete classes on their own, */
    public static Website getWebsites(String siteType) {
        switch (siteType){ //since java 7 you can use string in switch
            case "blog":
                return new Blog();
            case "shop":
                return new Shop();
            default:
                return null;
        }
        //now we have our basic factory method and where we're getting our method from,
        // and we have our factory that calls based off siteTypes, but our true method is occurring,
        // our factory method pattern is occurring in this Websire.createWebsite() method that's overridden from our website itself(Blog and Shop classes)
    }

    //Above code can written using enum

    public static Website getWebsites(WebsiteType siteType) {
        switch (siteType){
            case BLOG:
                return new Blog();
            case SHOP:
                return new Shop();
            default:
                return null;
        }
    }

}

enum WebsiteType {
    BLOG,SHOP;
}

