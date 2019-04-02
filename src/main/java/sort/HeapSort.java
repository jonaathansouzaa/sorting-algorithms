package sort;

import java.util.HashMap;
import java.util.Map;

public class HeapSort {
	
	private Long troca;
	private Long compara;
	
	public HeapSort() {
		this.troca = 0L;
		this.compara = 0L;
	}
	
	public void heapSort(int vetor[]) {
		int tamanho = vetor.length;
		// Build heap (rearrange array)
		for (int contador = tamanho / 2 - 1; contador >= 0; contador--) {
			heapify(vetor, tamanho, contador);
		}
		// One by one extract an element from heap
		for (int contador = tamanho - 1; contador >= 0; contador--) {
			// Move current root to end
			troca(vetor, 0, contador);
			// call max heapify on the reduced heap
			heapify(vetor, contador, 0);
		}
	}
	
	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	void heapify(int vetor[], int tamanho, int contador) {
		int largest = contador; // Initialize largest as root
		int l = 2 * contador + 1; // left = 2*i + 1
		int r = 2 * contador + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < tamanho && vetor[l] > vetor[largest]) {
			compara += 2;
			largest = l;
		}

		// If right child is larger than largest so far
		if (r < tamanho && vetor[r] > vetor[largest]) {
			compara += 2;
			largest = r;
		}

		// If largest is not root
		if (largest != contador) {
			compara++;
			troca(vetor, contador, largest);

			// Recursively heapify the affected sub-tree
			heapify(vetor, tamanho, largest);
		}
	}

	public void troca(int[] vetor, int posicaoUm, int posicaoDois) {
		int temp = vetor[posicaoUm];
		vetor[posicaoUm] = vetor[posicaoDois];
		vetor[posicaoDois] = temp;
		troca++;
	}
	
	public Map<String, Long> getRetornoDados() {
		Map<String, Long> retornoDados = new HashMap<String, Long>();
		retornoDados.put(SortKeys.KEY_TROCA, troca);
		retornoDados.put(SortKeys.KEY_COMPARA, compara);
		return retornoDados;
	}
	
}