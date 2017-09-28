package search.students;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Students {
	public static final String FILE_NAME = "studentsinfo.txt";

	public static void main(String[] args) {
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

	/**
	 * 
	 */
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
			file = new FileWriter(FILE_NAME,true);
			PrintWriter writer = new PrintWriter(file);
			// write.print(id+","+name+","+age);
			// write.printf("%s,%s,%s", id, name, age);//above two dont print
			// new line
			writer.println(String.format("%s,%s,%s", id, name, age));
			writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//			try {
//				file.createNewFile();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		

//		PrintWriter writer = new PrintWriter(file);
//		// write.print(id+","+name+","+age);
//		// write.printf("%s,%s,%s", id, name, age);//above two dont print
//		// new line
//		writer.println(String.format("%s,%s,%s", id, name, age));
//		writer.close();

	}

	public static void search() {
		File file = new File(FILE_NAME);

		if (file.exists()) {
			System.out.println("enter student id");
			Scanner scan = new Scanner(System.in);
			int id = scan.nextInt();
			Scanner searchFile = null;
			boolean isFound = false;
			// "a,b,c".split(",") = ["a","b","c"]
			//
			try {
				searchFile = new Scanner(file).useDelimiter(",");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (searchFile.hasNext()) {
				if (searchFile.nextInt() == id) {
					isFound = true;
					//searchFile.nextLine().replaceAll(regex, replacement)
					System.out.println("ID:" + id);
					System.out.println("name:" + searchFile.next());
					System.out.println("age:" + searchFile.next());
					break;
				} else
					searchFile.nextLine();// to ignore the rest of the line
			}
			if (!isFound)
				System.out.println("No student found");
			searchFile.close();
		} else
			System.out.println("no students");
	}

}
