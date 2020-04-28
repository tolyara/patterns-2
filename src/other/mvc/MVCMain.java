package other.mvc;

public class MVCMain {
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.execute();
	}

}

interface ModelLayer {
	
	Student getStudent();
	
}

class DBLayer implements ModelLayer {

	@Override
	public Student getStudent() {		
		return new Student("test", 23);
	}
	
}

class Controller {
	
	ModelLayer dbLayer = new DBLayer();
	View consoleView = new ConsoleView();
	
	void execute() {
		Student student = dbLayer.getStudent();
		consoleView.showStudent(student);
	}
	
}

interface View {
	
	void showStudent(Student student);
	
}

class ConsoleView implements View {

	@Override
	public void showStudent(Student student) {
		System.out.println(student);
	}	
	
}

class Student {
	
	String name;
	int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}