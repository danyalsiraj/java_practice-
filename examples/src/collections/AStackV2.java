package collections;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class AStackV2<T> extends Array<T> implements Deque<T> {

	@Override
	public void addFirst(T e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addLast(T e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean offerFirst(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offerLast(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T pollFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T pollLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peekFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peekLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeLastOccurrence(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
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
		return get(size() - 1);
	}

	@Override
	public void push(T e) {
		// TODO Auto-generated method stub
		add(e);
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return remove(size() - 1);
	}

	@Override
	public Iterator<T> descendingIterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
