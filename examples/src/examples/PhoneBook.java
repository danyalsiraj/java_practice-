package examples;

import java.util.HashMap;

public class PhoneBook {
	HashMap<String, Integer> hmap;

	public PhoneBook() {
		hmap = new HashMap<String, Integer>();
	}

	public void add(String name, int phone) {

		hmap.put(name, phone);
	}

	public String search(String name) {
		if (hmap.containsKey(name)) {
			return String.format("%s=%s", name, hmap.get(name));
		} else {
			return ("Not found");
		}

	}
}