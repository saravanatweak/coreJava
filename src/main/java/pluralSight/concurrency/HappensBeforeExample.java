package pluralSight.concurrency;

public class HappensBeforeExample {

    int x, y, r1, r2;
    Object lock = new Object();

    void first(){
        x =1;
        synchronized (lock){
            y=1;
        }
    }

    void second(){
        synchronized (lock){
            r1= y;
        }
        r2 = x;


    }
    void print(){
        System.out.println(  x+" "+y+" "+r1+" "+r2);
    }

    public static void main(String[] args) {
        HappensBeforeExample exp = new HappensBeforeExample();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                exp.first();
            }
        };

        Thread t2 = new Thread(){
            public void run(){
                exp.second();
            }
        };

        t1.start();
        t2.start();

        exp.print();
    }
}


/**
 *Let us see now a more complex example. We have a method called firstMethod with two write operations.
 * The first x = 1 unsynchronized and non-volatile since x is not declared as being volatile, and y = 1,
 * which is a synchronized write. And the secondMethod with two read operations, the first one, r1 = y,
 * synchronized read, and r2 = x, non-synchronized read. And the question is, if I execute this code in two different threads,
 * the first one executing firstMethod and the second one executing secondMethod, what the value of r2 is going to be?
 * Due to the way the code is written there is a "happens before" link between the x = 1 and the y = 1 operation. Why? Because those two pieces of code are written in the same method, and, of course, a given thread is supposed to respect the order in which I have written my code. So I have a "happens before" link between x = 1 and y = 1, and on the other hand, between r1 = y and r2 = x. Let us suppose at first that T1 is the first thread to enter the synchronized block. So we know that we have a "happens before" link between the write operation y = 1 and the read operation r1 = y. Since I also have a "happens before" between x = 1 and y = 1, and r1 = y and r2 = x, I know that the execution will be in this order: first x = 1, then y = 1, executed in my first thread, and r1 = y and r2 = x in my second thread. And the value of r2 is 1. Why? Because by transitivity I have a "happens before" link between x = 1 and r2 = x. But on the other hand, if T2 is the first thread to enter the synchronized block then things are not going that well because I have a "happens before" link between r1 = y and y = 1, but since r2 = x and x = 1 are not synchronized or volatized read and write operations I have no "happens before" link between those two operations, and I cannot know if x = 1 will be executed and visible before r2 = x. So the value of r2 may be 0 or 1 and it is not possible to say this in advance. So, from a concurrent programming point of view, this code is buggy because I cannot tell in advance what value r2 will receive.


 *  */

