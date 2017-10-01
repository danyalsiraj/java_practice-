package person;

import utils.Array;

public class TestPerson {

	public static void main(String[] args) {
		Person[] array = new Person[5];
		array[0] = new Person("dany", "s", 14);
		array[1] = new Person("dany1", "s1", 7);
		array[2] = new Person("dany2", "s2", 25);
		array[3] = new Person("dany3", "s3", 12);
		array[4] = new Person("dany4", "s4", 45);

		System.out.println(Array.toString(array));
		Array.sort(array);
		System.out.println(Array.toString(array));

	}

}
