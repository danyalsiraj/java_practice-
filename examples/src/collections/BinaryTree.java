package collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> implements IBinaryTree<T> {

	public class Node {

		Node left;
		Node right;
		Node parent;
		T value;

		public Node(T value) {
			this.value = value;
		}

		public String toString() {
			return String.format("V: %s", value);
		}
	}

	Node root;

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return root == null;
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

	public int height() {
		return heightOfTree(root);
	}

	protected int heightOfTree(Node root) {
		if (root == null)
			return 0;

		int leftDepth = heightOfTree(root.left);

		int rightDepth = heightOfTree(root.right);

		int maxOf2 = Math.max(leftDepth, rightDepth);

		maxOf2 += 1;

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

	public class InOrderIterator implements Iterator<T> {

		Stack<Node> inOrderStack = new Stack<Node>();

		public InOrderIterator() {
			Node currentNode = root;
			while (currentNode != null) {
				inOrderStack.push(currentNode);
				currentNode = currentNode.left;
			}

		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return !inOrderStack.isEmpty();
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			Node nextNode = inOrderStack.pop();
			Node returnNode = nextNode.right;
			while (returnNode != null) {
				inOrderStack.push(returnNode);
				returnNode = returnNode.left;
			}
			return nextNode.value;
		}

	}

	public class PreOrderIterator implements Iterator<T> {

		Stack<Node> preOrderQueue = new Stack<Node>();

		public PreOrderIterator() {
			Node currentNode = root;
			if (currentNode != null)
				preOrderQueue.push(currentNode);
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return !preOrderQueue.isEmpty();
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			Node nextNode = preOrderQueue.pop();
			if (nextNode.right != null) {
				preOrderQueue.push(nextNode.right);
			}
			if (nextNode.left != null) {
				preOrderQueue.push(nextNode.left);
			}
			return nextNode.value;
		}

	}

	public class PostOrderIterator implements Iterator<T> {

		Stack<Node> postOrderStack = new Stack<Node>();
		T lastValPoped = null;

		public PostOrderIterator() {
			Node currentNode = root;
			while (currentNode != null) {
				postOrderStack.push(currentNode);
				currentNode = currentNode.left;
			}

		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return !postOrderStack.isEmpty();
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			Node nextNode = postOrderStack.peek();
			T result = null;
			if (lastValPoped == null || nextNode.value.compareTo(lastValPoped) == -1 || nextNode.right == null) {
				nextNode = postOrderStack.pop();
				result = nextNode.value;
			} else {
				// add all left elements of right subtree of current element,
				// same as inOrder
				nextNode = nextNode.right;
				while (nextNode != null && nextNode.left != null) {
					postOrderStack.push(nextNode);

					nextNode = nextNode.left;
				}
				result = nextNode.value;
			}

			lastValPoped = result;
			return lastValPoped;
		}

	}

	public class LevelOrderIterator implements Iterator<T> {

		Queue<Node> levelOrderStack = new LinkedList<Node>();

		public LevelOrderIterator() {
			if (root != null) {
				Node currentNode = root;
				levelOrderStack.add(currentNode);
			}

		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return !levelOrderStack.isEmpty();
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			Node nextNode = levelOrderStack.remove();

			if (nextNode.left != null) {
				levelOrderStack.add(nextNode.left);
			}
			if (nextNode.right != null) {
				levelOrderStack.add(nextNode.right);
			}
			return nextNode.value;
		}

	}

	@Override
	public Iterator<T> iteratorInOrder() {
		// TODO Auto-generated method stub
		return new InOrderIterator();

	}

	@Override
	public Iterator<T> iteratorPreOrder() {
		// TODO Auto-generated method stub
		return new PreOrderIterator();
	}

	@Override
	public Iterator<T> iteratorPostOrder() {
		// TODO Auto-generated method stub
		return new PostOrderIterator();
	}

	@Override
	public Iterator<T> iteratorLevelOrder() {
		// TODO Auto-generated method stub
		return new LevelOrderIterator();
	}

	@Override
	public boolean remove(T value) {

		return removeNode(value) != null;

	}

	public Node removeNode(T element) {
		if (element == null || root == null) {
			return null;
		}
		if (root.value.compareTo(element) == 0) {

			root = removeTopMost(root);
			if (root != null) {
				root.parent = null;
			}

			return root;

		}
		return remove(element, root);

	}

	public Node remove(T element, Node root) {
		// TODO Auto-generated method stub
		if (root == null) {
			return root;
		}
		switch (root.value.compareTo(element)) {
			case -1:
				if (root.right != null && root.right.value.compareTo(element) == 0) {
					Node removedNode = root.right;
					root.right = removeTopMost(root.right);
					if (root.right != null) {
						root.right.parent = root;
					}
					return removedNode;
				}
				root = root.right;
				return remove(element, root);
			case 1:
				if (root.left != null && root.left.value.compareTo(element) == 0) {
					Node removedNode = root.left;
					root.left = removeTopMost(root.left);
					if (root.left != null) {
						root.left.parent = root;
					}
					return removedNode;
				}
				root = root.left;
				return remove(element, root);

		}

		return root;
	}

	private Node removeTopMost(Node root) {
		if (root.right == null) {
			root = root.left;
		} else if (root.left == null) {
			root = root.right;
		} else {
			// case when root has left AND right
			// replace with right most value of left subtree

			if (root.left.right == null) {
				root.left.right = root.right;
				root = root.left;
				root.right.parent = root;
			} else {
				Node tempNode = new Node(root.value);
				tempNode.right = root.right;
				tempNode.left = root.left;
				tempNode.parent = root.parent;
				tempNode.value = removeRightMostNode(tempNode.left);
				root = tempNode;
				tempNode.left.parent = root;
				tempNode.right.parent = root;
			}

		}
		return root;
	}

	private T removeRightMostNode(Node root) {

		if (root.right.right == null) {
			T value = root.right.value;
			root.right = root.right.left;
			if (root.right != null) {
				root.right.parent = root;
			}

			return value;
		}

		return removeRightMostNode(root.right);
	}

	@Override
	public boolean add(T value) {

		return addNode(value) != null;

	}

	protected Node addNode(T value) {
		if (value == null)
			return null;
		if (this.root == null) {
			this.root = new Node(value);
			return root;
		} else {
			return add(root, value);
		}
	}

	protected Node add(Node root, T value) {
		// TODO Auto-generated method stub

		switch (value.compareTo(root.value)) {
			case 1:
				if (root.right == null) {
					root.right = new Node(value);
					root.right.parent = root;
					return root.right;
				}
				root = root.right;
				break;
			case -1:
			default:// add to left if the value already exists
				if (root.left == null) {
					root.left = new Node(value);
					root.left.parent = root;
					return root.left;
				}
				root = root.left;
				break;
		}

		return add(root, value);

	}

}
