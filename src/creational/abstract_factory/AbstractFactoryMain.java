package creational.abstract_factory;

import java.util.Arrays;

public class AbstractFactoryMain {

	public static void main(String[] args) {
		Factory<Car> carFactory = new AbstractFactory().createFactory("Car");
		Car toyota = carFactory.create("Toyota");
		Car audi = carFactory.create("Audi");

		Factory<Tank> tankFactory = new AbstractFactory().createFactory("Tank");
		Tank t51 = tankFactory.create("T51");
		Tank kv1 = tankFactory.create("KV1");
		
		for (Driveable vehicle : Arrays.asList(toyota, audi, t51, kv1)) {
			vehicle.drive();
		}		
	}

}

interface Driveable {
	
	void drive();
	
}

interface Car extends Driveable {

}

class Toyota implements Car {

	@Override
	public void drive() {
		System.out.println("Toyota driving...");
	}

}

class Audi implements Car {

	@Override
	public void drive() {
		System.out.println("Audi driving...");
	}

}

class CarFactory implements Factory<Car> {

	@Override
	public Car create(String carType) {
		switch (carType) {
		case "Toyota":
			return new Toyota();
		case "Audi":
			return new Audi();
		default:
			return null;
		}
	}

}

interface Tank extends Driveable {

}

class T51 implements Tank {

	@Override
	public void drive() {
		System.out.println("T51 driving...");
	}

}

class KV1 implements Tank {

	@Override
	public void drive() {
		System.out.println("KV1 driving...");
	}

}

class TankFactory implements Factory<Tank> {

	@Override
	public Tank create(String tankType) {
		switch (tankType) {
		case "T51":
			return new T51();
		case "KV1":
			return new KV1();
		default:
			return null;
		}
	}

}

interface Factory<T> {

	T create(String type);

}

class AbstractFactory {

	Factory createFactory(String factoryType) {
		switch (factoryType) {
		case "Car":
			return new CarFactory();
		case "Tank":
			return new TankFactory();
		default:
			return null;
		}
	}

}
