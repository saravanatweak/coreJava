package pluralSight.concurrency.threads.model;

public class LongWrapper {

    private Object key = new Object(); // 2nd way
    private long l;

    public LongWrapper( long l) {
        this.l = l;
    }

    public long getValue() {
        synchronized (key){
            return l;
        }
    }

    public void increment(){
        l = l + 1; //1st way comment this to excute 2nd way
        /*Well, it is a very classical example of a race condition. Here , I have a read of the l value,
        I increment it locally, and copy it into the same field l.
        So this read is followed by a write operation.
        So this operation is basically a read and write operation
        from different threads at the same time, so this is a race condition.*/

        //To Fix race condition just follow the 2nd way of above code
        /*synchronized (key) { // 2nd way
            l = l+1;
        }*/

        //Fixing With Volatile as first approach
        //if you make long l as "private volatile long l" instead of only long l,
        //Sting you will not get 1m as o/t in race condtion,
        /*Why isn't it working? Because here (l = l+1) I have a volatile read and the incrementation and
        then a volatile write, so this value will get the correct value created here. But the problem is not this one,
        the problem is that this operation should be atomic. It should not be interrupted when a thread is running it by
         another thread, so what we need here is not just volatility, it is really synchronization to guarantee that
         the thread will not be interrupted between the reading and the writing of this variable,
         so yes indeed synchronization was the correct answer, volatility is not enough.*/

        //so the 2nd way :
        /* Even after introducing synchronization the code will not proudce correct value sometimes becase
         this getValue() method should be neither synchronized, neither volatile, so this getValue does not offer the
         guarantee of returning the last value returned in this synchronized block.
         If I want this code to be completely correct, I need to make this read also synchronized just by putting it in a synchronized block
         <Note> add code like and test Race conditon : synchronized (key){ return l; }
         Of course the result will be the same but the difference is that now this code is correct.
         It was not correct in the first appraoch why? Because I did not have the happens before link between this write and this read.
         so the final code should be see below


*/


    }
}


    /*public class LongWrapper {

        private Object key = new Object(); // 2nd way
        private long l;

        public LongWrapper(long l) {
            this.l = l;
        }

        public long getValue() {
            synchronized (key) {
                return l;
            }
        }

        public void increment() {
            synchronized (key){
                l = l + 1;
            }

        }

    }*/


