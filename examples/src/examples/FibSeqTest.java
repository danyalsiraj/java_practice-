package examples;

import org.junit.Test;
import static org.junit.Assert.*;

public class FibSeqTest {
	@Test
	public void fibTest() {

		assertEquals(1, FibSeq.fibSeq(2));
		assertEquals(55, FibSeq.fibSeq(10));
		assertEquals(610, FibSeq.fibSeq(15));
		assertEquals(1, FibSeq.fibSeq(1));

	}
	
	@Test
	public void fibTest2() {

		assertEquals(1, FibSeq.fibSeq2(2));
		assertEquals(55, FibSeq.fibSeq2(10));
		assertEquals(610, FibSeq.fibSeq2(15));
		assertEquals(1, FibSeq.fibSeq2(1));

	}

}
