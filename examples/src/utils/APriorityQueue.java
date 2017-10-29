package utils;

import java.util.Collection;
import java.util.Iterator;

public class APriorityQueue<T extends Comparable<T>> implements IPriorityQueue<T> {
	int size = 0;
	int maxIndex = 0;
	T[] queueArray;

	public APriorityQueue() {
		queueArray = createArray(10);
	}

	public boolean isEmpty() {
		return size != 0;

	}

	private T[] createArray(int size) {
		return (T[]) java.lang.reflect.Array.newInstance(Comparable.class, size);
	}

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		if (e == null) {
			return false;
		}
		if (size >= queueArray.length) {
			queueArray = (T[]) Array.extend(queueArray, createArray(size * 2));
		}

		queueArray[size] = e;
		if (queueArray[size].compareTo(queueArray[maxIndex]) > 0) {
			maxIndex = size;
		}
		size++;

		return true;
	}

	@Override
	public boolean offer(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		T maxValue = Array.remove(maxIndex, queueArray);
		size--;
		findNextMax();
		return maxValue;
	}

	private void findNextMax() {
		// TODO Auto-generated method stub
		maxIndex = 0;
		for (int i = 0; i < size; i++) {
			if (queueArray[maxIndex].compareTo(queueArray[i]) == -1) {
				maxIndex = i;
			}
		}

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
		return queueArray[maxIndex];

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
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
