package CoreJava.newBoatsMan.InnerClass;

public class InnerClass{
    public static void main(String args[]){

        //Member Inner Class
        MemberInnerclass mem=new MemberInnerclass();
        MemberInnerclass.Inner in=mem.new Inner();
        in.msg();

        //Local Inner class
        LocalInnerClass loc = new LocalInnerClass();
        loc.display();

        //Static nested class
        StaticNestedClass.Inner sta = new StaticNestedClass.Inner();
        sta.msg();
        StaticNestedClass.Inner.msg1();// becoase the method is static, so no instace required for this.

    }
}

class MemberInnerclass {
    //A non-static class that is created inside a class but outside a method is called member inner class.
    private String data = "MemberInnerClass has printed";

    class Inner {
        void msg() {
            System.out.println(data);
        }
    }
}

class LocalInnerClass {
    //A class i.e. created inside a method is called local inner class in java.
    // If you want to invoke the methods of local inner class, you must instantiate this class inside the method.
    static String  data = "LocalInnerclass has printed";//instance variable

    static void display() { //static keyworkd is used to access the method from Main class, for sarvana convienent
        class Local {
            int value=50;//local variable must be final till jdk 1.7 only
            void msg() { System.out.println(data + " "+ value);}
        }
        Local l = new Local();
        l.msg();
    }
}

class StaticNestedClass {
    //A static class i.e. created inside a class is called static nested class in java.
    // It cannot access non-static data members and methods. It can be accessed by outer class name.
    // It can access static data members of outer class including private.
    // Static nested class cannot access non-static (instance) data member or method.
    static int data = 30;

    static class Inner {
        void msg() { System.out.println("data is " + data);}
        static void msg1(){ System.out.println();} //For this method you no need to create instance of inner class
    }
}