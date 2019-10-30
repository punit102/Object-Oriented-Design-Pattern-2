package edu.umb.cs.cs681;

public class HW9 {

	public static void main(String[] args) {

		CancellablePrimeNumberGenerator can = new CancellablePrimeNumberGenerator(1L, 1000000L);
		InterruptiblePrimeNumberGenerator ipng = new InterruptiblePrimeNumberGenerator(1L, 1000000L);
		Thread t1 = new Thread(can);
		Thread t2 = new Thread(ipng);

		t1.start();
		t2.start();

		// Stopping Prime number generate by doing setDone() on one thread and
		// interrupt() on other thread

		can.setDone();
		t2.interrupt();

		System.out.println(
				"CancellablePrimeNumberGenerator Size after calling setDone() method : " + can.getPrimes().size());
		System.out.println(
				"InterruptiblePrimeNumberGenerator Size after calling interrupt() metod : " + ipng.getPrimes().size());

	}

}
