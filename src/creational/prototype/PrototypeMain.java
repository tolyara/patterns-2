package creational.prototype;

public class PrototypeMain {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		StudentCache cache = new StudentCache();
		
		Student student = new Student();
		student.setStatus("origin");
		cache.setStudent(student);
		
		Student cachedStudent = cache.getStudent();
		cachedStudent.setStatus("changed");
		System.out.println(student);
		System.out.println(cachedStudent);
	}

}

class Student implements Cloneable {
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public Student clone() throws CloneNotSupportedException {
		return (Student) super.clone();
	}

	@Override
	public String toString() {
		return "Student [status=" + status + "]";
	}	
	
}

class StudentCache {
	
	private Student student;

	public Student getStudent() throws CloneNotSupportedException {
		return student.clone();
//		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}



