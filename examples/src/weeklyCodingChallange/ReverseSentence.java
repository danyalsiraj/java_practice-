package weeklyCodingChallange;

public class ReverseSentence {

	public static String reverse(String sentence) {
		if (sentence == null || sentence.length() < 2) {
			return sentence;
		}
		String[] reverse = sentence.split(" ");

		StringBuffer reverseSent = new StringBuffer(sentence.length());
		for (int i = reverse.length - 1; i >= 0; i--) {
			reverseSent.append(reverse[i]);
			if (i > 0) {
				reverseSent.append(" ");
			}

		}
		return reverseSent.toString();

	}

}
