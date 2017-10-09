package utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<T> implements List<T> {

	public class Node<T> {
		T value;
		Node<T> next;

		public Node(T value) {
			this.value = value;
		}

		public Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
		
		public String toString() {
			return value.toString();
		}

	}

	Node<T> header, tail;

	int size;

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		Node<T> tempNode = header;
		while (tempNode != null) {
			if (tempNode.value.equals(o)) {
				return true;
			}
			tempNode = tempNode.next;
		}
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
	public boolean add(T e) {
		// TODO Auto-generated method stub
		Node<T> node = new Node<T>(e);
		if (size == 0) {
			// Node<T> node=new Node<T>(e);
			header = node;
			tail = node;
			size++;
			return true;

		}
		tail.next = node;
		tail = node;
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub

		if (o == null) {
			return false;
		}
		if (o.equals(header.value)) {
			header = header.next;
			size--;
			return true;
		}
		Node<T> nodeBeforeObj = header;
		while (nodeBeforeObj != null && nodeBeforeObj.next!=null) {
			
			if (nodeBeforeObj.next.value.equals(o)) {
				nodeBeforeObj.next = nodeBeforeObj.next.next;
				if (nodeBeforeObj.next == null) {
					tail = nodeBeforeObj;
				}
				size--;
				return true;

			}
			
			nodeBeforeObj=nodeBeforeObj.next;

		}
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
	public boolean addAll(int index, Collection<? extends T> c) {
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
	public T get(int index) {
		// TODO Auto-generated method stub
		if (index>=size){
			throw new IndexOutOfBoundsException();
		}
		Node<T> tempNode = header;
		for (int i = 0; i < index; i++) {
			tempNode = tempNode.next;

		}
		return tempNode.value;
	}

	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub

	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		if (index == 0) {
			T value = header.value;
			header = header.next;
			size--;
			return value;
		}
		Node<T> nodeBeforeIndex = header;

		for (int i = 0; i < index - 1; i++) {
			nodeBeforeIndex = nodeBeforeIndex.next;
		}

		Node<T> nodeToBeRemoved = nodeBeforeIndex.next;
		T value = nodeToBeRemoved.value;

		nodeBeforeIndex.next = nodeToBeRemoved.next;
		if (index == size() - 1) {
			tail = nodeBeforeIndex;
		}
		size--;
		return value;
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
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
