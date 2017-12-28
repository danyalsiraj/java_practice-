package examples;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SortTest {
	@Test
	public void sortTest() {
		int[] array = { 2, 3, 5, 6, 1, 7 };
		int[] expected = { 1, 2, 3, 5, 6, 7 };
		InsertionSort sortArray = new InsertionSort();
		sortArray.sort(array);
		// assertTrue(Arrays.equals(array, expected));
		assertArrayEquals(expected, array);

	}

}
