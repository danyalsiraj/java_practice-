package Test.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import collections.TwoFourTree;

public class TwoFourTreeTest {

	@Test
	public void testInsertion() {
		TwoFourTree<Integer> tree = new TwoFourTree<Integer>();
		tree.add(5);
		assertEquals(1, tree.size());
		assertTrue(tree.contains(5));
		tree.add(11);
		assertEquals(2, tree.size());
		assertTrue(tree.contains(11));
		tree.add(3);
		assertEquals(3, tree.size());
		assertTrue(tree.contains(3));
		tree.add(8);
		assertEquals(4, tree.size());
		assertTrue(tree.contains(8));
		assertTrue(tree.contains(3));
		tree.add(16);
		tree.add(24);
		assertEquals(6, tree.size());
		assertTrue(tree.contains(24));

	}

}
