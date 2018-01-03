package examples;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class SortTest {

	@Parameters
	public static Class[] data() {

		return new Class[] { InsertionSort.class, MergeSort.class, QuickSort.class };

	}

	@Parameter
	public Class sortClass;

	ISort sorter;

	@Before
	public void setUp() throws InstantiationException, IllegalAccessException {
		sorter = (ISort) sortClass.newInstance();
	}

	@Test
	public void sortTest() {
		int[] array = { 2, 3, 5, 6, 1, 7 };
		int[] expected = { 1, 2, 3, 5, 6, 7 };
		sorter.sort(array);
		// assertTrue(Arrays.equals(array, expected));
		assertArrayEquals(expected, array);

	}

}
