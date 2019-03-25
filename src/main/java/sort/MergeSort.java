package sort;

public class MergeSort {
	
	public static void mergeSort(int[] array, int lenght) {
		if (lenght < 2) {
			return;
		}
		int mid = lenght / 2;
		int[] left = new int[mid];
		int[] right = new int[lenght - mid];

		for (int count = 0; count < mid; count++) {
			left[count] = array[count];
		}
		for (int count = mid; count < lenght; count++) {
			right[count - mid] = array[count];
		}
		mergeSort(left, mid);
		mergeSort(right, lenght - mid);

		merge(array, left, right, mid, lenght - mid);
	}

	public static void merge(int[] array, int[] leftArray, int[] rightArray, int left, int right) {
		int leftColumn = 0, rightColumn = 0, k = 0;
		while (leftColumn < left && rightColumn < right) {
			if (leftArray[leftColumn] <= rightArray[rightColumn]) {
				array[k++] = leftArray[leftColumn++];
			} else {
				array[k++] = rightArray[rightColumn++];
			}
		}
		while (leftColumn < left) {
			array[k++] = leftArray[leftColumn++];
		}
		while (rightColumn < right) {
			array[k++] = rightArray[rightColumn++];
		}
	}

}
