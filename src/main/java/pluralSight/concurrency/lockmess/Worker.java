package pluralSight.concurrency.lockmess;

import java.util.Timer;
import java.util.TimerTask;

public class Worker extends Thread {

    private Object lock = new Object(); //3rd approch
    private volatile boolean quittingTime = false ;

    public void run() {
        while (!quittingTime) {
            working() ;
            System.out.println("Still working...") ;
        }

        System.out.println("Coffee is good !") ;
    }

    private void working() {
        try {
            Thread.sleep(300) ;
        } catch (InterruptedException e)  { }
    }

/*
    synchronized void quit() throws InterruptedException {
        //is properly called
            quittingTime = true ;
            join() ;
    }

    synchronized void keepWorking() {
        //not called properly
        quittingTime = false ;
    }
*/
    //2nd
/*synchronized void quit() throws InterruptedException {
    System.out.println("Calling join");
    quittingTime = true ;
    join() ;
    System.out.println("Back from join");
}

    synchronized void keepWorking() {

        quittingTime = false ;
        System.out.println("Keep working");
    }*/

//3rd way

synchronized void quit() throws InterruptedException {
    synchronized (lock) {
        quittingTime = true ;
        System.out.println("Calling join");
        join() ;
        System.out.println("Back from join");
    }
}

    synchronized void keepWorking() {
        synchronized (lock) {
            quittingTime = false ;
            System.out.println("Keep working");
        }
    }
    public static void main(String... args) throws InterruptedException {

        final Worker worker = new Worker() ;
        worker.start() ;

        Timer t = new Timer(true) ; // Daemon thread
        t.schedule(new TimerTask() {

            @Override
            public void run() {
                worker.keepWorking() ;
            }

        }, 500) ;

        Thread.sleep(400) ;
        worker.quit() ;
    }
}

/*If you run above code it will never quit, instead it will print like still wokring
bcoz We would like to be sure that quit() is properly called, and that keepworking is never called
In fact this keepWorkiing() should not be called before the thread finished executing quit() method
so try replacing below methods and run the code

add :private Object lock = new Object();

 synchronized void quit() throws InterruptedException {
        System.out.println("Calling join");
            quittingTime = true ;
            join() ;
            System.out.println("Back from join");
    }

    synchronized void keepWorking() {

        quittingTime = false ;
        System.out.println("Keep working");
    }

o/p

Still working...
Calling join
Keep working
Still working...
Still working...

reason:
we can call this join method because we are holding the write key,
but inside this method we can see that there is a call to the wait method of course of the object we're synchronized on.
And we also saw in the previous module about the wait notify pattern that this wait call will release the key that is held by the thread,
so in fact inside quit() method join() call releases the key held by the thread in this synchronize method, letting another thread to execute keepWorking() method,
but it is not doing what we want it to do, just because there is a lock mess here. Something went wrong since quit() method join call releases the key our thread is holding.

/*

//3rd way
/* How to fix the code ? replace thee below method

 synchronized void quit() throws InterruptedException {
    synchronized (lock) {
        quittingTime = true ;
        System.out.println("Calling join");
        join() ;
        System.out.println("Back from join");
    }
}

    synchronized void keepWorking() {
        synchronized (lock) {
            quittingTime = false ;
            System.out.println("Keep working");
        }
    }

 How ?
becaseu in above methods we have a double synchronization. But. synchronized(lock) {} is hidden in our class,
not visible from outside.

So conclusion

•	Never suppose anything on how an external call is dealing with the key of our synchronization,
always check for that because you might have surprises as is the case for this join method here.
•	we can see is that you will never have any problem if you use private Object to synchronize your block of code.
Never expose to the outside the object you use to synchronize your code.
This is really a golden rule in concurrent programming.

  */





