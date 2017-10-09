package Test.utils;

import java.util.Deque;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import utils.AStack;

public class AStackTest {
	Deque<String> stack;

	@Before
	public void setUp() {
		stack = new AStack<String>();
	}

	@Test
	public void addToStack() {
		assertTrue("size should be 0", stack.isEmpty());

		for (int i = 0; i < 15; i++) {
			assertEquals("size should be " + i, i, stack.size());
			stack.push("danyal" + i);
			assertFalse("size should be" + (i + 1), stack.isEmpty());
			assertEquals("size should be " + (i+1), i + 1, stack.size());

		}

	}

	public void testPeek() {
		stack.push("danyal");
		assertEquals("the top elemnet does not match", "danyal", stack.peek());
		stack.push("zaid");
		assertEquals("the top element should be zaid", "zaid", stack.peek());
	}

	public void testPop() {
		stack.push("danyal");
		stack.push("zaid");
		assertEquals("the top element should be zaid", "zaid", stack.pop());
		assertEquals("size should be 1", 1, stack.size());
		assertEquals("the top elemnet does not match", "danyal", stack.peek());
		assertEquals("the top element should be zaid", "danyal", stack.pop());
		assertEquals("size should be 0", 0, stack.size());

		for (int i = 0; i < 15; i++) {
			assertTrue("size should be " + i, stack.isEmpty());
			assertEquals("size should be " + i, i, stack.size());
			stack.push("danyal" + i);
			assertFalse("size should be" + (i+1), stack.isEmpty());
			assertEquals("size should be " + (i+1), i + 1, stack.size());

		}
		for (int i = 14; i >= 0; i--) {

			assertEquals("the top elemnet does not match", "danyal" + i, stack.peek());
			assertEquals("size should be " + (i+1), i + 1, stack.size());
			assertEquals("the top element should be zaid", "danyal" + i, stack.pop());
			assertEquals("size should be " + i, i, stack.size());

		}

	}

}
