package CoreJava.JavaLang.ReflectionApi.ByPluralSight;

public class AccountWorker implements Runnable { //Runnable: Account worker can do it work out on a sepearte thread.
    BankAccount ba; //targets
    HighVolumeAccount hva; //targets
    public AccountWorker(BankAccount ba) { this.ba = ba;}
    public AccountWorker(HighVolumeAccount hva) { this.hva = hva;}

    public void doWork() {
        //Here hva already knows how to do its work out in another thread.[as it implemnts runnable]
        Thread thread = new Thread( hva != null ? hva : this);
        thread.start();
    }

    public void  run() {
        char txType = 'w'; // it can 'w' or 'd'
        int amt = 50;

        if(txType =='w')
            ba.withdrawal(amt);
        else
            ba.deposit(amt);
    }

    @Override
    public String toString() {
        return  null;
    }

    public @interface customAnn {
        boolean useThreadPool() default true;
    }
}


