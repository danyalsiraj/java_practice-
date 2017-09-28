package examples;

import java.util.Scanner;

public class Sort {

	public static void main(String[] args)
	{
		System.out.println("enter a string");
		Scanner scan= new Scanner(System.in);

		System.out.println("ypur sorted string is "+ sort(scan.nextLine()));
//		System.out.println("ypur sorted string is "+ sort(null));
	}
	/**
	 * this method sorts the string lexographicaly 
	 * @param string1
	 * @return
	 */
	static String sort(String string1)
	{
		if(string1==null)
			return null;
		
		// "abc".length() == 3
		// "abc".charAt(0) == a
		// "abc".charAt(3) == ERROR index out of bounds exception
		// "abc".toCharArray() => char ['a','b','c']
		// charArray.length == 3
		// charArray[0] == 'a'
		// charArray[3] == ERROR IoB
		// charArray[2] == 'c'
		// String test = new String(charArray);
		// test.equals("abc") == true
		int length=string1.length();
		
		char []charArray= string1.toCharArray();
		
		for (int i=0;i<length;i++)
		{
			for (int j=i+1;j<length;j++)
			{
				if (charArray[i]>charArray[j])
				{
					char temp=charArray[i];
					charArray[i]=charArray[j];
					charArray[j]=temp;
				}
			}
			
		}
		return new String(charArray);
		
	}
	
}
