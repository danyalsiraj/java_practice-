package examples;

import java.util.Stack;

public class BalancedParenthesis {

	public static boolean isBalanced(String expression) {

		if (expression == null) {
			return false;
		}
		Stack<Character> openP = new Stack<Character>();
		for (char c : expression.toCharArray()) {
			switch (c) {
				case '(':
				case '{':
				case '[':
					openP.push(c);
					break;
				case ')':
					if (openP.pop() != '(') {
						return false;
					}
					break;
				case '}':
					if (openP.pop() != '{') {
						return false;
					}
					break;
				case ']':
					if (openP.pop() != '[') {
						return false;
					}
					break;

			}

		}

		return true;

	}

}
