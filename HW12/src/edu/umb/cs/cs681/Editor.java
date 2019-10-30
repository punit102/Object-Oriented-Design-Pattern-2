package edu.umb.cs.cs681;

import java.util.concurrent.locks.ReentrantLock;

public class Editor implements Runnable {

	private boolean done = false;
	private File afile;
	private ReentrantLock lock = new ReentrantLock();

	public Editor(File afile) {
		this.afile = afile;
	}

	public void run() {

		while (true) {
			try {
				lock.lock();
				if (done == true) {
					System.out.println("Stop changing and saving File Content");
					break;
				}

				System.out.println("##########Run Editor Thread############ ");
				afile.change();
				afile.save();

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
				}

			} finally {
				lock.unlock();
			}

		}

	}

	public void setDone() {
		
		done = true;
		System.out.println("terminate editor thrad because changed value is true");
		
		/*lock.lock();
		try {
			changed = true;
			System.out.println("terminate editor thrad and changed value is true");
		} finally {
			lock.unlock();
		}*/

	}

}
