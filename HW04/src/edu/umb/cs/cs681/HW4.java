package edu.umb.cs.cs681;

public class HW4 {

	public static void main(String[] args) {

		Observable observable = new Observable();
		observable.setChanged();
		observable.addObserver((Observable o, Object obj) -> {
			System.out.println(obj);
		});
		observable.addObserver((Observable o, Object obj) -> {
			System.out.println(obj);
		});
		observable.notifyObservers("Hello World!");

		observable.addObserver((Observable o, Object obj) -> {
			System.out.println(obj);
		});

		observable.addObserver((Observable o, Object obj) -> {
			System.out.println(obj);
		});
		
		observable.setChanged();
		observable.notifyObservers("Hello World agarin anf then noify to all added Observers till this time");

	}

}
