/*public class operators {

	public static void main (String[] args)
	
	{
		int value=60;
		
		boolean isCar=false;
		if(value==50)
		{
			isCar=true;
			
		}
		boolean wasCar= isCar ? true: false;
		// if isCar is true return true otherwise return false
		//https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html 
		
		if (wasCar==true)
		{
			System.out.println("wasCar is true");
		}
		else 
		{
			System.out.println("wasCar is flase");
		}
	}
	
}*/

// task
//http://www.cs.bilkent.edu.tr/~guvenir/courses/CS101/op_precedence.html 
public class operators 
{
	public static void main (String[] args)
	{
		double num1, num2,add, multi, mod;
		num1=20;
		num2=80;
		add=num1+num2;
		multi=add*25;
		mod= multi%40;
		if (mod<=20)
		{
			System.out.println(mod+ " over");
		}
		else
		{
			System.out.println(mod+" under");
		}
		
		
		
	}
	
	
}