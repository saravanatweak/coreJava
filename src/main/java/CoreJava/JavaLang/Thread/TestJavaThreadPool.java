package CoreJava.JavaLang.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*Java Thread pool represents a group of worker threads that are waiting for the job and reuse many times.
In case of thread pool, a group of fixed size threads are created.
A thread from the thread pool is pulled out and assigned a job by the service provider.
After completion of the job, thread is contained in the thread pool again.*/

class JavaThreadPool implements Runnable {
private String msg;
    public JavaThreadPool(String s) {
        this.msg = s;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start Msg: "+msg);
        //Make Thread sleep for 2 secs
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println(Thread.currentThread().getName() + " End!");
    }
}

public class TestJavaThreadPool{
    public static void main(String args[])
    {
        ExecutorService executorService = Executors.newFixedThreadPool(5); //creating a pool of 5 threads
        for(int i=1; i<=15; i++) {
            Runnable work = new JavaThreadPool("" +i);
            executorService.execute(work); //Calling execute method of ExecutorService.
        }
        executorService.shutdown();
        while(!executorService.isTerminated()) {}

        System.out.println("Finished executing All Threads");
    }
}
