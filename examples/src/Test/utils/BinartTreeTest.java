package Test.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Queue;

import org.junit.Test;

import utils.BinaryTree;

public class BinartTreeTest {

	@Test
	public void printInOrderTest() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.add(8);
		tree.add(5);
		tree.add(15);
		tree.add(2);
		tree.add(7);
		tree.add(12);
		tree.add(29);

		int[] order = { 2, 5, 7, 8, 12, 15, 29 };
		checkOrder(order, tree);

	}

	@Test
	public void removeTest() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.add(8);
		tree.add(5);
		tree.add(15);
		tree.add(2);
		tree.add(7);
		tree.add(12);
		tree.add(29);
		assertTrue(tree.contains(15));
		assertTrue(tree.remove(15));
		assertTrue(tree.remove(2));

		int[] order = { 5, 7, 8, 12, 29 };
		checkOrder(order, tree);
		assertTrue(tree.remove(8));
		order = new int[] { 5, 7, 12, 29 };
		checkOrder(order, tree);
		assertFalse(tree.remove(25));

	}

	public void checkOrder(int[] order, BinaryTree<Integer> tree) {

		Queue<Integer> orderedQueue = tree.printInOrder();

		assertNotNull(orderedQueue);

		for (int i : order) {
			assertEquals((Integer) i, orderedQueue.remove());
		}

	}

}
