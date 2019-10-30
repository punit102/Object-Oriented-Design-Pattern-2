package edu.umb.cs.cs681;

import java.util.concurrent.locks.ReentrantLock;

public class CancellablePrimeNumberGenerator extends PrimeNumberGenerator {
	private boolean done = false;
	ReentrantLock lock = new ReentrantLock();

	public CancellablePrimeNumberGenerator(long from, long to) {
		super(from, to);
	}

	public void setDone() {
		lock.lock();
		try {
			done = true;
		} finally {
			lock.unlock();
		}
	}

	public void run() {
		// Stop generating prime numbers if done==true
		for (long n = from; n <= to; n++) {

			try {
				lock.lock();
				if (isPrime(n)) {
					this.primes.add(n);
				}
				if (done == true) {
					System.out.println("Stopped generating prime numbers.");
					this.primes.clear();
					break;
				}

			} finally {
				lock.unlock();
			}

		}
	}
}
