package Test.examples;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import examples.StockSpanProblem;

public class StockSpanTest {

	@Test
	public void stockSpanTest() {
		int[] prices = { 100, 80, 60, 70, 60, 75, 85 };
		int[] expected = { 1, 1, 1, 2, 1, 4, 6 };
		assertArrayEquals(expected, StockSpanProblem.span(prices));
	}
}
