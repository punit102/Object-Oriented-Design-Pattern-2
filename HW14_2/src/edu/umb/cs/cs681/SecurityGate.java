package edu.umb.cs.cs681;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class SecurityGate {

	private SecurityGate() {
	};

	private AtomicInteger atomicInt = new AtomicInteger(0);
	private static SecurityGate instance = null;
	private static ReentrantLock lock = new ReentrantLock();

	public static SecurityGate getInstance() {

		lock.lock();
		try {
			if (instance == null) {
				instance = new SecurityGate();

			}

			return instance;
		} finally {
			lock.unlock();
		}
	}

	// implement enter method

	public void enter() {
		lock.lock();
		try {
			atomicInt.updateAndGet((counter) -> counter++);

		} finally {
			lock.unlock();
		}
	}

	// implement exit method

	public void exit() {
		lock.lock();
		try {
			atomicInt.updateAndGet((counter) -> counter--);

		} finally {
			lock.unlock();
		}
	}

	// for getting count number

	public int getCount() {

		return atomicInt.get();
	}

}
