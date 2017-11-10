package Test.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import collections.BalancedBinaryTree;

public class BalancedBinaryTreeTest extends BinaryTreeTest {

	@Test
	public void checkIsBalanced() {
		BalancedBinaryTree<Integer> tree = new BalancedBinaryTree<Integer>();
		for (int i = 1; i < 30; i++) {
			assertTrue(tree.add(i));
			assertTrue("Not balanced after inserting: " + i, tree.isBalanced());
			assertEquals(i, tree.size());
		}
	}

	@Test
	public void checkIsBalancedAfterRemove() {
		BalancedBinaryTree<Integer> tree = new BalancedBinaryTree<Integer>();
		for (int i = 1; i < 30; i++) {
			assertTrue(tree.add(i));
			assertTrue("Not balanced after inserting: " + i, tree.isBalanced());
			assertEquals(i, tree.size());
		}
		assertTrue(tree.remove(2));

		assertTrue("Not balanced after removing: 15", tree.isBalanced());
		assertEquals(28, tree.size());

		assertTrue(tree.remove(7));
		assertTrue("Not balanced after removing: 15", tree.isBalanced());
		assertEquals(27, tree.size());

		assertTrue(tree.remove(5));
		assertTrue("Not balanced after removing: 15", tree.isBalanced());
		assertEquals(26, tree.size());

		assertTrue(tree.remove(8));
		assertTrue("Not balanced after removing: 15", tree.isBalanced());
		assertEquals(25, tree.size());

	}

}
