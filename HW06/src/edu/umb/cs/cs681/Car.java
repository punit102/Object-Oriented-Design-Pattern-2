package edu.umb.cs.cs681;

public class Car {
	private int price;
	private int year;
	private int mileage;

	public Car(int price, int year, int mileage) {
		this.price = price;
		this.year = year;
		this.mileage = mileage;
	}

	public int getPrice() {
		return price;
	}

	public int getYear() {
		return year;
	}

	public int getMileage() {
		return mileage;
	}
}