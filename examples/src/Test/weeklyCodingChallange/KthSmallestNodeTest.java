package Test.weeklyCodingChallange;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import utils.BinaryTree;
import weeklyCodingChallange.KthSmallestNode;

public class KthSmallestNodeTest {

	@Test
	public void KthSmallestNode() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.add(16);
		tree.add(20);
		tree.add(14);
		tree.add(15);
		tree.add(4);
		tree.add(18);
		tree.add(24);
		KthSmallestNode node = new KthSmallestNode();
		assertTrue(tree.size() == 7);
		assertEquals(4, node.kthSmallestnode(tree, 1));
		assertEquals(24, node.kthSmallestnode(tree, 7));
		assertEquals(15, node.kthSmallestnode(tree, 3));

	}

}
