package examples;

import java.util.Scanner;

public class DiagonalDifference {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] array = new int[n][n];
		array = fillArray(0, 0, n, array, scan);
		System.out.println(Math.abs(getPrimary(n, 0, array, 0) - getSecondary(0, n - 1, n, array, 0)));
	}

	public static int[][] fillArray(int i, int j, int n, int[][] array, Scanner scan) {

		while (j < n && i < n) {
			array[i][j] = scan.nextInt();
			j++;
		}

		if (i >= n) {
			return array;
		}
		return fillArray(++i, 0, n, array, scan);

	}

	public static int getPrimary(int n, int i, int[][] array, int primary) {

		while (i < n) {
			primary += array[i][i];
			i++;
		}
		if (i >= n) {
			return primary;
		}
		return getPrimary(n, i, array, primary);

	}

	public static int getSecondary(int i, int j, int n, int[][] array, int secondary) {

		if (j >= 0) {
			secondary += array[i][j];
			j--;
		}
		if (i >= n) {
			return secondary;
		}
		return getSecondary(++i, n - 1 - i, n, array, secondary);

	}

}
