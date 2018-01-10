package CoreJava.JavaLang.ReflectionApi;

public class NewInstanceExp {
    public static void main (String args[])throws Exception {

        Class c = Class.forName("CoreJava.JavaLang.ReflectionApi.SimpleExp");
        SimpleExp s = (SimpleExp) c.newInstance();
        s.printMessage();

    }
}

class SimpleExp {
    void printMessage() {
        System.out.println("This is the Example to show newInstance method of Class class");
    }
}