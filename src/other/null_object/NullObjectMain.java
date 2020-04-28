package other.null_object;

public class NullObjectMain {

	public static void main(String[] args) {
		Animal animal = getAnimal();
		animal.eat();
	}

	static Animal getAnimal() {
//		return new Lion();
		return new NullAnimal();
//		return null;
	}

}

interface Animal {

	void eat();

}

class Lion implements Animal {

	@Override
	public void eat() {
		System.out.println("Lion is eating...");
	}

}

class NullAnimal implements Animal {

	@Override
	public void eat() {

	}

}