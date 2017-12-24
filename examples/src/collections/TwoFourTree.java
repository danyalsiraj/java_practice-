package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class TwoFourTree<T extends Comparable<T>> implements IBinaryTree<T> {

	static int MAX_KEYS = 3;
	int size;
	Node root;

	public class Node {

		Node parent;
		ArrayList<T> values = new ArrayList<T>();
		ArrayList<Node> childern = new ArrayList<Node>();

		public Node() {

		}

		public Node(T value) {
			values.add(value);

		}

		public void addValue(T value) {
			values.add(value);
			Collections.sort(values);
		}

		public void addChildern(Node child) {
			childern.add(child);
			child.parent = this;
			Collections.sort(childern, new Comparator<Node>() {

				@Override
				public int compare(TwoFourTree<T>.Node o1, TwoFourTree<T>.Node o2) {
					// TODO Auto-generated method stub
					T v1 = o1.values.get(0);
					T v2 = o2.values.get(0);

					return v1.compareTo(v2);
				}

			});
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T value) {
		// TODO Auto-generated method stub
		if (value == null) {
			return false;
		}
		return contains(root, value);
	}

	public boolean contains(Node root, T value) {
		if (value == null || root == null) {
			return false;
		}
		if (root.values.contains(value)) {
			return true;
		}
		if (root.childern.isEmpty()) {
			return false;
		}

		for (int i = 0; i < root.values.size(); i++) {

			if (value.compareTo(root.values.get(i)) < 0) {
				if (root.childern.size() <= i) {
					return false;
				}
				Node tempNode = root.childern.get(i);
				if (tempNode != null && tempNode.values.get(0).compareTo(root.values.get(i)) < 0) {
					return contains(tempNode, value);
				} else {
					return false;
				}
			} else if (i + 1 == root.values.size()) {
				if (root.childern.size() <= i + 1) {
					return false;
				}
				Node tempNode = root.childern.get(i + 1);

				if (tempNode != null && tempNode.values.get(0).compareTo(root.values.get(i)) > 0) {
					return contains(tempNode, value);
				} else {
					return false;
				}
			}

		}
		return false;

	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		if (size == 0 && value != null) {
			root = new Node(value);
			size++;
			return true;
		}
		Node toAdd = findNode(root, value);
		toAdd.addValue(value);
		size++;
		if (toAdd.values.size() > MAX_KEYS) {
			split(toAdd);
		}
		return true;
	}

	private Node findNode(Node root, T value) {
		// TODO Auto-generated method stub
		for (int i = 0; i < root.values.size(); i++) {
			T currentNode = root.values.get(i);
			if (value.compareTo(currentNode) < 0) {
				if (root.childern.size() <= i) {
					return root;
				}
				Node tempNode = root.childern.get(i);
				if (tempNode != null && tempNode.values.get(0).compareTo(currentNode) < 0) {
					return findNode(tempNode, value);
				} else {
					return root;
				}
			} else if (i + 1 == root.values.size()) {
				if (root.childern.size() <= i + 1) {
					return root;
				}
				Node tempNode = root.childern.get(i + 1);

				if (tempNode != null && tempNode.values.get(0).compareTo(currentNode) > 0) {
					return findNode(tempNode, value);
				} else {
					return root;
				}
			}

		}
		return root;
	}

	private void split(Node root) {
		if (root == null || root.values.size() <= MAX_KEYS) {
			return;
		}
		if (root.parent == null) {
			root.parent = new Node();
			this.root = root.parent;
		}
		root.parent.addValue(root.values.get(2));
		Node left = new Node();
		Node right = new Node();

		left.addValue(root.values.get(0));
		left.addValue(root.values.get(1));
		right.addValue(root.values.get(3));
		for (int i = 0; i < root.childern.size(); i++) {
			if (i < 3) {
				left.childern.add(root.childern.get(i));

			} else {
				right.childern.add(root.childern.get(i));
			}
		}

		root = root.parent;
		root.childern.add(left);
		root.childern.add(right);

		split(root);

	}

}
