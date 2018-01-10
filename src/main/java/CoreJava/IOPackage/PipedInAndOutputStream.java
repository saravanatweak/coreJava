package CoreJava.IOPackage;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * The PipedInputStream and PipedOutputStream classes can be used to read and write data simultaneously.
 * Both streams are connected with each other using the connect() method of the PipedOutputStream class.
 */
public class PipedInAndOutputStream {
    /**
     *  Here, we have created two threads t1 and t2. The t1 thread writes the data using the PipedOutputStream
     *  object and the t2 thread reads the data from that pipe using the PipedInputStream object.
     *  Both the piped stream object are connected with each other.
     */

    public static void main (String args[]) throws Exception
    {
        PipedInputStream in = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream();

        out.connect(in);//connecting the streams

        Thread t1 = new Thread() {//creating one thread t1 which writes the data
            public void run () {
                for(int i=65; i<=90; i++)
                {
                    try {
                        out.write((byte)i);
                        Thread.sleep(1000);
                    }catch (Exception e) {System.out.println(e.getMessage()); }
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                try {
                    for(int i=65; i<=90; i++)
                        System.out.println(in.read());
                } catch (Exception e) {System.out.println(e.getMessage()); }
            }
        };
    // Starting t1 and t2 threads.
        t1.start();
        t2.start();
    }
}
