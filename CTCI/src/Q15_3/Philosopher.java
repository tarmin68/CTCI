package Q15_3;

public class Philosopher extends Thread{
	String name;
	private int bites = 10;
	private Chopstick left, right;

	public Philosopher(String n, Chopstick left, Chopstick right) {
		name = n;
		this.left = left;
		this.right= right;
	}

	public void eat() {
		if(pickUp()) {
			chew();
			putDown();
		}
	}

	public boolean pickUp() {
		if(!left.pickUp()){
			return false;
		}
		System.out.println(name + " picked up left chipstick!");
		if(!right.pickUp()) {
			left.putDown();
			System.out.println(name + " put down left chipstick!");
			return false;
		}
		System.out.println(name + " picked up right chipstick!");
		return true;
	}
	public void chew() {
		try {
			Thread.sleep(100);
			System.out.println(name + " finished chewing!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void putDown() {
		right.putDown();
		System.out.println(name + " put down right chipstick!");
		left.putDown();
		System.out.println(name + " put down left chipstick!");
	}

	@Override
	public void run() {
		for (int i = 0; i < bites; i++) {
			System.out.println("Round " + i);
			eat();
		}
	}

	public static void main(String[] args) {
		Chopstick cs1 = new Chopstick();
		Chopstick cs2 = new Chopstick();
		Chopstick cs3 = new Chopstick();
		Chopstick cs4 = new Chopstick();

		Philosopher philo1 = new Philosopher("Philo 1", cs1, cs2);
		Philosopher philo2 = new Philosopher("Philo 2", cs2, cs3);
		Philosopher philo3 = new Philosopher("Philo 3", cs3, cs4);
		Philosopher philo4 = new Philosopher("Philo 4", cs4, cs1);

		philo1.start();
		philo2.start();
		philo3.start();
		philo4.start();
	}
}
