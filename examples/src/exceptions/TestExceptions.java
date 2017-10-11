package exceptions;

public class TestExceptions {

	public static void main(String[] args) {
		try {
			testExc();
			System.out.println("asdasd sdas adsd");
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
			System.out.println("caught");
		} finally {
			System.out.println("always do this");
		}
	}

	public static void testExc() {

		throw new UnsupportedOperationException("dasdas");
		// throw new NullPointerException();
	}

}
