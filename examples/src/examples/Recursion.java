package examples;

public class Recursion {

	public static void main(String[] args) {

		recursion(0);
	}


	public static void recursion(int i) {
		System.out.println(i);
		if (i < 10) {
			recursion(++i);
		}

	}

}
