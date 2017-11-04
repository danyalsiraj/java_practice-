package Test.weeklyCodingChallange;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import weeklyCodingChallange.ReverseSentence;

public class ReverseSentenceTest {

	@Test
	public void reverseTest() {
		assertEquals("zaid is name my", ReverseSentence.reverse("my name is zaid"));
		assertEquals("", ReverseSentence.reverse(""));
		assertEquals("a", ReverseSentence.reverse("a"));

	}

}
