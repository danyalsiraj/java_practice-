package students;

public class Student {
	
	String name;
	int id;
	int age;

	public Student(String studentName, int studentId, int studentAge) {
		name = studentName;
		age = studentAge;
		id = studentId;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s, Age: %s, ID: %s", name, age, id);
	}
}
