package students;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		StudentManager canadaSM = new StudentManager();
		StudentManager pakSM = new StudentManager("Pakistan");
		Student student = new Student("Zaid", 123, 11);

		canadaSM.save(student);
		canadaSM.save("dany", 1,1);
		
	
		ArrayList<Student> someStudents = new ArrayList<Student>();
		someStudents.add(new Student("dany2",122,12));
		someStudents.add(new Student("dany3",123,12));
		someStudents.add(new Student("dany4",124,12));
		someStudents.add(new Student("dany5",125,12));
		pakSM.save(someStudents);

		
		

		
		System.out.println("Pak lists: "+ pakSM.students);
		System.out.println("Canada region "+canadaSM.students );
	}
	
	public static void changeNameTo(Student[] students, int index, String newName) {
		students[index].name = newName;
	}

	public static void changeNameTo(Student student, String newName) {
		student.name = newName;
	}

}
