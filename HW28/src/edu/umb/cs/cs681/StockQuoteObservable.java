package edu.umb.cs.cs681;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class StockQuoteObservable extends Observable {

	private ReentrantLock lockTQ;
	HashMap<String, Double> map = new HashMap<>();

	StockQuoteObservable() {
		lockTQ = new ReentrantLock();
	}

	public void changeQuote(String t, double q) {

		lockTQ.lock();
		try {
			setChanged();
			map.put(t, q);
			notifyObservers(new StockEvent(t, q));
		} finally {
			lockTQ.unlock();
		}

	}
}