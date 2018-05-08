package pluralSight;

/**
 * Created by Saravanakumar_K05 on 11/14/2017.
 */
public class SingletonExp {
    private static SingletonExp instance; //class can have single instance only
    private SingletonExp(){}//it is not possible to build this class outside of itself

    public static SingletonExp getInstance(){
        if(instance == null)
            instance =  new SingletonExp();
        return instance;
    } }

/*
* it is not thread safe. Well, we need a static field to store the only instance of the Singleton class,
* your private static Singleton instance. We want to prevent outside code from being able to instantiate this class,
* so an easy way to do that in Java is to make the constructor private, so that this constructor cannot be called from outside this class,
* and final, this will prevent this class from being extended. Of course we still need a way to get an instance of this class from outside of this class,
* so we need a static method that can be called without any instance, public static Singleton getInstance.
* What is this getInstance method doing? Well, first it checks if the instance field is null,
* if it is then it creates a new instance of Singleton and stores it into this field and returns this field,
* thus guaranteeing that no two instances of the Singleton class are going to be created, at least in a mono thread environment. */

//        if(instance == null)                            //read operations
//            return new SingletonExpWithRaceCondtion();   // write op
//IF above two op's occurs in different threds it will produce RACE condtion //see race condtion code
//, a read and a write operation occurring at the same time in two different threads

/* How ?
* I have no happens before link between those two operations, so I have no guarantee that our first thread has created a new instance,
* and that the second thread will see this new instance. This first implementation is not thread safe, which is not a surprise,
* we already knew that. The first solution that can come to mind is to make the read and the write operation synchronous,
* that is making this getInstance method synchronous.
* */


class SigletonWithSynchronous {
    private static SigletonWithSynchronous instance; //class can have single instance only
    private SigletonWithSynchronous(){} //it is not possible to build this class outside of itself
    public static synchronized SigletonWithSynchronous getInstance(){
        if(instance == null)
            return new SigletonWithSynchronous();
        return instance;
    } }
//Trying to fix above code by introducing synchronous
/*This is the first fix to this problem called the synchronized Singleton pattern. It is simply written like that,
just by adding the synchronized keyword on the declaration of the getInstance method. What is this fix going to do?
Well, it is just going to prevent two threads from executing this getInstance method, so we have the guarantee that
 only one instance of the Singleton class is going to be created. From a purely functional point of view,
  this fix is perfect, it will make our Singleton class work as expected, even in a multi-threaded environment.
*/


//1st Solution with double check for the same
class SingletonWithDoubleCheck {
    private static Object lockOrkey = new Object();
    private static SingletonWithDoubleCheck instance; //class can have single instance only
    private SingletonWithDoubleCheck(){}//it is not possible to build this class outside of itself

    public static SingletonWithDoubleCheck getInstance(){
        if(instance != null)
            return instance;
        synchronized (lockOrkey) {
            if(instance == null)
                instance =  new SingletonWithDoubleCheck();
            return instance;
        }
    }

    /*Let us first check inside the getInstance method if the instance field has been created or not.
    If it has been created then I just return it, and this is fine because it is not in the synchronized block then
    all my reads will be made in parallel. And then if instance has not been created I have the synchronized block on
    a special key object which will be static of course, and inside this I have a classical code. Check if instance is null or not.
    This is a good idea because between the first test and this one another thread could have created this instance of Singleton.
    If it is null then I create it and return this value. This seems to be a nice way of doing things,
    but there is a bug in this code which is very subtle, and that we are going to see now. */
}
//Final Solution with Correct code with Volatile and synchronization
class SingletonGoodDesign {

    private static volatile SingletonGoodDesign instance;
    private static Object lockOrKey = new Object();
    private SingletonGoodDesign(){}

    public static SingletonGoodDesign getInstance(){
        if(instance != null)
            return instance;

        synchronized (lockOrKey) {
            if(instance != null) {
                instance = new SingletonGoodDesign();
            }
            return instance;
        }
    }
        }
