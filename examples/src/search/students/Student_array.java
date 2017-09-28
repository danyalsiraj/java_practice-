package search.students;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Student_array {
	public static final String FILE_NAME = "studentsinfo.txt";
	public static final int NUM_OF_STUDENTS = 0;
	public static final ArrayList<String> STUDENT_ID = new ArrayList<>();
	public static final ArrayList<String> NAME = new ArrayList<>();
	public static final ArrayList<String> AGE = new ArrayList<>();

	public static void main(String[] args) {
		loadDatabase();
		while (true) {
			System.out.println(" enter 1 to save student OR 2 to search student or 3 to quit");
			Scanner scan = new Scanner(System.in);
			String choice = scan.nextLine();
			if (choice.equals("1"))
				save();
			else if (choice.equals("2"))
				search();
			else if (choice.equals("3"))
				break;
			else
				System.out.println("enter a valid choice");
		}

	}

	public static void loadDatabase() {
		File file = new File(FILE_NAME);
		if (file.exists()) {
			Scanner searchFile = null;
			// "a,b,c".split(",") = ["a","b","c"]
			//
			try {
				searchFile = new Scanner(file).useDelimiter(",");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (searchFile.hasNextLine()) {

				STUDENT_ID.add(searchFile.next());
				System.out.println(STUDENT_ID);
				NAME.add(searchFile.next());
				System.out.println(NAME);
				AGE.add(searchFile.next());
				System.out.println(AGE);
				searchFile.next();
			}
		}
		else
			return;
	}

	public static void updateDatabase(int id, String name, int age) {
		STUDENT_ID.add(Integer.toString(id));
		NAME.add(name);
		AGE.add(Integer.toString(age));

	}

	private static void search() {
		File file = new File(FILE_NAME);
		if (!file.exists()) {
			System.out.println("You don't have any students yet");
			return;
		}

		System.out.println("Enter student id");
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		boolean isfound = false;
		for (int i = 0; i < STUDENT_ID.size(); i++) {
			if (STUDENT_ID.get(i).equals(id)) {
				System.out.println("ID:" + id);
				System.out.println("name:" + NAME.get(i));
				System.out.println("age:" + AGE.get(i));
				isfound = true;
				break;
			}
		}
		if (!isfound)
			System.out.println("No student found");

	}

	public static void save() {
		System.out.println("Enter name");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine().trim();// trim the string returned by next
												// line
		System.out.println("Enter Student ID");
		int id = scan.nextInt();
		System.out.println("Enter Age");
		int age = scan.nextInt();

		if (name.equals("") || id <= 0 || age <= 0) {
			System.out.println("invalid entry");
			save();
			return;
		}

		FileWriter file;
		try {
			file = new FileWriter(FILE_NAME, true);
			PrintWriter writer = new PrintWriter(file);
			//writer.print(id+","+name+","+age);
			//writer.printf("%s,%s,%s%n", id, name, age);//above two dont print
			// new line
			writer.println(String.format("%s,%s,%s", id, name, age));
			updateDatabase(id, name, age);
			writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
////////////////////////////////////////////////////////
// public static void save() {
// System.out.println("Enter name");
// Scanner scan = new Scanner(System.in);
// String name = scan.nextLine().trim();// trim the string returned by next
// // line
// System.out.println("Enter Student ID");
// int id = scan.nextInt();
// System.out.println("Enter Age");
// int age = scan.nextInt();
//
// if (name.equals("") || id <= 0 || age <= 0) {
// System.out.println("invalid entry");
// save();
// return;
// }
//
// File file = new File(FILE_NAME);
// try {
// file.createNewFile();
// } catch (IOException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
//
// try {
// PrintWriter writer = new PrintWriter(file);
// // write.print(id+","+name+","+age);
// // write.printf("%s,%s,%s", id, name, age);//above two dont print
// // new line
// writer.println(String.format("%s,%s,%s", id, name, age));
// updateDatabase(id, name, age);
// writer.close();
// } catch (FileNotFoundException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
//
// }
