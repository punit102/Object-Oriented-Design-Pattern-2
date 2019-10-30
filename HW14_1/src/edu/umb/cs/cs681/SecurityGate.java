package edu.umb.cs.cs681;

import java.util.concurrent.locks.ReentrantLock;

public class SecurityGate {

	private SecurityGate() {
	};

	private int counter;
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
			counter++;
		} finally {
			lock.unlock();
		}
	}

	// implement exit method

	public void exit() {
		lock.lock();
		try {
			counter--;
		} finally {
			lock.unlock();
		}
	}

	// for getting count number

	public int getCount() {
		
		return counter;
	}

}
