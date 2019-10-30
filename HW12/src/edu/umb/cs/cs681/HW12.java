package edu.umb.cs.cs681;

public class HW12 {

	public static void main(String[] args) {

		File afile = new File();
		AutoSaver as = new AutoSaver(afile);
		Editor ed = new Editor(afile);
		Thread t1 = new Thread(as);
		Thread t2 = new Thread(ed);

		t2.start();
		t1.start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

		}

		as.setDone();
		ed.setDone();

	}

}
