package edu.umb.cs.cs681;

public class HW13 {

	public static void main(String[] args) {
		Thread t1 = new Thread(Singleton.getInstance());
		Thread t2 = new Thread(Singleton.getInstance());
		Thread t3 = new Thread(Singleton.getInstance());

		t1.start();
		t2.start();
		t3.start();

	}

}
