package edu.umb.cs.cs681;

import java.util.concurrent.locks.ReentrantLock;

public class Singleton implements Runnable {
	private Singleton() {
	};

	private static Singleton instance = null;
	private static ReentrantLock lock = new ReentrantLock();

	public static Singleton getInstance() {

		lock.lock();
		try {
			if (instance == null) {
				instance = new Singleton();

			}

			return instance;
		} finally {
			lock.unlock();
		}
	}

	@Override
	public void run() {
		System.out.println("Created Singletonn Instance and its hash Value :"+Singleton.getInstance());

	}

}
