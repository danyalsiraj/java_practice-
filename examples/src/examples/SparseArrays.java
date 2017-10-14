package examples;

import java.util.Scanner;

public class SparseArrays {

	public static void main(String[] args) {
		System.out.println("enter number of strings");
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		String[] strings = new String[N];

		for (int i = 0; i < N; i++) {
			strings[i] = scan.next();
		}

		System.out.println("enter number of queries");
		int Q = scan.nextInt();

		String[] queries = new String[Q];
		for (int i = 0; i < Q; i++) {
			queries[i] = scan.next();
		}
		sparseArrays(strings, queries);

	}

	public static void sparseArrays(String[] strings, String[] queries) {
		int[] occurance = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			for (int j = 0; j < strings.length; j++) {
				if (strings[j].equals(queries[i])) {
					occurance[i]++;
				}

			}
			System.out.println(occurance[i]);

		}

	}

}
