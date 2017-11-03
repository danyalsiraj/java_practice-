package Test.collections;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import collections.APriorityQueue;
import collections.IPriorityQueue;
import collections.MinHeap;

@RunWith(Parameterized.class)
public class PriorityQueueTest {

	@Parameters
	public static Class[] data() {

		return new Class[] { APriorityQueue.class, MinHeap.class };

	}

	@Parameter
	public Class qClass;

	IPriorityQueue<Integer> queue;

	@Before
	public void setUp() throws InstantiationException, IllegalAccessException {
		queue = (IPriorityQueue<Integer>) qClass.newInstance();
	}

	@Test
	public void priorityQueueTest() {

		int[] array = { 22, 2, 15, 10, 19, 13, 20, 3, 7, 11, 14, 8, 1, 4, 5 };
		for (int a : array) {
			queue.insert(a);
		}
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			remove(array[i], array.length - i);
		}

	}

	public void remove(Integer expected, int size) {
		assertEquals(size, queue.size());
		assertEquals(expected, queue.findMin());
		assertEquals(expected, queue.remove());
		assertEquals(size - 1, queue.size());

	}

}
