package other.transfer_object;

public class TransferObjectMain {
	
	public static void main(String[] args) {
		
	}

}

class User {
	
	String name;
	
	int age;

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
	
}

class ServiceEJB {
	
	public User getUser() {
		User user = new User();
		user.setName("User from DB");
		return user; 
	}
	
}

class BusinessObject {
	
	ServiceEJB serviceEJB = new ServiceEJB();
	
	public User getUser() {
		return serviceEJB.getUser();
	}
	
}

//
//
//
//
//
