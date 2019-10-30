package edu.umb.cs.cs681;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FileQueue {

	private ArrayList<File> files = new ArrayList<>();
	private final int  queueSize = 3;
	private Condition forwaitCondition, forsignalCondition;
	private ReentrantLock lock;
	private File tempFile;
	
	FileQueue()
	{
		lock = new ReentrantLock();
		forwaitCondition = lock.newCondition();
		forsignalCondition = lock.newCondition();
	}
	
	public void put(File f) throws InterruptedException
	{
		lock.lock();
		try{
			System.out.println("Lock obtained in put!");
			if(files.size() < queueSize)
			{
				System.out.println("Yes you can add !");
				files.add(f);
				System.out.println(f.getName());
				forsignalCondition.signalAll();
			}else
			{
				System.out.println("Wait for some Time");
				forwaitCondition.await();
			}
		}finally{
			lock.unlock();
			System.out.println("LOck release in put!");
		}
		
	}
	
	public File get() throws InterruptedException
	{
		lock.lock();
		try{
			System.out.println("Lock obtained in get!");
			if(files.size() <= 0){
				System.out.println("Wait for some Time");
				forsignalCondition.await();
				
			}
				if(!files.isEmpty())
				{
					this.tempFile = files.get(0);
					files.remove(0);
					forwaitCondition.signalAll();
					return this.tempFile;
				}	

				return null;

		}finally{
			lock.unlock();
			System.out.println("LOck release in get!");
		}
				
	}
}
;