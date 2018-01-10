package CoreJava.JavaLang.ReflectionApi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR })
@interface MyCustomAnnotation {
    int value();
}



class ApplyingAnnotation {
    @MyCustomAnnotation(value =10)
    void sayHello() {System.out.println(" Hello Custom Annotatinon");    }

}

public class CustomAnnotation {
    public static void main(String args[]) throws Exception{
        ApplyingAnnotation h = new ApplyingAnnotation();

        Method m = h.getClass().getMethod("sayHello");

        MyCustomAnnotation cust = m.getAnnotation(MyCustomAnnotation.class);

        System.out.println("value for sayHello method from MyCustomAnnotaino is : "+cust.value());
    }
}