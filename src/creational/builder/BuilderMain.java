package creational.builder;

public class BuilderMain {

	public static void main(String[] args) {
		SportCar sportCar = new SportCar.Builder()
			.setNameAndColour("Audi", "green")
			.setTechParameters(4, 200)
			.build();
		System.out.println(sportCar);
	}

}

class SportCar {

	private String name;
	private String color;

	private int numberOfSeats;
	private int maxSpeed;

	private SportCar() {

	}
	
	private SportCar getThis() {
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "SportCar [name=" + name + ", color=" + color + ", numberOfSeats=" + numberOfSeats + ", maxSpeed="
				+ maxSpeed + "]";
	}

	static class Builder {

		private SportCar sportCar;

		public Builder() {
			sportCar = new SportCar();
		}

		public Builder setNameAndColour(String name, String color) {
			sportCar.setName(name);
			sportCar.setColor(color);
			return this;
		}
		
		public Builder setTechParameters(int numberOfSeats, int maxSpeed) {
			sportCar.setNumberOfSeats(numberOfSeats);
			sportCar.setMaxSpeed(maxSpeed);
			return this;
		}		

		SportCar build() {
			return sportCar;
		}

	}

}
