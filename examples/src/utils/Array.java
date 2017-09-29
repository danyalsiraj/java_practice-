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
		return size() > 0;
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
		E[] temp = (E[]) new Object[size() * 2];

		for (int i = 0; i < size(); i++) {
			temp[i] = array[i];
		}
		array = temp;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		for (int i = 0; i < size(); i++) {
			if (array[i].equals(o)) {
				array[i] = array[i + 1];
				for (int n = i; n < size(); i++) {
					array[n] = array[n + 1];

				}
				// dont need to set the last value null because the it copies
				// the null at the last value. the list never gets full because
				// we always extend it.
				return true;
			}

		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
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

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub

	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
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

}
