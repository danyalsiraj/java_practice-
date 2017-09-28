package examples;

import java.util.Scanner;
/**
 * 
 * @author dany
 *
 */
public class Anagram {
	public static void main(String[] args) {
		System.out.println("enter string 1");
		Scanner scan= new Scanner(System.in);
		String string1= scan.nextLine();
		System.out.println("enter string 2");
		String string2= scan.nextLine();
		
		if (isAnagram(string1,string2))
			System.out.println("they are anagrams");
		else 
			System.out.println("they are not anagrams");
		

	}
	public static boolean isAnagram (String string1,String string2)
	{
		string1=Sort.sort(string1);
		string2=Sort.sort(string2);
		return CompareString.isEqual(string1, string2);
	}
}
