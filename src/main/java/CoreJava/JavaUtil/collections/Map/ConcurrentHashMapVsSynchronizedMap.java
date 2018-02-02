package CoreJava.JavaUtil.collections.Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by SaravanaWork on 20-01-2018.
 */
public class ConcurrentHashMapVsSynchronizedMap {

    public final static int THREAD_POOL_SIZE = 5;

    public static Map<String, Integer> HashTableObject = null;
    public static Map<String, Integer> SynchronizedMapObject = null;
    public static Map<String, Integer> ConcurrentHashMapObject = null;

    public static void main(String[] args) throws InterruptedException {

        // Test with Hashtable Object
        HashTableObject = new Hashtable<>();
        PerformTest(HashTableObject);

        // Test with synchronizedMap Object
        SynchronizedMapObject = Collections.synchronizedMap(new HashMap<String, Integer>());
        PerformTest(SynchronizedMapObject);

        // Test with ConcurrentHashMap Object
        ConcurrentHashMapObject = new ConcurrentHashMap<>();
        PerformTest(ConcurrentHashMapObject);

    }

    public static void PerformTest(final Map<String, Integer> threads) throws InterruptedException {

        System.out.println("Test started for: " + threads.getClass());
        long averageTime = 0;
        for (int i = 0; i < 5; i++) {

            long startTime = System.nanoTime();
            ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

            for (int j = 0; j < THREAD_POOL_SIZE; j++) {
                executorService.execute(new Runnable() {
                    @SuppressWarnings("unused")
                    @Override
                    public void run() {

                        for (int i = 0; i < 500000; i++) {
                            Integer randomNumber = (int) Math.ceil(Math.random() * 550000);
                            // Put value
                            threads.put(String.valueOf(randomNumber), randomNumber);
                        }
                    }
                });
            }

            // Make sure executor stops
            executorService.shutdown();

            // Blocks until all tasks have completed execution after a shutdown request
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

            long entTime = System.nanoTime();
            long totalTime = (entTime - startTime) / 1000000L;
            averageTime += totalTime;
            System.out.println("2500K entried added/retrieved in " + totalTime + " ms");
        }
        System.out.println("For " + threads.getClass() + " the average time is " + averageTime / 5 + " ms\n");
    }
}

