package edu.umb.cs.cs681;

import java.util.concurrent.locks.ReentrantLock;

public class AutoSaver implements Runnable {

	private boolean done = false;
	private File afile;
	private ReentrantLock lock = new ReentrantLock();

	public AutoSaver(File afile) {

		this.afile = afile;
	}

	public void run() {

		while (true) {
			try {
				lock.lock();
				if (done == true) {
					System.out.println("Stop saving File Content");
					break;
				}

				System.out.println("***********Run AutoSaver Thread************** ");
				afile.save();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					
				}

			} finally {
				lock.unlock();
			}

		}

	}

	public void setDone() {

		done = true;
		System.out.println("terminate AutoSaver thrad because changed value is true");
	}

}
