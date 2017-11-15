package Test.pattern;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import patterns.MutableString;

public class MutableStringTest {
	@Test
	public void replaceTest() {

		MutableString str = new MutableString("danyal");
		assertEquals("danyal", str.toString());
		assertEquals("dbnybl", str.replace('a', 'b'));
		assertEquals("dbnybl", str.toString());

	}

	@Test
	public void appendTest() {
		MutableString str = new MutableString("danyal");
		assertEquals("danyal", str.toString());
		assertEquals("danyalss", str.append("ss"));
		assertEquals("danyalss", str.toString());

	}

}
