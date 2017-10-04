package Test.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import person.Person;
import utils.Array;

public class MyTest {

	@Test
	public void addToArray() {
		Array<Person> tester = new Array<Person>();
		assertTrue("person can not be added", tester.add(new Person("da", "ss")));
		assertEquals("size should be 1", 1, tester.size());
		assertEquals("first element does not equal expected", new Person("da", "ss"), tester.get(0));
	}

	@Test
	public void removeFromArrray() {
		Array<Person> tester = new Array<Person>();
		assertTrue("person can not be added", tester.add(new Person("da", "ss")));
		assertTrue("person can not be removed", tester.remove(tester.get(0)));// remove
																				// by
																				// object
		assertEquals("size should be 0", 0, tester.size());
		assertTrue("person can not be added", tester.add(new Person("da", "ss")));
		assertEquals("size should be 1", 1, tester.size());
		assertEquals("person can not be removed", new Person("da", "ss"), tester.remove(0));// remove
																							// by
																							// index
		assertEquals("size should be 0", 0, tester.size());

	}

	@Test
	public void addAtIndexAndShift() {
		Array<Person> tester = new Array<Person>();
		assertEquals("size should be 0", 0, tester.size());
		assertTrue("person can not be added", tester.add(new Person("da", "ss")));
		assertEquals("size should be 1", 1, tester.size());
		assertTrue("person can not be added", tester.add(new Person("da1", "ss1")));
		assertEquals("size should be 2", 2, tester.size());
		assertEquals("first element does not equal expected", new Person("da", "ss"), tester.get(0));
		assertEquals("first element does not equal expected", new Person("da1", "ss1"), tester.get(1));

		tester.add(1, new Person("da2", "ss2"));// adds another element at index
												// 1, where another element
												// already exists
		assertEquals("size should be 3", 3, tester.size());// check if the
															// element was added
															// and the size is
															// increased
		assertEquals("first element does not equal expected", new Person("da", "ss"), tester.get(0));
		assertEquals("first element does not equal expected", new Person("da1", "ss1"), tester.get(2));// checks
																										// if
																										// the
																										// element
																										// was
																										// moved
																										// to
																										// index
																										// 2,
																										// previously
																										// at
																										// index
																										// 1
		assertEquals("first element does not equal expected", new Person("da2", "ss2"), tester.get(1));// checks
																										// if
																										// the
																										// element
																										// was
																										// added
																										// at
																										// index
																										// 1

	}

}
