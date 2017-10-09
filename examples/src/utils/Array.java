package utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.activation.UnsupportedDataTypeException;

import com.mysql.jdbc.integration.jboss.ExtendedMysqlExceptionSorter;

public class Array<E> implements List<E> {

	private E[] array;
	private final static int DEFAULT_SIZE = 10;
	private int currentCapacity;

	public Array() {
		array = (E[]) new Object[DEFAULT_SIZE];
	}

	public Array(int capacity) {
		array = (E[]) new Object[capacity];

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return currentCapacity;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		for (int i = 0; i < size(); i++) {
			if (array[i].equals(o))
				return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		Object[] temp = new Object[size()];
		for (int i = 0; i < size(); i++)
			temp[i] = array[i];

		return temp;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		if (a != null && size() <= a.length) {
			for (int i = 0; i < a.length; i++) {
				if (i < size()) {
					a[i] = (T) array[i];
				} else {
					a[i] = null;
				}

			}

			return a;
		}

		return (T[]) toArray();
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		if (e == null) {
			return false;

		}
		if (array.length == size()) {
			extend();
		}
		array[size()] = e;
		currentCapacity++;

		return true;
	}

	private void extend() {
		extend(size() * 2);

	}

	private void extend(int length) {
		E[] temp = (E[]) new Object[length];

		for (int i = 0; i < size(); i++) {
			temp[i] = array[i];
		}
		array = temp;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub

		int index = indexOf(o);
		if (index >= 0) {
			remove(index);
			return true;

		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		Iterator goThrough = c.iterator();
		while (goThrough.hasNext()) {
			if (!contains(goThrough.next()))
				return false;
		}
		// Object[] contains=c.toArray();
		// for (Object o :contains) {
		// if (!contains(o))
		// return false;
		// }
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		// Iterator add=c.iterator();
		boolean changed = false;
		for (E o : c) {
			if (add(o))
				changed = true;
		}
		return changed;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		shift(c.size(), index);
		for (E o : c) {
			add(index, o);
			index++;
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub

		boolean changed = false;
		for (Object o : c) {
			if (remove(o))
				changed = true;
		}
		return changed;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		// Object[] temp = new Object[c.size()];
		// int counter = 0;
		// for (Object o : array) {
		// if (c.contains(o)) {
		// temp[counter] = o;
		// counter++;
		// }
		// }
		// array = (E[]) temp;
		// currentCapacity=counter;

		E[] tempArray = array;
		clear();
		for (Object o : tempArray) {
			if (o != null && c.contains(o)) {
				add((E) o);
			}
		}
		return true;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		array = (E[]) new Object[DEFAULT_SIZE];
		currentCapacity = 0;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if (index > size()) {
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		if (index > size()) {
			throw new IndexOutOfBoundsException();
		}
		E previousElement = array[index];
		array[index] = element;
		return previousElement;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		if (index >= array.length) {
			extend(index + 1);
		}
		if (array[index] != null) {
			shift(1, index);
		}

		if (index > size()) {
			currentCapacity = index + 1;
		}

		array[index] = element;

	}

	private void shift(int shiftBy, int index) {

		if (size() + shiftBy >= array.length) {
			// shift by wont fit in current array
			E[] temp = (E[]) new Object[array.length + shiftBy];
			for (int i = 0; i < size() + shiftBy; i++) {
				if (i < index)
					temp[i] = array[i];
				else {
					temp[i + shiftBy] = array[i];
				}
			}
			currentCapacity = temp.length;
			array = temp;
		} else {
			// shifted elemets will fit in current array
//			for (int i = index; i < size() + shiftBy; i++) {
//				array[size() + shiftBy - i] = array[i];
//				array[index + i] = null;
//
//			}
			E[] temp = (E[]) new Object[array.length];
			for (int i = 0; i < size() + shiftBy-1; i++) {
				if (i < index)
					temp[i] = array[i];
				else {
					temp[i + shiftBy] = array[i];
				}
			}
			currentCapacity = size()+shiftBy;
			array = temp;
		}

	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		E previousElement = array[index];
		for (int n = index; n < size(); n++) {
			array[n] = array[n + 1];

		}
		// dont need to set the last value null because the it copies
		// the null at the last value. the list never gets full because
		// we always extend it.
		currentCapacity--;
		return previousElement;
	}

	@Override
	public int indexOf(Object o) {
		return indexOf(o, true);
	}

	private int indexOf(Object o, boolean getFirst) {
		// TODO Auto-generated method stub
		int last = -1;

		for (int i = 0; i < size(); i++) {
			if (array[i] == o || array[i].equals(o)) {
				last = i;
				if (getFirst) {
					return i;
				}

			}
		}

		return last;
	}

	@Override
	public int lastIndexOf(Object o) {
		return indexOf(o, false);
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T extends Comparable<T>> void sort(T[] array) {

		T temp;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i].compareTo(array[j]) == -1) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}

	}

	public static String toString(Object[] array) {
		String result = "[";
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				result += String.format("%s]", array[i]);
			} else {
				result += String.format("%s,", array[i]);
			}

		}
		return result;
	}

}
