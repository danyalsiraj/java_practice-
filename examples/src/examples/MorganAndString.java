package examples;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MorganAndString {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int numOfTetsCases = Integer.parseInt(scan.nextLine());

		Queue<String> str = new LinkedList<String>();
		for (int i = 1; i <= numOfTetsCases * 2; i++) {
			str.add(scan.nextLine());
		}

		for (int i = 1; i <= numOfTetsCases; i++) {
			// Stack<Character> A = toStack(str.remove());
			// Stack<Character> B = toStack(str.remove());
			// System.out.println(minString(A, B));
			System.out.println(getLexMin(str.remove().toCharArray(), str.remove().toCharArray(), 0, 0, ""));
		}

	}

	public static Stack<Character> toStack(String str) {
		Stack<Character> charStack = new Stack<Character>();
		for (int i = str.length() - 1; i >= 0; i--) {
			charStack.push(str.charAt(i));
		}
		return charStack;

	}

	public static String minString(Stack<Character> stackA, Stack<Character> stackB) {

		StringBuilder minStr = new StringBuilder(stackA.size() + stackB.size());

		while (!stackA.isEmpty() && !stackB.isEmpty()) {
			Character A = stackA.peek();
			Character B = stackB.peek();
			String currentString = minStr.toString();

			if ((currentString + A).compareTo((currentString + B)) < 0) {
				minStr.append(stackA.pop());

			} else {
				minStr.append(stackB.pop());

			}
		}
		if (!stackB.isEmpty()) {
			while (!stackB.isEmpty()) {
				minStr.append(stackB.pop());
			}
		}
		if (!stackA.isEmpty()) {
			while (!stackA.isEmpty()) {
				minStr.append(stackA.pop());
			}
		}

		return minStr.toString();

	}

	public static String getLexMin(char[] a, char[] b, int aI, int bI, String current) {
		if (aI >= a.length && bI >= b.length) {
			// reached End
			return current;
		} else if (aI >= a.length) {
			// add all bs
			while (bI < b.length) {
				current += b[bI++];
			}
			return current;
		} else if (bI >= b.length) {
			// add all as
			while (aI < a.length) {
				current += a[aI++];
			}
			return current;
		}

		char aChar = a[aI];
		char bChar = b[bI];
		if (aChar == bChar) {

			String chooseA = getLexMin(a, b, aI + 1, bI, current + aChar);
			String chooseB = getLexMin(a, b, aI, bI + 1, current + bChar);

			if (chooseA.compareTo(chooseB) < 0) {
				return chooseA;
			} else {
				return chooseB;
			}

		}

		if (aChar < bChar) {
			current += aChar;
			aI++;

		} else {
			bI++;
			current += bChar;
		}

		return getLexMin(a, b, aI, bI, current);
	}
}
