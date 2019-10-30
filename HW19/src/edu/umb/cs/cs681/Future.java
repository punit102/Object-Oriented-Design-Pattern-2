package edu.umb.cs.cs681;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Future implements Pizza {
	private RealPizza realPizza = null;
	private ReentrantLock lock;
	private Condition ready;

	public Future() {
		lock = new ReentrantLock();
		ready = lock.newCondition();
	}

	public void setRealPizza(RealPizza real) {
		lock.lock();
		try {
			if (realPizza != null) {
				return;
			}
			realPizza = real;
			ready.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public String getPizza(long timeout)  {
		String pizzaData = null;
		// For the Checking purpose 
		//realPizza = null;
		lock.lock();
		try {
			if (realPizza == null) {
				
				if(!ready.await(timeout, TimeUnit.MILLISECONDS))
				{
					try
					{
						throw new CasherTimeoutException();
					}
					catch (CasherTimeoutException e1) {
						e1.printStackTrace();
					}
				}
			}else
			{
				pizzaData = realPizza.getPizza(timeout);
			}
			
		} catch (InterruptedException e) {
			try {
				throw new CasherTimeoutException();
			} catch (CasherTimeoutException e1) {
				e1.printStackTrace();
			}
			
		} finally {
			lock.unlock();
		}
		return pizzaData;
	}
	

	public boolean isReady() {
		if (realPizza != null) {
			return true;
		} else {
			return false;
		}
	}

	

}
