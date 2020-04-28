package creational.factory_method;

public class FactoryMethodMain {
	
	public static void main(String[] args) {
		Person person = Person.create();
	}

}

class Person {
	
	private Person() {
		
	}
	
	static Person create() {
		return new Person();
	}
	
}
