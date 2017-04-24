
public class if_else_then {

	public static void main(String[] args) {
		boolean gameOver = true;
		int score = 4000;
		int level = 5;
		int bonus = 100;

		// we dont have to use code block if there is only one line after the
		// test/comparison . {}
		// {} --> code block
		/*
		 * if (score<5000 && score>1000){ System.out.
		 * println("your score isless than 5000 and greater than 1000"); }else
		 * if(score <1000){ System.out.println("score less than 1000"); } else {
		 * System.out.println("score  is more than 5000"); }
		 */
		// variable created outside the code block can be accessed inside
		// variable created inside the code block cannot be accessed outside
		// variable inside code block is called scope

		if (gameOver == true) {// can also be written as if(gameOver)
			int finalScore = score + (level * bonus); // finalScore can not be
														// accessed outside the
														// codeblock
			System.out.println("your final score is : " + finalScore);
		}
	//challange 
		//print a second score on screen with the following
		// score set to 1000
		//level set to 8
		// bonus set to 200
		// make sure the first printout above still display aswell
		if (gameOver){
			score=10000;
			level=8;
			bonus=200;
			int finalScore=score+(level*bonus);
			System.out.println("your second score is: "+ finalScore);
			
		}
	
	}
}
