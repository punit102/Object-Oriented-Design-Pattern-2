package edu.umb.cs.cs681;

public class ThreadRunner implements Runnable {

	private TableObserver to;
	private PieChartObserver pco;
	private ThereeDObserver tdo;
	private StockQuoteObservable ss;

	ThreadRunner() {
		to = new TableObserver();
		pco = new PieChartObserver();
		tdo = new ThereeDObserver();
		ss = new StockQuoteObservable();
		ss.addObserver(pco);
		ss.addObserver(tdo);
		ss.addObserver(to);
	}

	@Override
	public void run() {
	
		ss.changeQuote("Uber", 242.00f);
		ss.changeQuote("Uber", 252.00f);

	}

}
