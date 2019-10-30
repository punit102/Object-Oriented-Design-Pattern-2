package edu.umb.cs.cs681;

public class HW22 {

	public static void main(String[] args) {
		
		FIFOFileCache fifo = new FIFOFileCache();
		RequestHandler req = new RequestHandler(fifo);
		for (int i = 0; i < 16; i++) {
			Thread ti = new Thread(req);
			ti.start();

		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 16; i++) {
			Thread ti = new Thread(req);
			ti.interrupt();
		}
		req.setDone();

	}

}
