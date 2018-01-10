package pluralSight.concurrency.threads.runnable;

public class RunnableInstExp {
    public static void main(String[] args) {
        //Implementing runnable interface
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Im running in thread: "+Thread.currentThread().getName());
            }
        };

        //adding runnable inteerface to thread class
        Thread t1 = new Thread(runnable);
        t1.setName("New Thread");
        t1.start(); //will pring New Thread as it is
        //t1.run();// if you call directly the run instead of start it will print main method
    };
}
