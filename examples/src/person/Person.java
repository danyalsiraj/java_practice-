package person;

public class Person implements Comparable<Person> {

	private String fName, lName;
	private int age;

	public Person(String fName, String lName, int age) {
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}

	public Person(String fName, String lName) {
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

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		if (age > o.age)
			return 1;
		else if (age == o.age)
			return 0;

		return -1;
	}
	
	public String toString(){
		return String.format("firstName: %s lastName:%s age:%s ", fName,lName,age);
	}

}
