package Test.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import collections.Array;
import collections.LinkedList;
import person.Person;

public class LinkedListTest {
	@Test
	public void addToArray() {
		LinkedList<String> tester = new LinkedList<String>();
		assertTrue("string can not be added", tester.add("danyal"));
		assertEquals("size should be 1", 1, tester.size());
		assertEquals("first element does not equal expected", "danyal", tester.get(0));
		assertTrue("string can not be added", tester.add("zaid"));
		assertEquals("size should be 2", 2, tester.size());
		assertEquals("first element does not equal expected", "zaid", tester.get(1));
		assertEquals("zaid", tester.remove(1));
		assertEquals("size should be 1", 1, tester.size());
		assertEquals("danyal", tester.remove(0));
		assertEquals("size should be 0", 0, tester.size());
		assertTrue("string can not be added", tester.add("danyal"));
		assertTrue("string can not be added", tester.add("zaid"));
		assertEquals("danyal", tester.remove(0));
		assertEquals("size should be 1", 1, tester.size());

	}

	@Test
	public void removeObject() {
		LinkedList<String> tester = new LinkedList<String>();
		for (char i = 'a'; i <= 'j'; i++) {
			tester.add("" + i);
		}
		assertEquals("size should be 10", 10, tester.size());
		assertTrue(tester.remove("a"));
		assertEquals("size should be 9", 9, tester.size());
		assertEquals("first element does not equal expected", "b", tester.get(0));
		assertTrue(tester.remove("j"));
		assertEquals("size should be 8", 8, tester.size());
		assertEquals("first element does not equal expected", "i", tester.get(7));
		tester.add("c");
		assertEquals("first element does not equal expected", "c", tester.get(8));
		assertTrue(tester.remove("c"));
		assertEquals("first element does not equal expected", "d", tester.get(1));
		assertEquals("size should be 8", 8, tester.size());
		assertEquals("first element does not equal expected", "c", tester.get(7));
		assertFalse(tester.remove("z"));
		assertEquals("size should be 8", 8, tester.size());

	}

	@Test
	public void setAtIndex() {
		LinkedList<String> tester = new LinkedList<String>();
		for (char i = 'a'; i <= 'j'; i++) {
			tester.add("" + i);
		}
		assertEquals("size should be 10", 10, tester.size());
		assertEquals("returned element should be a", "a", tester.set(0, "danyal"));
		assertEquals("size should be 10", 10, tester.size());
		assertEquals("returned element should be a", "j", tester.set(9, "danyal"));
		tester.add("zaid");
		assertEquals("returned element should be zaid", "zaid", tester.get(10));
		assertEquals("size should be 11", 11, tester.size());
		assertEquals("returned element should be a", "c", tester.set(2, "danyal"));
		assertEquals("size should be 10", 11, tester.size());

	}

	@Test
	public void addAtIndex() {
		LinkedList<String> tester = new LinkedList<String>();
		for (char i = 'a'; i <= 'j'; i++) {
			tester.add("" + i);
		}
		assertEquals("size should be 10", 10, tester.size());
		tester.add(0, "dany");
		assertEquals("size should be 11", 11, tester.size());
		assertEquals("returned element should be zaid", "dany", tester.get(0));

		tester.add(10, "dany");
		assertEquals("size should be 12", 12, tester.size());
		assertEquals("returned element should be j", "j", tester.get(11));
		assertEquals("returned element should be dany", "dany", tester.get(10));

		tester.add(3, "dany");
		assertEquals("size should be 13", 13, tester.size());
		assertEquals("returned element should be dany", "dany", tester.get(3));
		assertEquals("returned element should be b", "b", tester.get(2));
		assertEquals("returned element should be c", "c", tester.get(4));

	}
	
	@Test 
	public void itteratorTest(){
		LinkedList<String> tester = new LinkedList<String>();
		for (char i = 'a'; i <= 'j'; i++) {
			tester.add("" + i);
		}
		Iterator<String> testIterator= tester.iterator();
		for (char i = 'a'; i <= 'j'; i++) {
			assertTrue("it does not have next value",testIterator.hasNext());
			assertEquals(""+i, testIterator.next());
		}
		assertFalse("it has a next value",testIterator.hasNext());

		
		
	}

}
