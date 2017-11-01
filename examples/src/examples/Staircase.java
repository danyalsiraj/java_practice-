package examples;

import java.util.Scanner;

public class Staircase {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		staricase(scan.nextInt(), 1);

	}

	public static void staricase(int n, int i) {

		if (i > n) {
			return;
		}
		System.out.println(addSpace(n - i, steps(i, "")));
		staricase(n, ++i);

	}

	public static String steps(int step, String str) {

		if (step == 0) {
			return str;
		}

		return steps(--step, str + "#");

	}

	public static String addSpace(int totalSpaces, String str) {

		if (totalSpaces == 0) {
			return str;
		}
		return addSpace(--totalSpaces, " " + str);

	}

}
