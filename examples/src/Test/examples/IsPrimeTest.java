package Test.examples;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import examples.IsPrime;

public class IsPrimeTest {
	@Test
	public void primeTest() {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		PrintStream print = new PrintStream(bos);
		System.setOut(print);
		IsPrime prime = new IsPrime();
		prime.checkPrime(2);
		prime.checkPrime(2, 1);
		prime.checkPrime(2, 1, 3);
		prime.checkPrime(2, 1, 3, 4, 5);

		Scanner scan = new Scanner(new String(bos.toByteArray()));
		assertEquals("2", scan.nextLine());
		assertEquals("2", scan.nextLine());
		assertEquals("2 3", scan.nextLine());
		assertEquals("2 3 5", scan.nextLine());

	}
}
