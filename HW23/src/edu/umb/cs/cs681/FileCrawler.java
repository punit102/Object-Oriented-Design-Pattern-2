package edu.umb.cs.cs681;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class FileCrawler implements Runnable {

	private Directory dir;
	private FileQueue queue;
	private ReentrantLock lock;
	private volatile boolean done = false;

	public void setDone() {
		done = true;
	}

	FileCrawler(Directory d, FileQueue filequeue) {
		dir = d;
		this.queue = filequeue;
		lock = new ReentrantLock();
	}

	public void run() {

		lock.lock();
		try {
			if(done==false){
			crawl(dir);
			}
		} catch (InterruptedException e) {
			
		}   finally {
			lock.unlock();
		}

	}

	private void crawl(Directory root) throws InterruptedException {
		ArrayList<FSElement> fs = dir.getChildren();

		for (FSElement fse : fs) {
			if (fse.isFile()) {
				queue.put((File) fse);
			}
		}

	}

}
