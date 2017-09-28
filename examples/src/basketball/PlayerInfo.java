package basketball;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerInfo {

	public static void main(String[] args) {
		Team team=new Team("raptors");
		team.init();

		while (true) {
			System.out.println("Select one of the following options:");
			System.out.println("1. Save a player");
			System.out.println("2. Search a player");
			System.out.println("3. Update player info");
			System.out.println("4. Compare players");
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();

			if (choice == 1) {
				System.out.println("First Name");
				String firstName = scan.next().trim();
				System.out.println("Last Name");
				String lastName = scan.next().trim();
				System.out.println("Points Per Game");
				int ppg = scan.nextInt();
				System.out.println("Rebounds Per Game");
				int rpg = scan.nextInt();
				System.out.println("Assists Per Game");
				int apg = scan.nextInt();
				Player player = new Player(firstName, lastName, ppg, rpg, apg);
				team.save(player);

			}
			if (choice == 2) {
				System.out.println("Enter player's First name to search");
				Scanner scan2 = new Scanner(System.in);
				String name = scan2.nextLine().trim();
				Player player = new Player("", "", 0.0, 0.0, 0.0);
				team.search(name);
			}
			if (choice == 3) {
				System.out.println("Enter player's First name to update the info");
				Scanner scan2 = new Scanner(System.in);
				String name = scan2.nextLine().trim();
				System.out.println("Select what you want to update");
				System.out.println("1. First Name");
				System.out.println("2. Last Name");
				System.out.println("3. PPG");
				System.out.println("4. RPG");
				System.out.println("5. APG");
				choice = scan2.nextInt();
				Player player = new Player("", "", 0.0, 0.0, 0.0);
				team.update(name, choice);

			}
			if (choice == 4) {

			}

		}
	}

}
