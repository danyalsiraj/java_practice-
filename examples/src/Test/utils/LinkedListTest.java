package Test.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import person.Person;
import utils.Array;
import utils.LinkedList;

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
		assertEquals("size should be 1" ,1, tester.size());
		assertEquals("danyal", tester.remove(0));
		assertEquals("size should be 0" ,0, tester.size());
		assertTrue("string can not be added", tester.add("danyal"));
		assertTrue("string can not be added", tester.add("zaid"));
		assertEquals("danyal", tester.remove(0));
		assertEquals("size should be 1" ,1, tester.size());
		
	}
	
	@Test
	public void removeObject(){
		LinkedList<String> tester = new LinkedList<String>();
		for (char i='a';i<='j';i++){
			tester.add(""+i);
		}
		assertEquals("size should be 10" ,10, tester.size());
		assertTrue(tester.remove("a"));
		assertEquals("size should be 9" ,9, tester.size());
		assertEquals("first element does not equal expected", "b", tester.get(0));
		assertTrue(tester.remove("j"));
		assertEquals("size should be 8" ,8, tester.size());
		assertEquals("first element does not equal expected", "i", tester.get(7));
		tester.add("c");
		assertEquals("first element does not equal expected", "c", tester.get(8));
		assertTrue(tester.remove("c"));
		assertEquals("first element does not equal expected", "d", tester.get(1));
		assertEquals("size should be 8" ,8, tester.size());
		assertEquals("first element does not equal expected", "c", tester.get(7));
		assertFalse(tester.remove("z"));
		assertEquals("size should be 8" ,8, tester.size());



		

		
	}

}
