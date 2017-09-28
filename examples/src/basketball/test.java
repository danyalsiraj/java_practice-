package basketball;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		File file = new File("playerdb.txt");
		Scanner searchFile = null;
		ArrayList<Player> allPlayers = new ArrayList<Player>();
		if (file.exists()) {
			try {
				searchFile = new Scanner(file).useDelimiter(",");
				while (searchFile.hasNext()) {
//				System.out.println(searchFile.next());
//				System.out.println(searchFile.next());
//				System.out.println(searchFile.nextDouble());
//				System.out.println(searchFile.nextDouble());
//				System.out.println(searchFile.nextDouble());
//				searchFile.nextLine();
//				System.out.println(searchFile.next());
//				System.out.println(searchFile.next());
//				System.out.println(searchFile.nextDouble());
//				System.out.println(searchFile.nextDouble());
//				System.out.println(searchFile.nextDouble());

				//allPlayers.add(new Player("sads", "asda", 1.0,2.0, 3.0));
				
				allPlayers.add(new Player(searchFile.next(), searchFile.next(), searchFile.nextDouble(),
						searchFile.nextDouble(), searchFile.nextDouble()));
				searchFile.nextLine();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println((allPlayers));
		}
	}
	
	
}
