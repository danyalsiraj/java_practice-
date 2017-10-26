package Test.examples;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import examples.Palindrome;

public class PalindromeTest {

	@Test
	public void palindrometest() {
		assertEquals(3, Palindrome.isPalindrome("aaab"));
		assertEquals(Palindrome.isPalindrome("aba"), -1);
		assertEquals(Palindrome.isPalindrome("abc"), -1);
		assertEquals(1, Palindrome.isPalindrome("quyjjdcgsvvsgcdjjyq"));
		assertEquals(0, Palindrome.isPalindrome("wcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwc"));

	}

}
