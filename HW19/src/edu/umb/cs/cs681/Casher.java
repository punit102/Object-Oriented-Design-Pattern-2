package edu.umb.cs.cs681;

import java.util.concurrent.locks.ReentrantLock;

public class Casher {
	private static Future future = new Future();
	private static ReentrantLock lock;

	Casher(){
		lock = new ReentrantLock();
	}
	
	public Pizza order() {
		System.out.println("An order is made.");
		
		Thread t = new Thread(()->{
			RealPizza realPizza = new RealPizza();
			future.setRealPizza(realPizza);
			
		});
		t.start();
		return future;
	}

	public static void main(String[] args) throws CasherTimeoutException {
		Casher casher = new Casher();
		System.out.println("Ordering pizzas at a casher counter.");
		Pizza p1 = casher.order();
		Pizza p2 = casher.order();
		Pizza p3 = casher.order();
		
		while (true) {
			lock.lock();
			if (future.isReady()) {
				future.getPizza(400);
				break;
			}
			lock.unlock();
		}
		
		System.out.println(
				"Doing something, reading newspapers, magazines, etc., " + "until pizzas are ready to pick up...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}

		System.out.println("Let's see if pizzas are ready to pick up...");
		System.out.println(p1.getPizza(400));
		System.out.println(p2.getPizza(400));
		System.out.println(p3.getPizza(400));
		
	}
}
