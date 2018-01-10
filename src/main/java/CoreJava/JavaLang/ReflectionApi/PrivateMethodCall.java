package CoreJava.JavaLang.ReflectionApi;

import java.lang.reflect.Method;

public class PrivateMethodCall {
    public static void main(String args[]) throws Exception{
        //Calling another class private method without Args
        Class c = Class.forName("CoreJava.JavaLang.ReflectionApi.PrivateMethodWithoutArgs");
        Object o = c.newInstance();

        Method m = c.getDeclaredMethod("cubeWithoutArgs", null);
        m.setAccessible(true);
        m.invoke(o,null);

        //Calling another class private method with Args
        Class c1 = Class.forName("CoreJava.JavaLang.ReflectionApi.PrivateMethodWithArgs");
        Object o1 = c1.newInstance();

        Method m1 = c1.getDeclaredMethod("cubeWithArgs", new Class[]{int.class}); // int.class is also sufficient to proceed
        m1.setAccessible(true);
        m1.invoke(o1,4);
    }
}

class PrivateMethodWithoutArgs  {
    private void cubeWithoutArgs () { System.out.println("Accessing private method of outside class");
    }

}

class PrivateMethodWithArgs {
    private void cubeWithArgs (int n) {System.out.println(n * n * n);
    }
}
