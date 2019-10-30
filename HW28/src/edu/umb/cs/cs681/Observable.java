package edu.umb.cs.cs681;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Observable {

	private boolean changed = false;
	private Observable obs;
	private ReentrantLock lockObs;
	private CopyOnWriteArrayList<Observer> observers;

	public Observable() {

		observers = new CopyOnWriteArrayList<Observer>();
		lockObs = new ReentrantLock();
	}

	public void addObserver(Observer o) {

		
			observers.add(o);
			System.out.println("New Observer Added");
	}

	public void deleteObserver(Observer o) {

	
			observers.remove(o);
			System.out.println("Observer Deleted");

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

		lockObs.lock();
		try
		{
			if (!changed)
				return;

			if (true) {
				changed = false;
			}
		}finally{
			lockObs.unlock();
		}

		Iterator<Observer> it = observers.iterator();
		while (it.hasNext()) {
			((Observer) it.next()).update(obs, arg);
		}

	}
}
