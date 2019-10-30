package edu.umb.cs.cs681;

import java.util.concurrent.locks.ReentrantLock;

public class FileIndexer implements Runnable {

	private FileQueue queue;
	private ReentrantLock lock = new ReentrantLock();;
	private volatile boolean done = false;

	public FileIndexer(FileQueue filequeue) {
		this.queue = filequeue;
	}

	public void setDone() {
		done = true;
		
	}

	@Override
	public void run() {

		
			while (done == false) {
				
				lock.lock();
				try {
						
					indexFile(queue.get());
					
				} catch (InterruptedException e) {
					
				} finally {
					lock.unlock();
				}

			}
		

	}

	public void indexFile(File file) {
		if(file != null){
		System.out.println("File name:" + file.getName());
		System.out.println("File Owner:" + file.getOwner());
		System.out.println("File size:" + file.getSize());
		}
	}

}
