package basketball;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import person.Person;
import students.Student;

public class Player extends Person {
	double ppg, rpg, apg;
	public static final String FILE_NAME = "playerdb.txt";
	

	public Player(String firstN, String lastN, double points, double rebounds, double assists) {
		super(firstN, lastN);
		ppg = points;
		rpg = rebounds;
		apg = assists;
		setfName("Asdf");
		this.setfName("asdf");
	}

	

	

}
