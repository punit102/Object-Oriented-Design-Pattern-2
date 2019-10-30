package edu.umb.cs.cs681;

import java.util.ArrayList;

public class HW6 {

	public static void main(String[] args) {
		ArrayList<Car> usedCars = new ArrayList<Car>();
		usedCars.add(new Car(4000, 1999, 14));
		usedCars.add(new Car(8000, 2015, 12));
		usedCars.add(new Car(3000, 2010, 16));
		usedCars.add(new Car(2000, 2012, 20));

		Integer price = usedCars.stream()

				.map((Car car) -> car.getPrice())
				.reduce(0, (result, carPrice) -> {
					if (result == 0)
						return carPrice;
					else if (carPrice < result)
						return carPrice;
					else
						return result;
				});

		System.out.println("Minimum car Value from the stream of car objects : " + price);

	}

}
