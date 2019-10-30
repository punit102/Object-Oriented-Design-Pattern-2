package edu.umb.cs.cs681;

public class TableObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		((StockEvent) arg).getTicker();
		((StockEvent) arg).getQuote();
		System.out.print("TableObserver Stock Ticker:"+((StockEvent) arg).getTicker()+"\n");
		System.out.print("TableObserver Stock Quote:"+((StockEvent) arg).getQuote()+"\n");
	}

}