package Q15_3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
	Lock lock = new ReentrantLock();
	
	boolean pickUp() {
		return lock.tryLock();
	}
	
	void putDown() {
		lock.unlock();
	}
}
