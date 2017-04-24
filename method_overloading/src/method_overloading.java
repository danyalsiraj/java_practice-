public class method_overloading {
	// using the same method name with different parameters
	// overloading is different from overwriting
	// we need to create a unique method signature when overloading it in this
	// case the parameters
	// changing the return type doesnot make it unique

	public static void main(String[] args) {
		int theScore = calculateScore("danyal", 500);// uses the first method 2
														// parameter
		System.out.println("new score is " + theScore);

		calculateScore(75);// uses the second method with one parameter

		calculateScore(); // uses the third method no parameter

		// challange:create a method called calcFeetAndInchesToCenti
		// has 2 parameters, feet and inches
		// validate the parameters feet>=0 and 0=<inches<=12
		// if not validated return -1

		// if valid calculate how many centi comprise the feet and inches
		// return that value

		// create second method with one parameter inches
		// validae that its >=0
		// return -1 if not true
		// if true calculte how many feet are in inches
		// now call the othe method and send the the calculate feet and inches
		// to calculate
		//1 inch=2.54cm 1 feet=12 inches 
		double feet=5;
		double inch=8;
		calcFeetAndInchesToCenti(feet, inch);//takes the number of feet and inches to convert to cm
		
		calcFeetAndInchesToCenti(157);// take the number of inches to convert to cm 

	}

	////////////////// challange/////////////////////
	public static double calcFeetAndInchesToCenti(double feet, double inch) {

		if (feet<0 || (inch<0 || inch>12)){
			System.out.println("invalid parameters");
			return -1;
			
		}
		double centi= inch*2.54+feet*12*2.54;
		System.out.println( feet+" ft + "+ inch+ "in = "+centi +" cm" );
		return centi;
		
	}

	public static double calcFeetAndInchesToCenti(double inch) {
		if (inch<0){
			System.out.println("invalid parameter");

			return -1;
		}
		double feet=(int) inch/12;//becasue we only want the integer value so we cast
		double remaininginch= (int)inch % 12;
		double centi=calcFeetAndInchesToCenti(feet, remaininginch); // we can return and call it at the same time 
		System.out.println( inch+" inch = "+centi +" cm" );
		//return calcFeetAndInchesToCenti(feet, remaininginch);
		return centi;
		
	}

	/////////////////////////////////////
	
	public static int calculateScore(String name, int score) {
		System.out.println(name + " scored " + score + " points");
		return score * 1000;
	}

	// first way is to change the name second away is to chage the parameters
	public static int calculateScore(int score) {
		System.out.println("unnamed player scored " + score + "points");
		return score * 1000;

	}

	public static void calculateScore() {
		System.out.println("no-one has scored yet");

	}
}
