package basketball;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Team {
	public final ArrayList<Player> allPlayers = new ArrayList<Player>();
	public static final String DEFAULT_DIR_NAME = "ballDB";
	String dirName = DEFAULT_DIR_NAME;
	
	
	public Team(String dirName) {
		this.dirName = dirName;
	}
	
	
	public Team() {
	}
	
	
	
	public void init() {
		loadPlayers();
	}

	public void save(Player player) {
		if (player.getfName().equals("") || player.getlName().equals("") || player.ppg < 0 || player.rpg < 0 || player.apg < 0) {
			System.out.println("Please enter valid info");
			save(player);
		}
		File file;
		try {

			file = new File(String.format("%s/%s.txt", dirName, player.getfName()));
			File dir = file.getParentFile();

			// make all dir until DIR_NAME
			if (!dir.exists())
				dir.mkdirs();

			PrintWriter writer = new PrintWriter(file);
			writer.println(String.format("%s,%s,%s,%s,%s,", player.getfName(), player.getlName(), player.ppg, player.rpg,
					player.apg));
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateplayers(player);

	}
	
	public void update(String name, int choice) {
		Scanner scan = new Scanner(System.in);
		for (Player player : allPlayers) {

			if (player.getfName().equalsIgnoreCase(name)) {
				if (choice == 1) {
					System.out.println("Enter new First Name");
					player.setfName(scan.nextLine());
				}
				if (choice == 2) {
					System.out.println("Enter new Last Name");
					player.setlName(scan.nextLine());
				}
				if (choice == 3) {
					System.out.println("Enter new Last Name");
					player.ppg = scan.nextInt();
				}
				if (choice == 4) {
					System.out.println("Enter new Last Name");
					player.rpg = scan.nextInt();
				}
				if (choice == 5) {
					System.out.println("Enter new Last Name");
					player.apg = scan.nextInt();
				}

				save(player);
			}
		}
	}

	public void loadPlayers() {

		File file = new File(dirName);
		Scanner searchFile = null;

		if (file.exists()) {
			try {
				File[] list = file.listFiles();
				for (File playerFile : list) {
					loadPlayer(playerFile);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(allPlayers);

		}

	}
	
	private void loadPlayer(File playerFile) throws FileNotFoundException {
		Scanner searchFile = new Scanner(playerFile);
		searchFile.useDelimiter(",");
		if (searchFile.hasNext()) {
			String fName =  searchFile.next();
			String lName = searchFile.next();
			double ppg = searchFile.nextDouble();
			double rpg = searchFile.nextDouble();
			double apg = searchFile.nextDouble();
			allPlayers.add(new Player(fName, lName, ppg, rpg, apg));
		}
		searchFile.close();
	}
	public void search(String name) {
		for (Player player : allPlayers) {
			if (player.getfName().equalsIgnoreCase(name)) {
				System.out.println(String.format("First Name: %s%nLast Name: %s%nPPG: %s%nRPG: %s%nAPG: %s",
						player.getfName(), player.getlName(), player.ppg, player.rpg, player.apg));
			}
		}

	}

	/**
	 * 
	 * @param player
	 * @throws NullPointerException
	 *             when null player argument is passed in
	 */
	public void updateplayers(Player player) throws NullPointerException {
		if (player == null)
			throw new NullPointerException("can not insert null player");

		allPlayers.add(player);

	}
}
