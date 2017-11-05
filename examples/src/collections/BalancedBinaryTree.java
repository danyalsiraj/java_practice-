package collections;

import java.util.Arrays;
import java.util.Comparator;

public class BalancedBinaryTree<T extends Comparable<T>> extends BinaryTree<T> {

	@Override
	public boolean add(T value) {
		Node addedNode = addNode(value);
		if (addedNode == null) {
			return false;
		}
		balance(addedNode, value);
		return true;

	}

	public boolean isBalanced() {
		int leftH = heightOfTree(root.left);
		int rightH = heightOfTree(root.right);
		return Math.abs(rightH - leftH) <= 1;
	}

	private void balance(Node node, T value) {
		if (node.parent == null) {
			return;
		}
		int leftH = heightOfTree(node.parent.left);
		int rightH = heightOfTree(node.parent.right);
		if (Math.abs(rightH - leftH) > 1) {
			// current node is Y, we just figured out that the parent of Y is
			// unbalanced
			Node x = null;
			if (node.value.compareTo(value) < 0) {
				x = node.right;
			} else {
				x = node.left;
			}
			rotate(node.parent, node, x);
			return;
		}
		balance(node.parent, value);
	}

	private void rotate(Node z, Node y, Node x) {
		Node t1, t2, t3, t4;
		Node a, b, c;

		Node[] nodes = (Node[]) java.lang.reflect.Array.newInstance(Node.class, 3);

		nodes[0] = x;
		nodes[1] = y;
		nodes[2] = z;
		Arrays.sort(nodes, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.value.compareTo(o2.value);
			}
		});

		a = nodes[0];
		b = nodes[1];
		c = nodes[2];

		// figured out a,b,c

		// figure out subtrees

		if (a.right == b) {
			t2 = b.left;
		} else {
			t2 = a.right;
		}

		if (b.right == c) {
			t3 = c.left;
		} else {
			t3 = b.right;
		}

		b.right = c;
		b.left = a;

		a.right = t2;
		if (t2 != null) {
			t2.parent = a;
		}

		c.left = t3;
		if (t3 != null) {
			t3.parent = c;
		}

		if (z.parent == null) {
			root = b;
		} else {
			if (z.parent.left == z) {
				// z was on left side
				z.parent.left = b;
			} else {
				// z is on right side
				z.parent.right = b;
			}
		}
		b.parent = z.parent;
		a.parent = b;
		c.parent = b;

	}

}
