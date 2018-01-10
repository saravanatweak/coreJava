package CoreJava.JavaLang.ReflectionApi.ByPluralSight;

public class AccountWorkerWithInterface implements Runnable, TaskWorker {
    BankAccount ba; //not using HVA as it extends BA anyway

    // same as AccountWorker
    public void run() {
        char txType = 'w'; // it can 'w' or 'd'
        int amt = 50;

        if(txType =='w')
            ba.withdrawal(amt);
        else
            ba.deposit(amt);
    }

    /** Target comes here as Object, so its not type saved, it could be reference to anything
     *  As here we are working only on set of types, make sure u passing appropirate type. whether BA or HVA*/
    public void setTarget(Object target) {
        if(BankAccount.class.isInstance(target))
            ba = (BankAccount) target;
        else
            throw new IllegalArgumentException("Ist lllegal type");
    }

    /** As HVA knows how to be run on the therad already, so we'll do here is we'll use the
     * is inInstance test to see if the BA that it's pointed to is actually a HVA
     */
    public void doWork() {
        Thread t = new Thread(
                HighVolumeAccount.class.isInstance(ba) ? (HighVolumeAccount) ba : this);
        t.start();
        // Here, we're specifically checking to see if BA pointing to HVA, and if so, CASTING it.
        //
    }
}
