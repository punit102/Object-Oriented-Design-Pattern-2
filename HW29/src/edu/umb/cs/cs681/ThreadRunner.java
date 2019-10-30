package edu.umb.cs.cs681;

import java.net.Socket;

public class ThreadRunner implements Runnable {

	private BankServer bs;
	private Socket sc;
	
	public ThreadRunner(Socket socket) {

		bs = new BankServer();
		this.sc = socket;
	}

	public void run() {
	
		bs.executeCommand(sc);

	}

}
