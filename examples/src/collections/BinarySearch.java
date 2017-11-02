package collections;

public class BinarySearch {

	public static <T extends Comparable<T>> boolean hasValue(T[] array, T value) {
		
		if (array==null || value==null || array.length==0){
			return false;
		}
		return hasValue(array, value, 0, array.length - 1);

	}

	private static <T extends Comparable<T>> boolean hasValue(T[] array, T value, int start, int end) {

		int midPoint = (end + start) / 2;
		if (value.equals(array[midPoint])) {
			return true;
		} else if (start >= end) {
			return false;
		}

		if (value.compareTo(array[midPoint]) == -1) {
			end = midPoint - 1;

		} else if (value.compareTo(array[midPoint]) == 1) {
			start = midPoint + 1;

		}
		return hasValue(array, value, start, end);
	}

}
