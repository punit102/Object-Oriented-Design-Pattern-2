package edu.umb.cs.cs681;

public class HW27 {
	
	public static void main(String[] args) {
	
	RequestHandler req = new RequestHandler();
	
	for (int i = 0; i < 25; i++) {
		Thread ti = new Thread(req);
		ti.start();
	}
	try {
		Thread.sleep(200);
	} catch (InterruptedException e) {
		
	}
	for (int i = 0; i < 25; i++) {
		Thread ti = new Thread(req);
		ti.interrupt();
	}
	req.setDone();
	
}

}
