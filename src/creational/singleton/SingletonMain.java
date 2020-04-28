package creational.singleton;

public class SingletonMain {
	
	public static void main(String[] args) {
		Earth singleton = Earth.getInstance();
		Earth singleton2 = Earth.getInstance();
		singleton.population = 1_000_000_000L;
		System.out.println(singleton2.population);
	}

}

class Earth {
	
	private static final Earth planetEarth = new Earth();
	
	long population = 7_000_000_000L;
	
	private Earth() {
//		Runtime.getRuntime();
	}
	
	public static Earth getInstance() {
		return planetEarth;
	}
	
}