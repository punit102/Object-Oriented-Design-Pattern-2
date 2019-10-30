package edu.umb.cs.cs681;

public class HW26 {

	public static void main(String[] args) {
		
		ThreadRunner tt = new ThreadRunner();
		
		for (int i = 0; i < 5; i++) {
			Thread ti = new Thread(tt);
			ti.start();
		}
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			
		}
		for (int i = 0; i < 5; i++) {
			Thread ti = new Thread(tt);
			ti.interrupt();
		}

	}

}
