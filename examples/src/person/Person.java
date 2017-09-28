package person;

public class Person {

	private String fName, lName;
	private int age;
	
	public Person(String fName, String lName, int age){
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}
	
	public Person(String fName, String lName){
		this.fName = fName;
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
