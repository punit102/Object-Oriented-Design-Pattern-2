package edu.umb.cs.cs681;

public class HW17 {

	public static void main(String[] args) {
		
		CancellablePrimeNumberGenerator gen = new CancellablePrimeNumberGenerator(1L, 1000000L);
		Thread t = new Thread(gen);
		t.start();
		
		try {
			Thread.sleep(900);
		} catch (InterruptedException e1) {
			
		}
		
		System.out.println("Before Doing 2 step thread termination Prime Number count without lock and with volatile keyword : "+gen.getPrimes().size());
		
		t.interrupt();
		gen.setDone();
		
		try {
			t.join();
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		
		t.interrupt();
		gen.setDone();
		
		System.out.println("After Doing 2 step thread termination Prime Number count without lock and with volatile keyword : "+gen.getPrimes().size());
		
		
	}

}
