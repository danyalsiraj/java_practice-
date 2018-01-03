package examples;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort implements ISort {

	@Override
	public void sort(int[] array) {
		// TODO Auto-generated method stub
		List<Integer> sorted = sort(Arrays.stream(array).boxed().collect(Collectors.toList()));
		for (int i = 0; i < array.length; i++) {
			array[i] = sorted.get(i);
		}
	}

	public List<Integer> sort(List<Integer> array) {
		if (array == null || array.size() == 0) {
			return new LinkedList<Integer>();
		}
		int pivotValue = array.get(0);
		List<Integer> L = new LinkedList<Integer>();
		List<Integer> E = new LinkedList<Integer>();
		List<Integer> G = new LinkedList<Integer>();

		for (Integer value : array) {
			if (value < pivotValue) {
				L.add(value);
			} else if (value > pivotValue) {
				G.add(value);
			} else {
				E.add(value);
			}
		}

		L = sort(L);
		G = sort(G);

		L.addAll(E);
		L.addAll(G);
		return L;

	}

}
