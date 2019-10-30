package edu.umb.cs.cs681;

public class HW14_2 {

	public static void main(String[] args) {
		
		for (int i = 0; i <= 45; i++) {
			Guest gi = new Guest();
			Thread ti = new Thread(gi);
			ti.start();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {

			}
			System.out.println("SecurityGate Count is : " + SecurityGate.getInstance().getCount());
		}

	}

}
