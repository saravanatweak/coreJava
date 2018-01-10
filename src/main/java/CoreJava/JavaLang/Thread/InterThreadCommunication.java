package CoreJava.JavaLang.Thread;


class Customer {
    int balance = 10000;

    synchronized void withdraw(int amt) {
        System.out.println("Initiated Amount Withdraw...");
        if(amt > balance) {
            System.out.println("Amount is low. Waiting called for deposit");
            try { wait(); } catch (InterruptedException e) { System.out.println(e.getMessage()); }
            balance -= amt;
            System.out.println("Amount withdrawn is successful" );
        }
    }

    synchronized  void deposit ( int amt) {
        System.out.println("Initiated amount deposit..");
        balance += amt;
        System.out.println("Deposit completed.....");
        notify();
    }
}

public class InterThreadCommunication {
    public static void main(String args[]) {
        final Customer c = new Customer();

        Thread t1 = new Thread () {
            public void run () { c.withdraw(15000);}
        };
        /*The about file can be re-written like below
        new Thread (){  public void run() { c.withdraw(15000);} };*/

        Thread t2 = new Thread() {
            public void run() { c.deposit(10000); }
        };

        t1.start();
        t2.start();
        }
    }

