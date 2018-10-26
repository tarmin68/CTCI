package Ch15;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedATM{
	Lock lock;
	int balance = 100;

	public LockedATM() {
		lock = new ReentrantLock();
	}

	public int withdraw(int value) {
		lock.lock();
		int temp = balance;
		try {
			System.out.println("Withdraw starting");
			Thread.sleep(100);
			temp = temp - value;
			Thread.sleep(100);
			System.out.println("Withdraw ending");
			balance = temp;
		} catch (Exception e) {
			// TODO: handle exception
		}
		lock.unlock();
		return temp;
	}

	public int deposit(int value) {
		lock.lock();
		int temp = balance;
		try {
			System.out.println("Deposit starting");
			Thread.sleep(100);
			temp = temp + value;
			Thread.sleep(100);
			System.out.println("Deposit ending");
			balance = temp;
		} catch (Exception e) {
			// TODO: handle exception
		}
		lock.unlock();
		return temp;
	}
}

