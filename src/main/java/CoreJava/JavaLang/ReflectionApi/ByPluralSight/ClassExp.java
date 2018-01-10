package CoreJava.JavaLang.ReflectionApi.ByPluralSight;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class  ClassExp {
    public static void main(String args[]) throws Exception{
     //By using Generics
        Class<?> c = new ClassExp().getClass();
        showName("Using instance: ", c);

        //Class name from String Name
        //Class.forname gives us back the type description for that type.
        Class<?> c1 = Class.forName("CoreJava.JavaLang.ReflectionApi.ByPluralSight.ClassExp");
        showName("Using class.forname: ", c1);

        ////Class name from Type Literal
        Class<?> c2 = ClassExp.class;
        showName("Using Type Literal: ",c2);
        // Here we are directly using teh class name, So you can re-write the above line into
        Class<ClassExp> c3 = ClassExp.class;
        showName("Using Type Literal using type representation: ",c3);

        //Getting Class modifier
        checkingModifierDetails();
        Class<?> theClass = new ClassExp().getClass();
        //Its own type delcartions
        // Here it will print only current type methods irrespective of anytype access modifoer.
        Method[] declMethods = theClass.getDeclaredMethods();
        for(Method dm: declMethods)
            System.out.println(dm.getName());

        //It owns inherited methods as well
        // Here it will print only the public methods will go until top hierarchy, like upto Object methods
        Method[] methods = theClass.getMethods();
        for(Method m: methods) {
            //In order to stop printing particular class methods(inherited class)
            // Remember exactly one instance of the class describing each type, so we can do == or !=
            if(m.getDeclaringClass() != Object.class)
            System.out.println(m.getName());
        }


    }

    private static void checkingModifierDetails() {
        Class<?> theClass = new ClassExp().getClass();
        int modifier = theClass.getModifiers();

        if((modifier & Modifier.FINAL) >0 )
            System.out.println("Bitwise Check - final");

        if(Modifier.isFinal(modifier))
            System.out.println("Method lelev check - final");

        if(Modifier.isPublic(modifier)) // we have isPrivate, isAbstracoted, etc
            System.out.println("method Check - is public");
    }


    static void showName(String value, Class<?> theClass ) {
        System.out.println(value + theClass.getSimpleName());
    }

}
