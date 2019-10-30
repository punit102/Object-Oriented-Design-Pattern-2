package edu.umb.cs.cs681;

import java.nio.file.Path;

public class RequestHandler implements Runnable {

	private AccessCounter ac;
	private volatile boolean done = false;
	private Path ranFile;

	public void setDone() {
		done = true;		
	}

	RequestHandler() {
		ac = new AccessCounter();
	}

	@Override
	public void run() {

		ranFile = ac.getRamdomPath();
		if(!done)
		{
			ac.increment(ranFile);
			System.out.println("Aceess File is ':"+ranFile.toString() + "' and its count is : " +ac.getCount(ranFile));
		}
		
	}

}