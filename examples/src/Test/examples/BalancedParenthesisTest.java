package Test.examples;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import examples.BalancedParenthesis;

public class BalancedParenthesisTest {

	@Test
	public void testBalancedParenthesis() {

		assertTrue(BalancedParenthesis.isBalanced("()()[]{}"));
		assertTrue(BalancedParenthesis.isBalanced("{[(a+b)-c]/d}"));
		assertFalse(BalancedParenthesis.isBalanced("[(])"));

	}

}
