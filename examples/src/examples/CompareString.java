package examples;

import java.util.Scanner;

public class CompareString {

	public static void main (String[] args)
	{
		System.out.println("enter string 1");
		Scanner scan=new Scanner(System.in);
		String string1=scan.nextLine();
		System.out.println("enter string 2");
		String string2=scan.nextLine();
		if (isEqual(string1,string2))
			System.out.println("they are equal");
		else 
			System.out.println("they are not equal");
		
		
	}
	
	/**
	 * Compares two strings while ignoring case and returns true if both equal
	 * @param string1
	 * @param string2
	 * @return
	 */
	static boolean isEqual (String string1, String string2 )
	{
		if (string1==null || string2==null)
			return false;
		
		return (string1.equalsIgnoreCase(string2));
	}
}
