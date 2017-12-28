package examples;

public class InsertionSort implements ISort {

	public void sort(int[] array) {
		int j, temp;

		for (int i = 1; i < array.length - 1; i++) {
			j = i - 1;
			temp = array[i];
			while (j >= 0 && temp < array[j]) {
				array[j + 1] = array[j];
				array[j] = temp;
				j--;
			}

		}

	}
}
