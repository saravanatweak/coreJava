package pluralSight.concurrency.falsesharing;

/**
 * Okay, time for a little live coding session. What are we going to see in this live coding session? Well, we are going to see some Java code in action, of course, as usual, and this time it will be an example of false sharing artificially created in a piece of code, and the influence of variable padding to try to fix this. We are going to see how false sharing can really kill the performance of an application and how variable padding can fix this problem.
 */
//artificial example of a class that is working using false sharing.
public class FalseSharingExp {

    public static int NUM_THREADS_MAX = 4 ;
    public final static long ITERATIONS = 50_000_000L;

    private static VolatileLongPadded[] paddedLongs ;
    private static VolatileLongUnPadded[] unPaddedLongs ;


    public final static class VolatileLongPadded {
        public long q1, q2, q3, q4, q5, q6 ;
        /*we have identified in the slides. And we have a second class which is basically the same, it also rubs long value here with the value 0, but just to be sure that we will not come across some false sharing we have created six other long before this long value, and six more long values after it. So here we have 13 long, thus we are sure that this value will be isolated in a cache line, and if we create several instances of this VolatileLongPadded class we can be sure that this volatile field here will not share the same line of cache with another instance
         */
        public volatile long value = 0L; //this value most probably shares the same line of code with other values
        public long q11, q12, q13, q14, q15, q16 ;

    }

    /*it just rubs a long value that is set to 0. So, if we create several instances of this class most probably they will be recorded on the same cache line of the CPU thus sharing this cache line and probably expose the false sharing problem
    * */
    public final static class VolatileLongUnPadded {
        public volatile long value = 0L;
    }

    static {
        paddedLongs = new VolatileLongPadded[NUM_THREADS_MAX] ;
        for (int i = 0 ; i < paddedLongs.length ; i++) {
            paddedLongs[i] = new VolatileLongPadded() ;
        }
        unPaddedLongs = new VolatileLongUnPadded[NUM_THREADS_MAX] ;
        for (int i = 0 ; i < unPaddedLongs.length ; i++) {
            unPaddedLongs[i] = new VolatileLongUnPadded() ;
        }
    }

    public static void main(final String[] args) throws Exception {
        runBenchmark();
    }

    private static void runBenchmark() throws InterruptedException {

        long begin, end ;

        for (int n = 1 ; n <= NUM_THREADS_MAX ; n++) {

            Thread[] threads = new Thread[n];

            for (int j = 0; j < threads.length; j++) {
                threads[j] = new Thread(createPaddedRunnable(j));
            }

            begin = System.currentTimeMillis() ;
            for (Thread t : threads) { t.start() ; }
            for (Thread t : threads) { t.join() ; }
            end = System.currentTimeMillis() ;
            System.out.printf("   Padded # threads %d - T = %dms\n", n, end - begin) ;

            for (int j = 0; j < threads.length; j++) {
                threads[j] = new Thread(createUnpaddedRunnable(j));
            }

            begin = System.currentTimeMillis() ;
            for (Thread t : threads) { t.start() ; }
            for (Thread t : threads) { t.join() ; }
            end = System.currentTimeMillis() ;
            System.out.printf(" UnPadded # threads %d - T = %dms\n\n", n, end - begin) ;
        }
    }

    private static Runnable createUnpaddedRunnable(final int k) {
        return () -> {
            long i = ITERATIONS + 1;
            while (0 != --i) {
                unPaddedLongs[k].value = i;
            }
        };
    }

    private static Runnable createPaddedRunnable(final int k) {
        Runnable paddedTouch = () -> {
            long i = ITERATIONS + 1;
            while (0 != --i) {
                paddedLongs[k].value = i;
            }
        };
        return paddedTouch;
    }
}

//output
/*
From the false sharing code we can see that, the false sharing is there, and that variable padding can protect our code from this false sharing. Now, is this variable padding trick, should be used all the time? Most probably not, this is just a toy example, you can probably reproduce it very easily in your machine, but on real applications it will probably be different.

* */
