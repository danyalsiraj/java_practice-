package examples;

public class MergeSort implements ISort {

	@Override
	public void sort(int[] array) {
		// TODO Auto-generated method stub
		sort(array, 0, array.length - 1);

	}

	public void sort(int[] array, int start, int end) {
		// divide in 2 parts size n/2 approx
		// sort both parts
		// merge sorted parts
		int size = end - start + 1;
		int e1 = (end + start) / 2;
		int s2 = e1 + 1;
		if (size <= 1) {
			return;
		}
		sort(array, start, e1);
		sort(array, s2, end);
		merge1(array, start, e1, s2, end);

	}

	public static void merge1(int[] array, int s1, int e1, int s2, int e2) {
		while (s1 <= e2 && s2 <= e2) {

			if (array[s1] > array[s2]) {
				int temp = array[s2];
				array[s2] = array[s1];
				array[s1] = temp;
				s1++;
			} else {
				s2++;

			}
		}
	}

	public static void merge2(int[] array, int s1, int e1, int s2, int e2) {

		int startDes = s1;
		int[] temp = new int[e2 - s1];
		int index = 0;
		while (index < temp.length - 1) {

			if (array[s1] < array[s2] || s2 == e2) {
				temp[index] = array[s1];
				s1++;
			} else {
				temp[index] = array[s2];
				s2++;
			}
			index++;

		}
		System.arraycopy(temp, 0, array, startDes, temp.length);

	}

	// for (int i = 0; i < temp.length; i++) {
	// if (array[i + s1] < array[i + s2]) {
	// temp[i] = array[i + s1];
	// s2--;
	// } else {
	// temp[i] = array[i + s2];
	// s1--;
	//
	// }
	// }

	// }

}
