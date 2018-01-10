package CoreJava.JavaLang.Thread;

class Table { // Run with and without synchronization methods
    //void printTable(int n){// method without synchronization
        synchronized void printTable(int n){//synchronized method
            //synchronized(this){ //try to add for loop inside this block and remove synchronized from the method
                            // }//synchronized block
            for(int i=1;i<=5;i++){
            System.out.println(n*i);
            try{
                Thread.sleep(400);
            }catch(Exception e){System.out.println(e);}
        }
    }
}

public class SynchronizationExp{
    public static void main(String args[]){
        final Table obj = new Table();//only one object

        Thread t1=new Thread(){ // Annonymous class
            public void run(){
                obj.printTable(5);
            }
        };
        Thread t2=new Thread(){ // Annonymous class
            public void run(){
                obj.printTable(100);
            }
        };

        t1.start();
        t2.start();
    }
}

