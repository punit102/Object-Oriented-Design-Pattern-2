package edu.umb.cs.cs681;

import java.io.FileNotFoundException;
import java.nio.file.Path;

public class RequestHandler implements Runnable {

	private AccessCounter ac;
	private boolean done = false;
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
			try {
				fifo.fetch(ranFile1.toString());
			} catch (FileNotFoundException e) {
		
			}
			ac.increment(ranFile1);
			System.out.println("Aceess File is ':"+ranFile1.toString() + "' and its count is : " +ac.getCount(ranFile1));
			
		}
		
	}

}