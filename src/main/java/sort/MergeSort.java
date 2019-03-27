package sort;

import java.util.HashMap;
import java.util.Map;

public class MergeSort {
	
	private Long troca;
	private Long compara;
	
	public MergeSort() {
		this.troca = 0L;
		this.compara = 0L;
	}
	
	public void mergeSort(int[] vetor, int lenght) {
		if (lenght < 2) {
			return;
		}
		int mid = lenght / 2;
		int[] left = new int[mid];
		int[] right = new int[lenght - mid];

		for (int count = 0; count < mid; count++) {
			troca++;
			left[count] = vetor[count];
		}
		for (int count = mid; count < lenght; count++) {
			troca++;
			right[count - mid] = vetor[count];
		}
		mergeSort(left, mid);
		mergeSort(right, lenght - mid);

		merge(vetor, left, right, mid, lenght - mid);
	}

	public void merge(int[] vetor, int[] leftArray, int[] rightArray, int left, int right) {
		int leftColumn = 0, rightColumn = 0, k = 0;
		while (leftColumn < left && rightColumn < right) {
			if (leftArray[leftColumn] <= rightArray[rightColumn]) {
				troca(vetor, k++, leftArray, leftColumn++);
				compara++;
			} else {
				troca(vetor, k++, rightArray, rightColumn++);
				compara++;
			}
		}
		while (leftColumn < left) {
			troca(vetor, k++, leftArray, leftColumn++);
		}
		while (rightColumn < right) {
			troca(vetor, k++, rightArray, rightColumn++);
		}
	}
	
	public void troca(int vetor[], int posicaoVetor, int[] vetorAuxiliar, int posicaoAuxiliar) {
		vetor[posicaoVetor] = vetorAuxiliar[posicaoAuxiliar];
		troca++;
	}
	
	public Map<String, Long> getRetornoDados() {
		Map<String, Long> retornoDados = new HashMap<String, Long>();
		retornoDados.put(SortKeys.KEY_TROCA, troca);
		retornoDados.put(SortKeys.KEY_COMPARA, compara);
		return retornoDados;
	}

}
