package patterns;

public class Logger {

	private Logger() {

	}

	static Logger logger;

	public static Logger getInstance() {
		if (logger == null) {
			logger = new Logger();
		}
		return logger;
	}

	public void info(String str) {
		System.out.println(str);
	}

	public void error(String error) {
		System.err.println(error);
	}

}
