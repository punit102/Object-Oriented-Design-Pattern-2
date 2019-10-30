package edu.umb.cs.cs681;

public class PieChartObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		((StockEvent) arg).getTicker();
		((StockEvent) arg).getQuote();
		System.out.print("PieChartObserver Stock Quote:" + ((StockEvent) arg).getQuote()+"\n");
		System.out.print("PieChartObserver Stock Ticker:" + ((StockEvent) arg).getTicker()+"\n");
	}

	
}
