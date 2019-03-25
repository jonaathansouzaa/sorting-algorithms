package sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortTest {
	
	@Test
	public void positiveTest() {
		int[] actual = { 5, 1, 6, 2, 3, 4 };
		int[] expected = { 1, 2, 3, 4, 5, 6 };
		MergeSort.mergeSort(actual, actual.length);
		assertArrayEquals(expected, actual);
	}
}
