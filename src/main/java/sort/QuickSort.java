package sort;

import java.util.HashMap;
import java.util.Map;

public class QuickSort {

	private Long troca;
	private Long compara;

	public QuickSort() {
		this.troca = 0L;
		this.compara = 0L;
	}

	public void quickSort(int[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int pivo = separar(vetor, inicio, fim);
			quickSort(vetor, inicio, pivo - 1);
			quickSort(vetor, pivo + 1, fim);
		}
	}

	private int separar(int[] vetor, int inicio, int fim) {
		int pivo = vetor[inicio];
		int esquerda = inicio + 1;
		int direita = fim;
		while (esquerda <= direita) {
			if (vetor[esquerda] <= pivo) {
				compara++;
				esquerda++;
			} else if (pivo < vetor[direita]) {
				compara += 2;
				direita--;
			} else {
				compara += 2;
				troca(vetor, esquerda, direita);
				esquerda++;
				direita--;
			}
		}
		troca(vetor, inicio, direita);
		return direita;
	}

	private void troca(int[] vetor, int esquerda, int direita) {
		int temp = vetor[esquerda];
		vetor[esquerda] = vetor[direita];
		vetor[direita] = temp;
		troca++;
	}

	public Map<String, Long> getRetornoDados() {
		Map<String, Long> retornoDados = new HashMap<String, Long>();
		retornoDados.put(SortKeys.KEY_COMPARA, compara);
		retornoDados.put(SortKeys.KEY_TROCA, troca);
		return retornoDados;
	}

}
