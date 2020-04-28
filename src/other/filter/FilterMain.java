package other.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterMain {

	public static void main(String[] args) {
		Car car1 = new Car("red", 160);
		Car car2 = new Car("green", 180);
		Car car3 = new Car("blue", 200);

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);

//		List<Car> filteredCars = new SpeedFilter().filter(cars);
//		filteredCars = new ColorFilter().filter(filteredCars);
//		for (Car car : filteredCars) {
//			System.out.println(car);
//		}

//		AndFilter andFilter = new AndFilter(new SpeedFilter(), new ColorFilter());
//		List<Car> filteredCars = andFilter.filter(cars);
		CarFilter orFilter = new OrFilter(new SpeedFilter(), new ColorFilter());
		List<Car> filteredCars = orFilter.filter(cars);
		for (Car car : filteredCars) {
			System.out.println(car);
		}

	}

}

interface CarFilter {

	List<Car> filter(List<Car> cars);

}

// > 170
class SpeedFilter implements CarFilter {

	@Override
	public List<Car> filter(List<Car> cars) {
		List<Car> list = new ArrayList<>();
		for (Car car : cars) {
			if (car.maxSpeed > 170) {
				list.add(car);
			}
		}
		return list;
	}

}

// only green
class ColorFilter implements CarFilter {

	@Override
	public List<Car> filter(List<Car> cars) {
		List<Car> list = new ArrayList<>();
		for (Car car : cars) {
			if (car.color.equalsIgnoreCase("green")) {
				list.add(car);
			}
		}
		return list;
	}

}

class FilterSet {

	CarFilter filterOne;
	CarFilter filterTwo;
	
	public FilterSet() {
		
	}

	public FilterSet(CarFilter filterOne, CarFilter filterTwo) {
		this.filterOne = filterOne;
		this.filterTwo = filterTwo;
	}

}

class AndFilter extends FilterSet implements CarFilter {

	public AndFilter(CarFilter filterOne, CarFilter filterTwo) {
		super(filterOne, filterTwo);
	}

	@Override
	public List<Car> filter(List<Car> cars) {
		List<Car> list = filterOne.filter(cars);
		return filterTwo.filter(list);
	}

}

class OrFilter extends FilterSet implements CarFilter {

	public OrFilter(CarFilter filterOne, CarFilter filterTwo) {
		super(filterOne, filterTwo);
	}

	@Override
	public List<Car> filter(List<Car> cars) {
		List<Car> list = filterOne.filter(cars);
		List<Car> list2 = filterTwo.filter(cars);
		for (Car car : list2) {
			if (!list.contains(car)) {
				list.add(car);
			}
		}
		return list;
	}

}

class Car {

	String color;
	int maxSpeed;

	@Override
	public String toString() {
		return "Car [color=" + color + ", maxSpeed=" + maxSpeed + "]";
	}

	public Car(String color, int maxSpeed) {
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

}