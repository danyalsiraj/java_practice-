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
}
