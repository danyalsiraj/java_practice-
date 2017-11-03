package collections;

import java.util.Collection;
import java.util.Iterator;

public class MinHeap<T extends Comparable<T>> implements IPriorityQueue<T> {

	int size;
	T[] tempArray;

	public MinHeap() {
		tempArray = createArray(10);
	}

	private T[] createArray(int size) {
		return (T[]) java.lang.reflect.Array.newInstance(Comparable.class, size);
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

	public Iterator<T> iteratorInOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterator<T> iteratorPreOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterator<T> iteratorPostOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterator<T> iteratorLevelOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(T value) {
		// TODO Auto-generated method stub
		if (size() >= 10) {
			extendArray();
		}
		tempArray[size] = value;
		upHeap(size);
		size++;
		return true;
	}

	public void extendArray() {
		T[] extendArray = createArray(size() * 2);
		for (int i = 0; i < size(); i++) {
			extendArray[i] = tempArray[i];
		}
		tempArray = extendArray;
	}

	public void upHeap(int i) {
		if (i == 0) {
			return;
		}
		int parentIndex = getParentIndex(i);
		if (tempArray[i].compareTo(tempArray[parentIndex]) < 0) {
			swap(i, parentIndex);
			upHeap(parentIndex);
		}

	}

	private void swap(int i, int parentIndex) {
		// TODO Auto-generated method stub
		T value = tempArray[i];
		tempArray[i] = tempArray[parentIndex];
		tempArray[parentIndex] = value;

	}

	public int getParentIndex(int i) {
		return (i - 1) / 2;
	}

	@Override
	public boolean offer(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		T value = tempArray[0];
		tempArray[0] = tempArray[size() - 1];
		tempArray[size() - 1] = null;
		size--;
		if (size > 1) {
			downHeap(0);
		}
		return value;
	}

	private void downHeap(int i) {

		int lIndex = getLeftChildIndex(i);
		int rIndex = getRightChildIndex(i);
		// in the case i doesn't have any childrent lIndex and rIndex will equal
		// i
		if (smallerThan(lIndex, i) && smallerThan(lIndex, rIndex)) {
			swap(i, lIndex);
			downHeap(lIndex);
		} else if (smallerThan(rIndex, i) && smallerThan(rIndex, lIndex)) {
			swap(i, rIndex);
			downHeap(rIndex);
		}
	}

	private boolean smallerThan(int a, int b) {
		return tempArray[a].compareTo(tempArray[b]) < 0;
	}

	private int getLeftChildIndex(int i) {
		int lIndex = 2 * i + 1;
		if (lIndex < size()) {
			return lIndex;
		}
		return i;

	}

	private int getRightChildIndex(int i) {
		int rIndex = 2 * i + 2;
		if (rIndex < size()) {
			return rIndex;
		}
		return i;

	}

	@Override
	public T poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return tempArray[0];
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
