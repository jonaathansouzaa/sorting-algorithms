package sort;

import org.junit.Test;

public class MergeSortTest {
	
	@Test
	public void positiveTest() {
		int quantidade = 1000;
		int[] vetor = new int[quantidade];
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) (Math.random() * quantidade);
		}
//		int[] vetor = { 10, 20, 15, 7, 1, 25, 9};
		long tempoInicial = System.currentTimeMillis();
		MergeSort mergeSort = new MergeSort();
		mergeSort.mergeSort(vetor, vetor.length);
		long tempoFinal = System.currentTimeMillis();
		
		System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
		System.out.println("Comparações: " + mergeSort.getRetornoDados().get(SortKeys.KEY_COMPARA));
		System.out.println("Troca: " + mergeSort.getRetornoDados().get(SortKeys.KEY_TROCA));
	}
	
}
