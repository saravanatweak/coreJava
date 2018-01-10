package CoreJava.JavaLang.ReflectionApi.ByPluralSight;

public class HighVolumeAccount extends BankAccount implements Runnable {

    public HighVolumeAccount(String id) { super(id);}
    public HighVolumeAccount(String id, int balance) { super(id, balance);}

    private int[] readDailyBalance() {
        int[] val ={ 10,20,30,40,50};
        return val;
    }
    private int[] readDailyWithdrawals() {
        int[] val ={ 10,20,30,40,50};
        return val;}

    public void run(){
        for(int depositAmt: readDailyBalance())
            deposit(depositAmt);
        for (int withdrawAmt : readDailyWithdrawals())
            deposit(withdrawAmt);
    }
}
