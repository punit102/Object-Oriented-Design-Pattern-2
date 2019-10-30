package edu.umb.cs.cs681;

public class ThereeDObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {

		((StockEvent) arg).getTicker();
		((StockEvent) arg).getQuote();
		System.out.print("ThreeDObserver Stock Ticker:" + ((StockEvent) arg).getTicker()+"\n");
		System.out.print("ThreeDObserver Stock Quote:" + ((StockEvent) arg).getQuote()+"\n");

	}

}
