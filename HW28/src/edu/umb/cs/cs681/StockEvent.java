package edu.umb.cs.cs681;

public class StockEvent {

	private String ticker;
	private double quote;

	StockEvent(String t, double q) {
		this.ticker = t;
		this.quote = q;
	}

	public String getTicker() {
		return ticker;
	}

	public double getQuote() {
		return quote;
	}
}
