package src;

import src.State;

public class MergeSort{

	private static State[] aux;

	private static boolean less(State v, State w) {
		return v.compareBoth(w);
	}

	public static void sort(State[] a) {
		aux = new State[a.length];
		sort(a, 0, a.length-1);
	}

	private static void sort(State[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}

	private static void merge(State[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		// Copy a to aux
		for (int k=lo; k<=hi; k++)
			aux[k] = a[k];
		// Merge arrays
		for (int k=lo; k<=hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}
}
