package pluralSight.concurrency.threads.runnable;

import pluralSight.concurrency.threads.model.LongWrapper;

/**
 * Created by saravanakumar_k05 on 11/11/2017.
 */
public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {

        final LongWrapper longWrapper = new LongWrapper(0L);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<1000; i++){
                    longWrapper.increment();
                }
            }
        };
        /*
        Thread t1 = new Thread(r);
        t1.start();

        t1.join();
        //Just to be sure that the code that I'm going to write after the call to this join method is executed
        // once this t1 has finished executing this runnable

        System.out.println("value of LongWrapper: "+longWrapper.getValue());
        */

        //Now instead of running one thread going to run 1000 threads

        Thread[] threads = new Thread[1000];
        for(int j=0; j<threads.length;j++){
            threads[j] = new Thread(r);
            threads[j].start();
        }

        for(int k=0; k<threads.length; k++){
            threads[k].join();
        }

        System.out.println("value of LongWrapper: "+longWrapper.getValue());
        /* very first will give you various values instead of 1million
        After adding synchronized method for new object in Longwrapper classs
        //2nd way it will give exactly 1m */ //Still smtimes will fail beacuse of memory issue

    }
}
