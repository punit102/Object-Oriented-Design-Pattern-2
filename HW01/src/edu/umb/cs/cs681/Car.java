package edu.umb.cs.cs681;

public class Car {
	private int price;
	private int year;
	private int mileage;

	Car(int price, int year, int mileage) {
		this.price = price;
		this.year = year;
		this.mileage = mileage;
	}

	int getPrice() {
		return price;
	}

	int getYear() {
		return year;
	}

	int getMileage() {
		return mileage;
	}
}
