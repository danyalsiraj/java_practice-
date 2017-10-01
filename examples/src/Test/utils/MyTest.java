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
		assertEquals("size should be 1",1,tester.size());
		assertEquals("first element does not equal expected",new Person("da", "ss") ,tester.get(0));
	}

}
