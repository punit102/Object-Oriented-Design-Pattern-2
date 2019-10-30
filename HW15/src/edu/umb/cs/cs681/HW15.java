package edu.umb.cs.cs681;

public class HW15 {

	public static void main(String[] args) {

		InterruptiblePrimeNumberGenerator in = new InterruptiblePrimeNumberGenerator(1L, 1000000L);

		Thread t1 = new Thread(in);
		t1.start();
		try {
			Thread.sleep(700);
		} catch (InterruptedException e1) {
		}

		System.out.println("Before Calling interrupt() method Prime Number count : " + in.getPrimes().size());
		t1.interrupt();
		try {
			t1.join();
		} catch (InterruptedException e1) {
			
		}

		System.out.println("After Calling interrupt() method Prime Number count :" + in.getPrimes().size());
	}

}
