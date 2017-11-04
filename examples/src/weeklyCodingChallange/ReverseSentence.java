package weeklyCodingChallange;

import java.util.Scanner;
import java.util.Stack;

public class ReverseSentence {

	public static String reverse(String sentence) {
		if (sentence == null || sentence.length() < 2) {
			return sentence;
		}
		Scanner scan = new Scanner(sentence);
		Stack<String> reverseStack = new Stack<String>();
		StringBuffer reverseSent = new StringBuffer(sentence.length());
		while (scan.hasNext()) {
			reverseStack.push(scan.next());
		}
		while (!reverseStack.isEmpty()) {
			reverseSent.append(reverseStack.pop());
			if (!reverseStack.isEmpty()) {
				reverseSent.append(" ");
			}
		}
		return reverseSent.toString();

	}

}
