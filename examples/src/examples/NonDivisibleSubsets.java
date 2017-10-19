package examples;

import java.util.Scanner;

public class NonDivisibleSubsets {

	public static void main(String[] args) {
		System.out.println("enter the size of the Set and the integer seperated by space");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int maxCombinations = maxPossiblecCombinations(n - 1);
		System.out.println(maxCombinations);
		System.out.println("enter the values in Set seperated by space");
		int[] set = new int[n];
		for (int i = 0; i < n; i++) {
			set[i] = scan.nextInt();
		}
		int largestSet;
		if (findSubset(set, n, k, 0, maxCombinations) > n) {
			largestSet = n - (maxCombinations - findSubset(set, n, k, 0, maxCombinations));
		} else {
			largestSet = findSubset(set, n, k, 0, maxCombinations);
		}
		System.out.println(largestSet);

	}

	public static int findSubset(int[] set, int n, int k, int nthElement, int maxCombinations) {

		if (nthElement < n) {

			maxCombinations = isNonDivisible(set, k, nthElement, ++nthElement, maxCombinations);

			return findSubset(set, n, k, nthElement++, maxCombinations);
		}
		return maxCombinations;

	}

	public static int isNonDivisible(int[] set, int k, int nthElement, int nextElement, int maxCombinations) {
		//
		if (nextElement < set.length) {
			if ((set[nthElement] + set[nextElement]) % k == 0) {
				maxCombinations--;
			}

			return isNonDivisible(set, k, nthElement, ++nextElement, maxCombinations);

		}
		return maxCombinations;

	}

	public static int maxPossiblecCombinations(int n) {

		if (n > 0) {
			n = n + maxPossiblecCombinations(n - 1);
		}
		return n;

	}
}
