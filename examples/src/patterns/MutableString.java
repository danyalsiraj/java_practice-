package patterns;

public class MutableString {
	String string;

	public MutableString(String str) {
		string = str;

	}

	public MutableString() {
		string = "";

	}

	public String replace(char replace, char replaceWith) {
		string = string.replace(replace, replaceWith);
		return string;
	}

	public String append(String str) {
		string = string + str;
		return string;
	}

	public String toString() {

		return string;
	}

}
