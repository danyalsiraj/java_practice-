package examples;

import java.util.Scanner;

//hackerrank problem
public class BirthdayCakeCandles {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int ar_i = 0; ar_i < n; ar_i++) {
			ar[ar_i] = in.nextInt();
		}
		int result = birthdayCakeCandles(n, ar);
		System.out.println(result);
	}

	static int birthdayCakeCandles(int n, int[] ar) {
		// Complete this function
		int maxCandleHeight = ar[0];
		int NumOfCand = 0;
		for (int i = 0; i < n; i++) {
			if (ar[i] > maxCandleHeight) {
				maxCandleHeight = ar[i];
				NumOfCand = 0;
			}
			if (ar[i] == maxCandleHeight) {
				NumOfCand++;
			}

		}
		return NumOfCand;
	}
}
