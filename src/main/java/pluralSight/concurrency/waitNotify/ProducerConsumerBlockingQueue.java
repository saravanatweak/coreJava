package pluralSight.concurrency.waitNotify;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueue {


    public static void main(String[] args) {
        //creataing blocking queue size 10
        BlockingQueue<Message> queue = new ArrayBlockingQueue<Message>(10);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        //starting producer to produce messages in queue
        new Thread(producer).start();
        //starting consumer to consume messages from queue
        new Thread(consumer).start();
        System.out.println("Producer and Consumer has been started");

    }




    private static class Message {

        private String msg;

        public Message(String str) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }

    private static class Producer implements Runnable {

        private BlockingQueue<Message> queue;

        public Producer(BlockingQueue<Message> q){
            this.queue=q;
        }
        @Override
        public void run() {
            //produce messages
            for(int i=0; i<100; i++){
                Message msg = new Message(""+i);
                try {
                    Thread.sleep(i);
                    queue.put(msg);
                    System.out.println("Produced "+msg.getMsg());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //adding exit message
            Message msg = new Message("exit");
            try {
                queue.put(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private static class Consumer implements Runnable {

        private BlockingQueue<Message> queue;

        public Consumer(BlockingQueue<Message> msg) {
            this.queue = msg;
        }
        @Override
        public void run() {
            try{
                Message msg;
                // Consuming message until exit messge is recived
                while ((msg = queue.take()).getMsg() !="exit"){
                    Thread.sleep(10);
                    System.out.println("Consumed "+msg.getMsg());
                }
            }catch ( InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}



