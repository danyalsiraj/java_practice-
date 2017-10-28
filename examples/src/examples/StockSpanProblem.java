package examples;

public class StockSpanProblem {

	public static int[] span(int[] dailyPrice) {
		int[] span = new int[dailyPrice.length];
		for (int i = 0; i < dailyPrice.length; i++) {
			span[i] = getSpan(i, dailyPrice);
		}

		return span;
	}

	public static int getSpan(int day, int[] dailyPrice) {
		int ConsDays = 0;

		for (int i = day; i >= 0; i--) {
			if (dailyPrice[i] <= dailyPrice[day]) {
				ConsDays++;
			} else {
				break;
			}
		}
		return ConsDays;
	}

}
