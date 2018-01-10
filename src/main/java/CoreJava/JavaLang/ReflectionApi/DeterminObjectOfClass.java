package CoreJava.JavaLang.ReflectionApi;

public class DeterminObjectOfClass {
    public static void main(String args[]) throws Exception {
        //Using forName() Method of Class class
        /* is used to load the class dynamically. returns the instance of Class class.
         * It should be used if you know the fully qualified name of class.This cannot be used for primitive types.*/
        Class c = Class.forName("CoreJava.JavaLang.ReflectionApi.Simple");
        System.out.println(c.getName());

        //Using getMethod() of Object Class
        /**It returns the instance of Class class. It should be used if you know the type.
         * Moreover, it can be used with primitives.*/
        Simple s = new Simple();
        GetMethodOfObjectClass get = new GetMethodOfObjectClass();
        get.printName(s);

        //.class Syntex
        /** If a type is available but there is no instance then it is possible to obtain a Class by appending ".class" to the name of the type.
         *  It can be used for primitive data type also.*/
        Class c1 = boolean.class;
        System.out.println(c1.getName());
        Class c2 = Simple.class;
        System.out.println(c2.getName());
    }
}
class Simple{}

class GetMethodOfObjectClass {
    void printName(Object obj) {
        Class c = obj.getClass();
        System.out.println(c.getName());
    }
}

