package edu.umb.cs.cs681;

import java.util.concurrent.locks.ReentrantLock;

public class File {

	private boolean changed = false;
	private ReentrantLock lock = new ReentrantLock();
	
	public void change()
	{
		lock.lock();
		try{
			System.out.println(" Changed the file content in main file makes changed as true");
			changed = true;
		}finally
		{
			lock.unlock();
		}
		
	}
	
	public void save()
	{
		
		lock.lock();
		try{
			if(changed == false)
			{
				changed = false;
			}
			if(changed == true)
			{
				System.out.println("Your file saved in main file makes chaged as false");
				changed = false;
			}
		}finally
		{
			lock.unlock();
		}
		
	}
}
