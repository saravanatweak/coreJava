package pluralSight.concurrency.waitNotify;

class ProducerConsumer {
    //Todo:Check why the producerAndConsumer is not working
    public static void main(String... strings) throws InterruptedException {

 /*       //Running Producer Consumer as Normal and with Race Condition
        ProducerConsumerNormalAndRaceCondition.Producer producer = new ProducerConsumerNormalAndRaceCondition.Producer();
        ProducerConsumerNormalAndRaceCondition.Consumer consumer = new ProducerConsumerNormalAndRaceCondition.Consumer();
        PrintCountOfBuffer(producer, consumer);
 */
/*
        //Eliminating race condition on Producer consumer with Synchrozization .,
        // But we are ended up with Dead lock So below code will run

        ProducerConsumerWithSynchronization.Producer producer = new ProducerConsumerWithSynchronization.Producer();
        ProducerConsumerWithSynchronization.Consumer consumer = new ProducerConsumerWithSynchronization.Consumer();
        PrintCountOfBuffer(producer, consumer);
*/
        ProducerConsumerWithWaitAndNotify.Producer producer = new ProducerConsumerWithWaitAndNotify.Producer();
        ProducerConsumerWithWaitAndNotify.Consumer consumer = new ProducerConsumerWithWaitAndNotify.Consumer();
        PrintCountOfBuffer(producer, consumer);

    }

    private static void PrintCountOfBuffer(ProducerConsumerNormalAndRaceCondition.Producer producer,
                                           ProducerConsumerNormalAndRaceCondition.Consumer consumer) throws InterruptedException {
        Runnable produceTask = () -> {
            for (int i = 0; i < 50; i++) {
                try {
                    producer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Done producing");
        };
        Runnable consumeTask = () -> {
            for (int i = 0; i < 50; i++) {
                try {
                    consumer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Done consuming");
        };

        Thread consumerThread = new Thread(consumeTask);
        Thread producerThread = new Thread(produceTask);

        consumerThread.start();
        producerThread.start();

        consumerThread.join();
        producerThread.join();

        System.out.println("Data in the buffer: " + ProducerConsumerNormalAndRaceCondition.count);
    }
}

class ProducerConsumerNormalAndRaceCondition {
    //Works very normal Producer and Consumer example, supposed get 0 as output
    // But still you will get some 4, 5 6 as output bcoz of race condition
    private static int[] buffer = new int[10];
    public static int count;

    static class Producer {
        void produce() throws InterruptedException {
            while (isFull(buffer)) {
            }
            buffer[count++] = 1;
        }

        boolean isFull(int[] buffer) {
            return count == buffer.length;
        }

    }

    static class Consumer {
        void consume() throws InterruptedException {
            while (isEmpty(buffer)) {
            }
            buffer[--count] = 0;
        }

        boolean isEmpty(int[] buffer) {
            return count == 0;
        }
    }
}

class ProducerConsumerWithSynchronization {

    private static int[] buffer = new int[10];
    public static int count;

    private static Object lockSync = new Object();

    static class Consumer extends ProducerConsumerNormalAndRaceCondition.Consumer {
        void consume() throws InterruptedException {
            synchronized (lockSync) {
                while (isEmpty(buffer)) {
                }
                //very first consumerThread will get the lock key and started to execute the while loop
                //Since buffer is empty this loop will never end, Hence key get owned by consumer thread
                buffer[--count] = 0;
            }
        }

        boolean isEmpty(int[] buffer) {
            return count == 0;
        }
    }

    static class Producer extends ProducerConsumerNormalAndRaceCondition.Producer {

        void produce() throws InterruptedException {
            synchronized (lockSync) {
                //producerThread will start excuting this thread and will be waiting for consumerthread to release
                //the key from its state, Hence this thread will not proceed further until unless the consumer thread
                //releases the key object
                while (isFull(buffer)) {
                }

                buffer[count++] = 1;
            }
        }

        // So Consumer threads waits for Producer thread to fill the data
        //But producer thread waits to acquire the lock( held by consumer thread) to produce the data
        //Hence its leads to indirect deadlock situation.
        boolean isFull(int[] buffer) {
            return count == buffer.length;
        }

    }

}

class ProducerConsumerWithWaitAndNotify {
    private static int[] buffer = new int[0];
    public static int count;
    private static Object lockWaitNotifyKey = new Object();

    static class Consumer extends ProducerConsumerNormalAndRaceCondition.Consumer {
        void consume() throws InterruptedException {
            synchronized (lockWaitNotifyKey) {
                if (isEmpty(buffer))
                    lockWaitNotifyKey.wait();
                //if the buffer is empty then parking this thread and releasing the lock key to producer thread in order to produce the data

                buffer[--count] = 0;
                lockWaitNotifyKey.notify();
                //Notifying that thread consumed data, Poduce can acquired the lock to produce the data
            }
        }

        boolean isEmpty(int[] buffer) {
            return count == 0;
        }
    }

    static class Producer extends ProducerConsumerNormalAndRaceCondition.Producer {

        void produce() throws InterruptedException {
            synchronized (lockWaitNotifyKey) {
                if (isFull(buffer))
                    lockWaitNotifyKey.wait();
                //Here, if the buffer is full we are going to park this thread and releasing the lock
                buffer[count++] = 1;
                lockWaitNotifyKey.notify();// Once data get added we are notifying this thread done this work.
                //If anybody(thread) wanted to acquire the lock can take the object lock key.
            }
        }

        //
        boolean isFull(int[] buffer) {
            return count == buffer.length;
        }

    }
}
