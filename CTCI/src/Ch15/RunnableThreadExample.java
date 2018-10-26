package Ch15;

public class RunnableThreadExample implements Runnable {
	int count = 0;
	@Override
	public void run() {
		System.out.println("RunnableThread starting.");
		try {
			while (count< 5) {
				Thread.sleep(500);
				System.out.println("inside: " + count);
				count++;
			}
		} catch (InterruptedException exc) {
			System.out.println("RunnableThread interrupted.");
		}
		System.out.println("RunnableThread terminating.");
	}

	public static void main(String[] args) {
		RunnableThreadExample instance = new RunnableThreadExample();
		Thread thread = new Thread(instance);
		thread.start();
		
		while(instance.count != 5) {
			try {
				Thread.sleep(500);
				System.out.println("outside: " + instance.count);
			} catch (InterruptedException exc) {
				System.out.println("RunnableThread interrupted.");
			}
		}
	}
}
