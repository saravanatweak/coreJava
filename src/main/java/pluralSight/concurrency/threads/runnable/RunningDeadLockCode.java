package pluralSight.concurrency.threads.runnable;


import pluralSight.concurrency.threads.model.DeadLockCode;

public class RunningDeadLockCode {

	public static void main(String[] args) throws InterruptedException {

		final DeadLockCode a = new DeadLockCode();

		//java 8 using lambada expresseions
		/*Runnable r1 = () -> a.a();
		Runnable r2 = () -> a.b();*/

		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				a.a();
			}
		};

		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				a.b();
			}
		};
		
		Thread t1 = new Thread(r1);
		t1.start();

		Thread t2 = new Thread(r2);
		t2.start();

		t1.join();
		t2.join();
	}
}
