package edu.umb.cs.cs681;

import java.util.ArrayList;

public class Observable {

	private ArrayList<Observer> observers;
	private boolean checkHasChanged;
	private Observable obs;

	public Observable() {
		observers = new ArrayList<Observer>();
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

		if (checkHasChanged == true) {
			return true;
		} else {
			return false;
		}
	}

	protected void setChanged() {
		System.out.println("Set changed is called and hasChanged is set to true...");
		this.checkHasChanged = true;

	}

	protected void clearChanged() {
		System.out.println("clearChanged is called and hasChanged is set to false...");
		this.checkHasChanged = false;

	}

	public void notifyObservers(Object obj) {

		for (Observer ob : observers) {
			ob.update(obs, obj);
		}

	}
}

