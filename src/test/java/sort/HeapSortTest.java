package sort;

import org.junit.Test;

public class HeapSortTest {

	@Test
	public void positiveTest() {
		int quantidade = 1000;
		int[] vetor = new int[quantidade];
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) (Math.random() * quantidade);
		}
		
		long tempoInicial = System.currentTimeMillis();
		HeapSort heapSort = new HeapSort();
		heapSort.heapSort(vetor);
		long tempoFinal = System.currentTimeMillis();
		
		System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
		System.out.println("Comparações: " + heapSort.getRetornoDados().get(SortKeys.KEY_COMPARA));
		System.out.println("Troca: " + heapSort.getRetornoDados().get(SortKeys.KEY_TROCA));
	}

}
