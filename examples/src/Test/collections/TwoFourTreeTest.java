package Test.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

		tree.remove(24);
		assertFalse(tree.contains(24));
		assertEquals(5, tree.size());
		assertTrue(tree.contains(3));
		assertTrue(tree.contains(11));

		tree.remove(3);
		assertFalse(tree.contains(3));
		assertEquals(4, tree.size());

		tree.remove(11);
		assertFalse(tree.contains(11));
		assertEquals(3, tree.size());

		tree.remove(16);
		assertFalse(tree.contains(16));
		assertEquals(2, tree.size());

		tree.remove(8);
		assertFalse(tree.contains(8));
		assertEquals(1, tree.size());

		tree.remove(5);
		assertFalse(tree.contains(5));
		assertEquals(0, tree.size());

		// tree.removeAll();
		// assertEquals(0, tree.size());
		assertFalse(tree.contains(24));
		assertFalse(tree.contains(11));
		assertFalse(tree.contains(5));
		assertFalse(tree.contains(3));

	}

}
