package Test.pattern;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import patterns.Logger;

public class LoggerTest {
	@Test
	public void LoggerTest() {
		// writing to system out and err stream
		Logger log = Logger.getInstance();
		log.info("info");
		log.error("error");
		assertTrue(Logger.getInstance() == log);// checking singleton pattern by
												// comparing memory address

	}

}
