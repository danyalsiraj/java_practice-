package utils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> implements IBinaryTree<T> {

	public class Node {

		Node left;
		Node right;
		T value;

		public Node(T value) {
			this.value = value;
		}

	}

	Node root;

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return root != null;
	}

	@Override
	public int size() {
		return size(root);
	}

	private int size(Node root) {
		// TODO Auto-generated method stub
		if (root == null) {
			return 0;
		}

		/*
		 * add 1 because we always want to count the current node (root) if its
		 * not empty
		 */
		return size(root.left) + size(root.right) + 1;
	}

	public int depth() {
		return depthOfTree(root);
	}

	private int depthOfTree(Node root) {
		if (root == null)
			return 0;

		int leftDepth = depthOfTree(root.left);

		int rightDepth = depthOfTree(root.right);

		int maxOf2 = Math.max(leftDepth, rightDepth);

		if (root.left != null || root.right != null) {
			maxOf2 += 1;
		}
		return maxOf2;

	}

	@Override
	public boolean contains(T value) {
		if (value == null)
			return false;
		return contains(root, value);
	}

	private boolean contains(Node root, T value) {
		// TODO Auto-generated method stub
		if (root == null)
			return false;

		switch (value.compareTo(root.value)) {
			case 1:
				root = root.right;
				break;
			case -1:
				root = root.left;
				break;
			default:
				return true;
		}
		return contains(root, value);

	}

	public Queue<T> printInOrder() {
		Queue<T> result = new LinkedList<T>();
		printInOrder(root, result);
		return result;

	}

	private void printInOrder(Node root, Queue<T> printQueue) {
		if (root == null) {
			return;
		}

		// print left
		printInOrder(root.left, printQueue);
		// print current
		// System.out.println(root.value);
		printQueue.add(root.value);
		// print right side
		printInOrder(root.right, printQueue);

	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub

	}

	public class InOrderIterator<T> implements Iterator<T> {

		public InOrderIterator() {

		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	@Override
	public Iterator<T> iteratorInOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorPreOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorPostOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorLevelOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(T value) {
		if (value == null)
			return false;
		if (this.root == null) {
			this.root = new Node(value);
			return true;
		}
		return add(root, value);
	}

	private boolean add(Node root, T value) {
		// TODO Auto-generated method stub

		switch (value.compareTo(root.value)) {
			case 1:
				if (root.right == null) {
					root.right = new Node(value);
					return true;
				}
				root = root.right;
				break;
			case -1:
			default:// add to left if the value already exists
				if (root.left == null) {
					root.left = new Node(value);
					return true;
				}
				root = root.left;
				break;
		}

		return add(root, value);

	}

}
