package examples;

public class Palindrome {

	public static int isPalindrome(String str) {
		int length = str.length();
		int start = 0, end = length - 1;
		// boolean first, last;
		for (int i = start; i < end; i++) {

			if (str.charAt(start) != str.charAt(end)) {
				if (isPalindromeTrue(str, start + 1, end) == true) {
					return start;

				} else if (isPalindromeTrue(str, start, end - 1) == true) {
					return end;

				} else {
					return -1;
				}

			}
			start++;
			end--;

		}
		return -1;

	}

	public static boolean isPalindromeTrue(String str, int start, int end) {

		while (start < end) {

			if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;

	}
}
