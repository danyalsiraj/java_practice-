package collections;

import java.util.Iterator;

public interface IBinaryTree<T extends Comparable<T>> {

	public boolean isEmpty();
	public int size();
	public int depth();
	public boolean contains(T value);
	public void removeAll();
	public Iterator<T> iteratorInOrder();
	public Iterator<T> iteratorPreOrder();
	public Iterator<T> iteratorPostOrder();
	public Iterator<T> iteratorLevelOrder();
	public boolean remove(T element);
	public boolean add(T value);
	
	
	
}
