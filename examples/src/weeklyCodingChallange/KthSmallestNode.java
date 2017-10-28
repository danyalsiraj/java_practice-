package weeklyCodingChallange;

import java.util.Iterator;

import utils.BinaryTree;

public class KthSmallestNode {

	public static int kthSmallestnode(BinaryTree<Integer> tree, int k) {
		int value = 0;
		if (tree.isEmpty()) {
			throw new NullPointerException();
		}
		if (k > tree.size()) {
			throw new IndexOutOfBoundsException();
		}
		Iterator<Integer> i = tree.iteratorInOrder();
		for (int j = 0; j < k; j++) {
			value = i.next();
		}

		return value;
	}
}
