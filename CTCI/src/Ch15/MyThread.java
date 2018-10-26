package Ch15;

public class MyThread extends Thread{
	String name;
	private LockedATM lockedATM;

	public MyThread(String n, LockedATM la) {
		name = n;
		lockedATM = la;
	}

	@Override
	public void run() {
		System.out.println(name + " " + lockedATM.deposit(40));
		System.out.println(name + " " + lockedATM.withdraw(20));
	}

	public static void main(String[] args) {
		LockedATM la = new LockedATM();
		MyThread class1 = new MyThread("1", la);
		MyThread class2 = new MyThread("2", la);
		class1.start();
		class2.start();
	}
}
