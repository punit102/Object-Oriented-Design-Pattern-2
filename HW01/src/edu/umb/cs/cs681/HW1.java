package edu.umb.cs.cs681;

import java.util.ArrayList;
import java.util.Collections;

public class HW1 {

	public static void main(String args[]) {

		ArrayList<Car> usedCars = new ArrayList<Car>();
		usedCars.add(new Car(4000, 1999, 14));
		usedCars.add(new Car(8000, 2015, 12));
		usedCars.add(new Car(3000, 2010, 16));
		usedCars.add(new Car(2000, 2012, 20));

		Collections.sort(usedCars, (Car o1, Car o2) -> o1.getPrice() - o2.getPrice());
		System.out.println("Natural Ordering of Car comparator");
		System.out.println("Price Comparator: ");

		for (Car a : usedCars) {
			System.out.println(a.getPrice());
		}

		Collections.sort(usedCars, (Car o1, Car o2) -> o2.getYear() - o1.getYear());
		System.out.println("Year Comparator: ");

		for (Car a : usedCars) {
			System.out.println(a.getYear());
		}

		Collections.sort(usedCars, (Car o1, Car o2) -> o2.getMileage() - o1.getMileage());
		System.out.println("Mileage Comparator: ");

		for (Car a : usedCars) {
			System.out.println(a.getMileage());
		}

		Collections.reverse(usedCars);
		System.out.println("Reverse Ordering of Car comparator");
		System.out.println("Reverse Order Price Comparator: ");

		for (Car a : usedCars) {
			System.out.println(a.getPrice());
		}

		Collections.reverse(usedCars);
		System.out.println("Reverse order Year Comparator: ");

		for (Car a : usedCars) {
			System.out.println(a.getYear());
		}

		Collections.reverse(usedCars);
		System.out.println("Reverse order Mileage Comparator: ");

		for (Car a : usedCars) {
			System.out.println(a.getMileage());
		}

	}
}
