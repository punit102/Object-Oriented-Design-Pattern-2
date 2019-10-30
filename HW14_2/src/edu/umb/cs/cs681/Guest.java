package edu.umb.cs.cs681;

public class Guest implements Runnable {

	private SecurityGate gate;

	public Guest() {
		this.gate = SecurityGate.getInstance();
	}

	@Override
	public void run() {

		gate.enter();
		gate.exit();
		gate.getCount();

	}

}
