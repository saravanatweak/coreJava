package pluralSight.concurrency.threads.runnable;


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
/*;
		t1.join();
		t2.join();*/
	}
}

class DeadLockCode {
	//Run the below code below in debug mode and try to see the threads holding
	//dead lock keys alternatively . If you couldn't do in Intellij follow the below link for eclipse
	//https://app.pluralsight.com/player?course=java-patterns-concurrency-multi-threading&author=jose-paumard&name=java-patterns-concurrency-multi-threading-m1&clip=16&mode=live

	private Object key1 = new Object();
	private Object key2 = new Object();

	public void a() {
		synchronized (key1) {
			System.out.println("[" + Thread.currentThread().getName() + "] I am in a()");
			b();
		}
	}

	public void b() {
		synchronized (key2) {
			System.out.println("[" + Thread.currentThread().getName() + "] I am in b()");
			c();
		}
	}

	public void c() {
		synchronized (key1) {
			System.out.println("[" + Thread.currentThread().getName() + "] I am in c()");
		}
	}
}
