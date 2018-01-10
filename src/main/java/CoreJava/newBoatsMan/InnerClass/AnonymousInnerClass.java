package CoreJava.newBoatsMan.InnerClass;


abstract class PersonAbstract {
    abstract void eat();
}

interface EatableInterface {
    void eat();
}

public class AnonymousInnerClass {
    public static void main(String args[]){

        //Abstrcat or concreate class
        PersonAbstract p=new PersonAbstract(){
            void eat(){System.out.println("nice fruits");} //class has been extended
        };
        p.eat();

   /*   A class is created but its name is decided by the compiler which EXTENDS
        the ABSTRACT CLASS and provides the implementation of the eat() method.
        An object of Anonymous class is created that is referred by p reference variable of PersonAbstract type.
        //Internal working of this code
        static class AnonymousInnerClass extends PersonAbstract
        {
        AnonymousInnerClass(){}
        void eat()
        {
            System.out.println("nice fruits");
        }
    } */
        //Calling interface class
        EatableInterface e=new EatableInterface(){
            public void eat(){System.out.println("nice fruits");} // interface has been implemented
        };
        e.eat();

        /*A class is created but its name is decided by the compiler which IMPLEMENTS
        the EATABLE INTERFACE and provides the implementation of the eat() method.
        An object of Anonymous class is created that is referred by p reference variable of EatableInterface type.*/
    }




}
