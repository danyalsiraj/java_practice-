package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class TwoFourTree<T extends Comparable<T>> implements IBinaryTree<T> {

	static int MAX_KEYS = 3;
	int size;
	Node root;

	public class Pair {
		Node node;
		int index;

		public Pair(Node node, int index) {
			super();
			this.node = node;
			this.index = index;
		}

	}

	public class Node implements Comparable<Node> {

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

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.values.get(0).compareTo(o.values.get(0));
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
		return contains(root, value) != null;
	}

	public Node contains(Node root, T value) {
		if (value == null || root == null) {
			return null;
		}
		if (root.values.contains(value)) {
			return root;
		}
		if (root.childern.isEmpty()) {
			return null;
		}

		for (int i = 0; i < root.values.size(); i++) {

			if (value.compareTo(root.values.get(i)) < 0) {
				if (root.childern.size() <= i) {
					return null;
				}
				Node tempNode = root.childern.get(i);
				if (tempNode != null && tempNode.compareTo(root) < 0) {
					return contains(tempNode, value);
				} else {
					return null;
				}
			} else if (i + 1 == root.values.size()) {
				if (root.childern.size() <= i + 1) {
					return null;
				}
				Node tempNode = root.childern.get(i + 1);

				if (tempNode != null && tempNode.compareTo(root) > 0) {
					return contains(tempNode, value);
				} else {
					return null;
				}
			}

		}
		return null;

	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		root = null;
		size = 0;

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
		Node node = contains(root, element);
		if (node == null) {
			return false;
		}
		remove(node, element);
		size--;
		return true;
	}

	private Pair nextInOrder(Node node, T value) {
		int index = node.values.indexOf(value);
		for (int i = 0; i < node.childern.size(); i++) {
			if (node.childern.get(i).values.get(0).compareTo(value) > 0
					&& (node.values.size() == index + 1 || node.values.get(index + 1).compareTo(value) < 0)) {

				Node firstRightNode = node.childern.get(i);

				return new Pair(leftMostNode(firstRightNode), 0);
			}

		}
		if (node.values.size() > index + 1) {

			return new Pair(node, index + 1);
		}

		return null;
	}

	private Node leftMostNode(Node node) {
		// TODO Auto-generated method stub
		if (node.childern.isEmpty() || node.values.get(0).compareTo(node.childern.get(0).values.get(0)) < 0) {
			return node;
		}
		return leftMostNode(node.childern.get(0));
	}

	private boolean isUnderFlowed(Node node) {
		if ((node.values.size() - node.childern.size() < -1) || node.values.size() == 0) {

			return true;
		}
		return false;
	}

	private void remove(Node node, T element) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		Pair nextInOrderPair = nextInOrder(node, element);
		T nextVal;
		Node underFlowedNode = null;
		if (nextInOrderPair != null) {
			Node nextNode = nextInOrderPair.node;
			int index = nextInOrderPair.index;
			nextVal = nextNode.values.get(index);
			node.values.remove(element);
			if (node != nextNode) {
				node.addValue(nextVal);
				nextNode.values.remove(nextVal);
			}
			underFlowedNode = nextNode;
		} else {
			// figure it out
			node.values.remove(element);
			underFlowedNode = node;
		}

		handleUnderFlow(underFlowedNode);

	}

	private void handleUnderFlow(Node underFlowedNode) {
		if (underFlowedNode == null) {
			return;

		}
		if (underFlowedNode == root) {
			if (underFlowedNode.childern.size() > 0) {
				root = underFlowedNode.childern.get(0);
			} else if (isUnderFlowed(underFlowedNode)) {
				root = null;
			}
			return;
		}
		// TODO Auto-generated method stub
		if (isUnderFlowed(underFlowedNode)) {
			Node AdjNode = getAdjNode(underFlowedNode);
			// handle null sce
			Node parent = underFlowedNode.parent;
			if (AdjNode.values.size() == 1) {
				// 2 node
				underFlowedNode.values.addAll(AdjNode.values);
				underFlowedNode.addValue(parent.values.remove(parent.values.size() - 1));
				for (Node child : AdjNode.childern) {
					underFlowedNode.addChildern(child);
				}
				parent.childern.remove(AdjNode);
				handleUnderFlow(parent);

			} else {
				// 3,4 node
				underFlowedNode.addChildern(AdjNode.childern.remove(AdjNode.childern.size() - 1));
				underFlowedNode.addValue(parent.values.remove(parent.values.size() - 1));
				parent.addValue(AdjNode.values.remove(AdjNode.values.size() - 1));

			}
		}
	}

	private Node getAdjNode(Node node) {
		// TODO Auto-generated method stub
		Node parent = node.parent;
		if (parent == null) {
			return null;
		}
		int index = parent.childern.indexOf(node);

		if (index - 1 >= 0 && parent.childern.get(index - 1) != null) {
			return parent.childern.get(index - 1);
		} else if (index + 1 < parent.childern.size() && parent.childern.get(index + 1) != null) {
			return parent.childern.get(index + 1);
		}
		return null;
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
		root.addChildern(left);
		root.addChildern(right);

		split(root);

	}

}
