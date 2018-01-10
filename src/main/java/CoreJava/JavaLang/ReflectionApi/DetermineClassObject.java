package CoreJava.JavaLang.ReflectionApi;

public class DetermineClassObject {
    public static void main(String args[]) throws Exception{
        Class c = Class.forName("CoreJava.JavaLang.ReflectionApi.SimpleObject");
        System.out.println(c.isInterface());

        Class c1 = Class.forName("CoreJava.JavaLang.ReflectionApi.simpleInterface");
        System.out.println(c1.isInterface());


    }
}

class SimpleObject{}

interface simpleInterface {}

