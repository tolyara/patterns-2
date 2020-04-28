package structural.facade;

// all complexity encapsulated in one class/method
public class FacadeMain {
	
	public static void main(String[] args) {
		JobSearch jobSearch = new JobSearch();
		jobSearch.beginJobSearch();
	}

}

class JobSearch {
	
	Trainee trainee = new Trainee("Anatolii");
	
	void beginJobSearch() {
		trainee.sendCV();
		trainee.exercise(new JavaTraining());
		trainee.exercise(new EnglishTraining());
	}
	
}

class Trainee {
	
	String name;
	
	public Trainee(String name) {
		this.name = name;
	}

	void sendCV() {
		System.out.println(name + " is actively sending his CV to IT-companies...");
	}
	
	void exercise(Activity activity) {
		System.out.print(name + " is now studying - ");
		activity.execute();
	}
	
}

interface Activity {
	
	void execute();
	
}

class JavaTraining implements Activity {

	@Override
	public void execute() {
		System.out.println("learning Java...");
	}
	
}

class EnglishTraining implements Activity {

	@Override
	public void execute() {
		System.out.println("learning English...");
	}
	
}








