package structural.bridge;

// prefer composition over inheritance
public class BridgeMain {

	public static void main(String[] args) {
		Car car = new ToyotaCar(new CarDriving());
		car.drive();
		Truck truck = new ToyotaTruck(new TruckDriving());
		truck.drive();
	}

}

abstract class Car {

	Driveable driveable;

	public Car(Driveable driveable) {
		this.driveable = driveable;
	}

	abstract void drive();

}

abstract class Truck {

	Driveable driveable;

	public Truck(Driveable driveable) {
		this.driveable = driveable;
	}

	abstract void drive();

}

//Bridge
interface Driveable {

	void drive();
	
}

class CarDriving implements Driveable {

	@Override
	public void drive() {
		System.out.println("Car driving...");
	}
	
}

class TruckDriving implements Driveable {
	
	@Override
	public void drive() {
		System.out.println("Truck driving...");
	}
	
}

class ToyotaCar extends Car {

	public ToyotaCar(Driveable driveable) {
		super(driveable);
	}

	@Override
	void drive() {
		System.out.println("Toyota engine starts...");
		driveable.drive();
	}
	
}

class AudiCar extends Car {

	public AudiCar(Driveable driveable) {
		super(driveable);
	}

	@Override
	void drive() {
		System.out.println("Audi engine starts...");
	}
	
}

class ToyotaTruck extends Truck {

	public ToyotaTruck(Driveable driveable) {
		super(driveable);
	}

	@Override
	void drive() {
		System.out.println("Toyota truck engine starts...");
		driveable.drive();
	}
	
}


//class ToyotaCar implements Car {}
//
//class AudiCar implements Car {}
//
//class ToyotaTruck implements Truck {}
//
//class AudiTruck implements Truck {}