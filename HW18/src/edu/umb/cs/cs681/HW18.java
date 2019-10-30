package edu.umb.cs.cs681;

import java.util.ArrayList;

public class HW18 {

	public static void main(String[] args) {
		
		RequestHandler req = new RequestHandler();
		
		ArrayList<Thread> threadCount = new ArrayList<Thread>();
		for (int i = 0; i < 25; i++) {
			Thread ti = new Thread(req);
			threadCount.add(ti);
		}

		for (Thread ti : threadCount) {
			ti.start();
		}

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (Thread ti : threadCount) {
			ti.interrupt();
		}
		req.setDone();

	}

}
