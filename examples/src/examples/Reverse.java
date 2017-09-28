package examples;

import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		System.out.println("enter a string");
		Scanner scan = new Scanner(System.in);
		String string1 = scan.nextLine();
		System.out.println("reversed string is " + reverse(string1));

	}

	static String reverse(String string1) {
		if (string1==null)
			return null;
		
//		char[] charArray = string1.toCharArray();
//		for (int i = 0 ; i < string1.length()/2; i++) {
//			char temp = charArray[i];
//			charArray[i] = charArray[string1.length() - 1 - i];
//			charArray[string1.length() - 1 - i] = temp;
//		}
//		return new String(charArray);
		String resultString ="";
		for(int i = string1.length() -1; i >=0; i--) {
			resultString += string1.charAt(i);
		}

		return resultString;
	}
}
