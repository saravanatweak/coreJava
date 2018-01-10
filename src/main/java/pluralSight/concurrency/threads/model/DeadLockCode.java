package pluralSight.concurrency.threads.model;

public class DeadLockCode {
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
