package behavioral.visitor;

// create visitor which will launch external code
public class VisitorMain {
	
	public static void main(String[] args) {
		Animal dog = new Dog();
		Animal cat = new Cat();
		Human child = new Child();
		Human adult = new Adult();
		
		dog.playWithHuman(child);
		cat.playWithHuman(child);
		System.out.println();
		dog.playWithHuman(adult);
		cat.playWithHuman(adult);		
	}

}

interface Animal {
	
	void playWithHuman(Human human);
	
}

class Dog implements Animal {

	@Override
	public void playWithHuman(Human human) {
		human.playWithDog();
	}	
	
}

class Cat implements Animal {

	@Override
	public void playWithHuman(Human human) {
		human.playWithCat();
	}	
	
}

//Visitor
interface Human {
	
	void playWithDog();
	
	void playWithCat();
	
}

class Child implements Human {

	@Override
	public void playWithDog() {
		System.out.println("Child throws freesbee to doggie...");
	}

	@Override
	public void playWithCat() {
		System.out.println("Child stroking a kitty...");
	}
	
}

class Adult implements Human {

	@Override
	public void playWithDog() {
		System.out.println("Adult silently walks with a dog...");
	}

	@Override
	public void playWithCat() {
		System.out.println("Adult silently walks with a cat...");
	}
	
}


//