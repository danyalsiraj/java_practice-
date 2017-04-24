
public class methods {
	public static void main(String[] args) {
		boolean gameOver = true;
		int score = 5000;
		int level = 5;
		int bonus = 100;
		// another way to do the previous example isby using methods

		calculateScore(gameOver, score, level, bonus);
		// pass the variables to the method for calculating the score
		// we can also pass the values directly
		calculateScore(true, 2000, 3, 500);
	}
	// leave void if there is no return
	// use the return typr if the method is returning somthing (int,double...)

	public static void calculateScore(boolean gameOver, int score, int level, int bonus) {
		if (gameOver) {
			int finalScore = score + (level * bonus);
			System.out.println("final score is " + finalScore);
		}

	}

}
