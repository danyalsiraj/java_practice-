package collections;

import java.util.Queue;

public interface IPriorityQueue<T> extends Queue<T> {

	public default void insert(T value) {
		add(value);
	}

	public default T findMax() {
		return peek();
	}

}
