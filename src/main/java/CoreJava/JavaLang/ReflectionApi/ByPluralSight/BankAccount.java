package CoreJava.JavaLang.ReflectionApi.ByPluralSight;

public class BankAccount {

    private final String id;
    private int balance=0;
    public BankAccount(String id) { this.id = id;   }
    public BankAccount(String id, int balance) { this.id=id; this.balance = balance;}

    public String getId() { return id;     }
    public synchronized int getBalance() {         return balance;     }
    public synchronized void deposit(int amount) { balance +=amount ;}
    public synchronized void withdrawal(int amount) {
        if(balance>amount)
            balance -= amount;
        else
            System.out.println("you have only: "+balance);
    }

    private class test1 {
        public void privateClassMethod() {
            System.out.println("Inside of privateClassMethod");
        }
    }

}
