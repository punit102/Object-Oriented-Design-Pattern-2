package edu.umb.cs.cs681;

import java.io.FileNotFoundException;
import java.nio.file.Path;

public class RequestHandler implements Runnable {

	private AccessCounter ac;
	private boolean done = false;
	//ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
	private FIFOFileCache fifo;
	
	//private Path ranFile;

	public void setDone() {
		done = true;		
	}

	RequestHandler(FIFOFileCache fifo) {
		ac = new AccessCounter();
		this.fifo = fifo;
	}

	@Override
	public void run() {
		
		if(!done)
		{
			Path ranFile1 = ac.getRamdomPath();
			//System.out.println("Generated Random File:"+ranFile);
			try {
				fifo.fetch(ranFile1.toString());
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			ac.increment(ranFile1);
			System.out.println("Aceess File is ':"+ranFile1.toString() + "' and its count is : " +ac.getCount(ranFile1));
			
		}
		
	}

}