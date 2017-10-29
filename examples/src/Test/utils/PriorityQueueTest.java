package Test.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import utils.APriorityQueue;
import utils.IPriorityQueue;

public class PriorityQueueTest {
	@Test
	public void priorityQueueTest() {

		APriorityQueue<Integer> queue = new APriorityQueue<Integer>();
		queue.insert(8);
		queue.insert(2);
		queue.insert(3);
		queue.insert(5);
		remove(8, queue, 4);
		remove(5, queue, 3);
		remove(3, queue, 2);
		remove(2, queue, 1);

	}

	public void remove(Integer expected, IPriorityQueue<Integer> queue, int size) {
		assertEquals(size, queue.size());
		assertEquals(expected, queue.findMax());
		assertEquals(expected, queue.remove());
		assertEquals(size - 1, queue.size());

	}

}
