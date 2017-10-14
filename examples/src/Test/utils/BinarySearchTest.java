package Test.utils;

import utils.BinarySearch;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void binarySearchTestEmptyArray() {
		Integer[] array = new Integer[0];
		assertFalse("it has the value", BinarySearch.hasValue(array, 1));

	}

	@Test
	public void binarySearchTestEvenArray() {
		Integer[] array = new Integer[10];
		for (int i = 0; i < 10; i++) {
			array[i] = i;
		}
		assertTrue("it does not have the value", BinarySearch.hasValue(array, 1));
		assertTrue("it does not have the value", BinarySearch.hasValue(array, 8));
		assertFalse("it has the value", BinarySearch.hasValue(array, 12));


	}

	@Test
	public void binarySearchTestOddArray() {
		Integer[] array = new Integer[10];
		for (int i = 0; i < 9; i++) {
			array[i] = i;
		}
		assertTrue("it does not have the value", BinarySearch.hasValue(array, 1));
		assertTrue("it does not have the value", BinarySearch.hasValue(array, 8));
		assertFalse("it does !not have the value", BinarySearch.hasValue(array, 12));

	}

}
