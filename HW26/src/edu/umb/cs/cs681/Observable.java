package edu.umb.cs.cs681;

import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

public class Observable {

	private boolean changed = false;
	private Observable obs;
	private ReentrantLock lockObs;
	private Vector<Observer> observers;

	public Observable() {

		observers = new Vector<Observer>();
		lockObs = new ReentrantLock();
	}

	public void addObserver(Observer o) {

		lockObs.lock();
		try {
			observers.add(o);
		} finally {
			lockObs.unlock();
			System.out.println("New Observer Added");
		}
	}

	public void deleteObserver(Observer o) {

		lockObs.lock();
		try {
			observers.remove(o);
		} finally {
			lockObs.unlock();
			System.out.println("Observer Deleted");
		}

	}

	public boolean hasChanged() {

		if (changed == true) {
			return true;
		} else {
			return false;
		}
	}

	protected void setChanged() {
		System.out.println("Set changed is called and hasChanged is set to true");
		lockObs.lock();
		try{
			this.changed = true;
		}finally
		{
			lockObs.unlock();
		}

	}

	protected void clearChanged() {
		System.out.println("clearChanged is called and hasChanged is set to false");
		lockObs.lock();
		try{
			this.changed = false;
		}finally
		{
			lockObs.unlock();
		}

	}

	public void notifyObservers(Object arg) {

		Object[] arrLocal = null;
		lockObs.lock();
		try{
			
			if (!changed)
				return;
			if (true) {
				arrLocal = observers.toArray();
				changed = false;
			}
		}finally
		{
			lockObs.unlock();
		}
		

		

		for (int i = 0; i < arrLocal.length; i++) {

			((Observer) arrLocal[i]).update(obs, arg);
		}

	}
}
