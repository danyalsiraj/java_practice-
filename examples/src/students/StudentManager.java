package students;

import java.util.ArrayList;
import java.util.Collections;

public class StudentManager {

	ArrayList<Student> students = new ArrayList<Student>();
	String regionName;

	public StudentManager(String regionName) {
		this.regionName = regionName;// this refers to current object and then normal regionName gives preference to
										// the local one first
	}

	public StudentManager() {
		regionName = "Canada";
	}

	public void save(Student student) {
		
		//you do some validation
		students.add(student);

	}
	
	public void save(ArrayList<Student> students) {
		for(Student student : students) {
			save(student);
		}
	}

	public void save(String name, int age, int id) {
//		students.add(new Student(name, age, id));
		save(new Student(name, age, id));
	}
	public Student search(int id) {

//		for (int i = 0; i < students.size(); i++) {
//			if (students.get(i).id == id) {
//				return students.get(i);
//			}
//		}
		for(Student student : students) {
			if (student.id == id) {
				return student;
			}
		}
		return null;
	}

}
