package Test.examples;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import examples.PhoneBook;

public class PhoneBookTest {
	@Test
	public void phoneBookTest() {
		PhoneBook book = new PhoneBook();

		book.add("Danyal", 123456789);
		book.add("Danyal1", 2345689);
		assertEquals("Danyal=123456789", book.search("Danyal"));
		assertEquals("Danyal1=2345689", book.search("Danyal1"));
		assertEquals("Not found", book.search("Danyal33"));

	}
}
