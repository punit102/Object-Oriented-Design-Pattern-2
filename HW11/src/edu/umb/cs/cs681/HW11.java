package edu.umb.cs.cs681;

public class HW11 {

	public static void main(String[] args) {

		CancellablePrimeNumberGenerator can = new CancellablePrimeNumberGenerator(1L, 1000000L);
		Thread t1 = new Thread(can);
		t1.start();
		try {
			Thread.sleep(700);
		} catch (InterruptedException e1) {

		}

		System.out.println("Before calling setDone() Prime Number count : " + can.getPrimes().size());
		can.setDone();
		try {
			t1.join();
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}

		System.out.println("After doing setDone() Prime Number count : " + can.getPrimes().size());

	}

}
