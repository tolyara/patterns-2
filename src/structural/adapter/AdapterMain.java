package structural.adapter;

public class AdapterMain {
	
	public static void main(String[] args) {
		CarWash carWash = new CarWash();
		carWash.washCar(new BicycleAdapter(new Pride()));
	}

}

class BicycleAdapter implements Car {
	
	Bicycle bicycle;

	public BicycleAdapter(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	@Override
	public void wash() {
		bicycle.clean();
	}
	
}


interface Bicycle {
	
	void clean();
	
}

class Pride implements Bicycle {

	@Override
	public void clean() {
		System.out.println("Pride bike is being cleaned...");
	}	
	
}

interface Car {
	
	void wash();
	
}

class Audi implements Car {

	@Override
	public void wash() {
		System.out.println("Audi car is being washed...");
	}	
	
}

class CarWash {
	
	void washCar(Car car) {
		car.wash();
	}
	
}
