package sort;

import java.util.HashMap;
import java.util.Map;

public class ShellSort {
	
	private Long troca;
	private Long compara;
	
	public ShellSort() {
		this.troca = 0L;
		this.compara = 0L;
	}

	/* function to sort arr using shellSort */
	public void shellSort(int vetor[]) {
		int tamanho = vetor.length;

		// Start with a big gap, then reduce the gap
		for (int gap = tamanho / 2; gap > 0; gap /= 2) {
			// Do a gapped insertion sort for this gap size.
			// The first gap elements a[0..gap-1] are already
			// in gapped order keep adding one more element
			// until the entire array is gap sorted
			for (int contadorUm = gap; contadorUm < tamanho; contadorUm += 1) {
				// add a[i] to the elements that have been gap
				// sorted save a[i] in temp and make a hole at
				// position i
				int temp = vetor[contadorUm];

				// shift earlier gap-sorted elements up until
				// the correct location for a[i] is found
				int contadorDois;
				for (contadorDois = contadorUm; contadorDois >= gap && vetor[contadorDois - gap] > temp; contadorDois -= gap) {
					compara++;
					vetor[contadorDois] = vetor[contadorDois - gap];
				}

				// put temp (the original a[i]) in its correct
				// location
				vetor[contadorDois] = temp;
				troca++;
			}
		}
	}

	public Map<String, Long> getRetornaDados() {
		Map<String, Long> retornoDados = new HashMap<String, Long>();
		retornoDados.put(SortKeys.KEY_TROCA, troca);
		retornoDados.put(SortKeys.KEY_COMPARA, compara);
		return retornoDados;
	}

}