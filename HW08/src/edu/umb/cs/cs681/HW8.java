package edu.umb.cs.cs681;

public class HW8 {

	public static void main(String[] args) throws InterruptedException {

		PrimeNumberGenerator gen1 = new PrimeNumberGenerator(1L, 1000000L);
		PrimeNumberGenerator gen2 = new PrimeNumberGenerator(1000000L, 2000000L);
		Thread t1 = new Thread(gen1);
		Thread t2 = new Thread(gen2);

		t1.start();
		t2.start();
		t1.join();
		t2.join();
		gen1.getPrimes().forEach(prime -> System.out.println(prime));
		gen2.getPrimes().forEach(prime -> System.out.println(prime));

		/*
		 * //Thread thread1 = new Thread(gen); thread.start();
		 * //thread1.start(); thread.join(); gen.getPrimes().forEach(prime ->
		 * System.out.println(prime));
		 * 
		 */

	}

}
